package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.*;

import java.util.EnumMap;
import java.util.Map;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 * @see PlayerCharacter
 */
public class PlayerCharacterTest extends AbstractCharacterTest {

  protected static final String BLACK_MAGE_NAME = "Vivi";
  protected static final String KNIGHT_NAME = "Adelbert";
  protected static final String WHITE_MAGE_NAME = "Eiko";
  protected static final String ENGINEER_NAME = "Cid";
  protected static final String THIEF_NAME = "Zidane";
  protected Engineer engineer;
  protected Knight knight;
  protected Thief thief;
  protected BlackMage blackMage;
  protected WhiteMage whiteMage;

  protected static final String AXE_NAME = "Test Axe";
  protected static final String STAFF_NAME = "Test Staff";
  protected static final String SWORD_NAME = "Test Sword";
  protected static final String BOW_NAME = "Test Bow";
  protected static final String KNIFE_NAME = "Test Knife";
  protected static final int DAMAGE = 15;
  protected static final int SPEED = 10;
  private static final int MAGIC_DAMAGE = 40;

  protected Axe testAxe;
  protected Staff testStaff;
  protected Sword testSword;
  protected Bow testBow;
  protected Knife testKnife;

  protected Map<CharacterClass, String> characterNames;
  protected static final int LIFE = 100;
  protected static final int DEFENSE = 30;
  protected static final int ATTACK = 15;
  protected static final int MANA = 50;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    engineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    knight = new Knight(KNIGHT_NAME, turns, CharacterClass.KNIGHT, LIFE, DEFENSE);
    thief = new Thief(THIEF_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE);
    blackMage = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA);
    whiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA);

    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF, MAGIC_DAMAGE);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);

    characterNames = new EnumMap<>(CharacterClass.class);
    characterNames.put(CharacterClass.BLACK_MAGE, BLACK_MAGE_NAME);
    characterNames.put(CharacterClass.KNIGHT, KNIGHT_NAME);
    characterNames.put(CharacterClass.WHITE_MAGE, WHITE_MAGE_NAME);
    characterNames.put(CharacterClass.ENGINEER, ENGINEER_NAME);
    characterNames.put(CharacterClass.THIEF, THIEF_NAME);

    for (var characterClass :
        characterNames.keySet()) {
      testCharacters.add(
          new PlayerCharacter(characterNames.get(characterClass), turns, characterClass, LIFE, DEFENSE));
    }
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns, LIFE, DEFENSE, ATTACK);
    for (var character : testCharacters) {
      var characterClass = character.getCharacterClass();
      var characterName = characterNames.get(characterClass);
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass, LIFE, DEFENSE), character,
          new PlayerCharacter("Test", turns, characterClass, LIFE, DEFENSE),
          new PlayerCharacter(characterName, turns,
              characterClass == CharacterClass.THIEF ? CharacterClass.BLACK_MAGE
                  : CharacterClass.THIEF, LIFE, DEFENSE));
      assertNotEquals(character, enemy);
    }

  }

  @Test
  void equalsHashTest() {
    var expectedEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var notExpectedEngineer1 = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE + 1, DEFENSE);
    var notExpectedEngineer2 = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE + 1);

    assertEquals(engineer, engineer);
    assertFalse(notExpectedEngineer1.equals(engineer));
    assertFalse(notExpectedEngineer2.equals(engineer));
  }

  @Test
  void engineerEquipWeaponTest() {
    assertNull(engineer.getEquippedWeapon());
    engineer.equipAxe(testAxe);
    assertEquals(testAxe, engineer.getEquippedWeapon());
    engineer.equipBow(testBow);
    assertEquals(testBow, engineer.getEquippedWeapon());
  }

  @Test
  void knightEquipWeaponTest() {
    assertNull(knight.getEquippedWeapon());
    knight.equipSword(testSword);
    assertEquals(testSword, knight.getEquippedWeapon());
    knight.equipAxe(testAxe);
    assertEquals(testAxe, knight.getEquippedWeapon());
    knight.equipKnife(testKnife);
    assertEquals(testKnife, knight.getEquippedWeapon());
  }

  @Test
  void thiefEquipWeaponTest() {
    assertNull(thief.getEquippedWeapon());
    thief.equipSword(testSword);
    assertEquals(testSword, thief.getEquippedWeapon());
    thief.equipStaff(testStaff);
    assertEquals(testStaff, thief.getEquippedWeapon());
    thief.equipBow(testBow);
    assertEquals(testBow, thief.getEquippedWeapon());
  }

  @Test
  void blackMageEquipWeaponTest() {
    assertNull(blackMage.getEquippedWeapon());
    blackMage.equipKnife(testKnife);
    assertEquals(testKnife, blackMage.getEquippedWeapon());
    blackMage.equipStaff(testStaff);
    assertEquals(testStaff, blackMage.getEquippedWeapon());
  }

  @Test
  void whiteMageEquipWeaponTest() {
    assertNull(whiteMage.getEquippedWeapon());
    whiteMage.equipKnife(testKnife);
    assertEquals(testKnife, whiteMage.getEquippedWeapon());
  }

  @Test
  void testMana() {
    assertEquals(50, blackMage.getMana());
    assertEquals(50, whiteMage.getMana());
  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      //character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }

  @Test
  void lifePointsTest() {
    for (var character : testCharacters) {
      assertEquals(100, character.getLifePoints());
    }
  }

  @Test
  void defenseTest() {
    for (var character : testCharacters) {
      assertEquals(30, character.getDefense());
    }
  }
}
