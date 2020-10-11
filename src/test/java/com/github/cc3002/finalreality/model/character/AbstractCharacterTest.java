package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
  protected Weapon testWeapon;

  protected static final int LIFE = 100;
  protected static final int DEFENSE = 30;
  protected static final int ATTACK = 15;
  protected static final int MANA = 50;

  /**protected static final String BLACK_MAGE_NAME = "Vivi";
  protected static final String KNIGHT_NAME = "Adelbert";
  protected static final String WHITE_MAGE_NAME = "Eiko";
  protected static final String ENGINEER_NAME = "Cid";
  protected static final String THIEF_NAME = "Zidane";
  protected Map<CharacterClass, String> characterNames;
  protected final int LIFE = 100;
  protected final int DEFENSE = 30;
  protected final int ATTACK = 15;

  protected Axe testAxe;
  protected Bow testBow;
  protected Knife testKnife;
  protected Staff testStaff;
  protected Sword testSword;

  protected static final String AXE_NAME = "Test Axe";
  protected static final String STAFF_NAME = "Test Staff";
  protected static final String SWORD_NAME = "Test Sword";
  protected static final String BOW_NAME = "Test Bow";
  protected static final String KNIFE_NAME = "Test Knife";
  protected final int DAMAGE = 15;
  protected final int SPEED = 10;*/

  @BeforeEach
  void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Weapon("Test", 15, 10, WeaponType.AXE);
    testCharacters = new ArrayList<>();
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    //tryToEquip(testCharacters.get(0));
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**private void tryToEquip(ICharacter character) {
    character.equip(testWeapon);
  }*/

  void checkConstruction(final ICharacter expectedCharacter,
      final ICharacter testEqualCharacter,
      final ICharacter sameClassDifferentCharacter,
      final ICharacter differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }
}
