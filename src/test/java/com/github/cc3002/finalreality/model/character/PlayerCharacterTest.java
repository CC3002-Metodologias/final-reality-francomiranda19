package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.*;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code PlayerCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 * @see PlayerCharacter
 */
public class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String PLAYER_CHARACTER_NAME = "Test Player Character";
  private PlayerCharacter testPlayerCharacter;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testPlayerCharacter = new PlayerCharacter(PLAYER_CHARACTER_NAME, turns, CharacterClass.KNIGHT, LIFE, DEFENSE);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedPlayerCharacter = new PlayerCharacter(PLAYER_CHARACTER_NAME, turns, CharacterClass.KNIGHT, LIFE, DEFENSE);
    var notExpectedPlayerCharacter1 = new PlayerCharacter("Not Player Character", turns, CharacterClass.KNIGHT, LIFE, DEFENSE);
    var notExpectedPlayerCharacter2 = new PlayerCharacter(PLAYER_CHARACTER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var notExpectedPlayerCharacter3 = new PlayerCharacter(PLAYER_CHARACTER_NAME, turns, CharacterClass.KNIGHT, LIFE + 1, DEFENSE);
    var notExpectedPlayerCharacter4 = new PlayerCharacter(PLAYER_CHARACTER_NAME, turns, CharacterClass.KNIGHT, LIFE, DEFENSE + 1);

    assertEquals(testPlayerCharacter, testPlayerCharacter);
    assertEquals(expectedPlayerCharacter, testPlayerCharacter);
    assertEquals(expectedPlayerCharacter.hashCode(), testPlayerCharacter.hashCode());
    assertNotEquals(notExpectedPlayerCharacter1, testPlayerCharacter);
    assertNotEquals(notExpectedPlayerCharacter1.hashCode(), testPlayerCharacter.hashCode());
    assertNotEquals(notExpectedPlayerCharacter2, testPlayerCharacter);
    assertNotEquals(notExpectedPlayerCharacter2.hashCode(), testPlayerCharacter.hashCode());
    assertNotEquals(notExpectedPlayerCharacter3, testPlayerCharacter);
    assertNotEquals(notExpectedPlayerCharacter3.hashCode(), testPlayerCharacter.hashCode());
    assertNotEquals(notExpectedPlayerCharacter4, testPlayerCharacter);
    assertNotEquals(notExpectedPlayerCharacter4.hashCode(), testPlayerCharacter.hashCode());
    assertNotEquals(testPlayerCharacter, new Weapon("Not Player Character", 20, 10, WeaponType.AXE));
  }
}
