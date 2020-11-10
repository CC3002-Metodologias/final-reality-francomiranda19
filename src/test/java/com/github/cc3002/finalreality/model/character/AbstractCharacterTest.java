package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.classes.Knight;
import com.github.francomiranda19.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<ICharacter> turns;
  protected List<ICharacter> testCharacters;
  protected Axe testWeapon;

  protected static final int LIFE = 100;
  protected static final int DEFENSE = 10;
  protected static final int MANA = 50;

  /**
   * Setup method.
   */
  @BeforeEach
  void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Axe("Test Weapon", 15, 10);
    testCharacters = new ArrayList<>();

    Enemy testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    Knight testKnight = new Knight("Test Knight", turns, LIFE, DEFENSE);
    testKnight.equipAxe(testWeapon);
    testCharacters.add(testKnight);
    testCharacters.add(testEnemy);
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    assertTrue(turns.isEmpty());
    for (int i = 0; i < testCharacters.size(); i++) {
      testCharacters.get(i).waitTurn();
      try {
        // Thread.sleep is not accurate so this values may be changed to adjust the
        // acceptable error margin.
        // We're testing that the character waits approximately 1 second.
        Thread.sleep(900);
        assertEquals(i, turns.size());
        Thread.sleep(200);
        assertEquals(i + 1, turns.size());
        assertEquals(testCharacters.get(0), turns.peek());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
