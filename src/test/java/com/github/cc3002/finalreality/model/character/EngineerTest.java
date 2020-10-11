package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.*;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest extends PlayerCharacterTest {
  private static final String ENGINEER_NAME = "Test Engineer";
  private Engineer testEngineer;
  private Axe testAxe;
  private Bow testBow;

  @BeforeEach
  void setUp() {
    testEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    testAxe = new Axe("Test Axe", 20, 10, WeaponType.AXE);
    testBow = new Bow("Test Bow", 25, 10, WeaponType.BOW);
  }

  @Test
  void constructorTest() {
    var expectedEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var otherWeaponEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var notExpectedEngineer1 = new Engineer("Not Engineer", turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var notExpectedEngineer2 = new Engineer(ENGINEER_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE);
    var notExpectedEngineer3 = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE + 1, DEFENSE);
    var notExpectedEngineer4 = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE + 1);

    assertEquals(testEngineer, testEngineer);
    assertEquals(expectedEngineer, testEngineer);
    assertEquals(expectedEngineer.hashCode(),testEngineer.hashCode());
    otherWeaponEngineer.equipAxe(testAxe);
    assertNotEquals(otherWeaponEngineer, testEngineer);
    assertNotEquals(otherWeaponEngineer.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer1, testEngineer);
    assertNotEquals(notExpectedEngineer1.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer2, testEngineer);
    assertNotEquals(notExpectedEngineer2.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer3, testEngineer);
    assertNotEquals(notExpectedEngineer3.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer4, testEngineer);
    assertNotEquals(notExpectedEngineer4.hashCode(), testEngineer.hashCode());
    assertFalse(testEngineer.equals(new Thief("Not Engineer", turns, CharacterClass.ENGINEER, LIFE, DEFENSE)));
  }

  @Test
  void equipAxeTest() {
    assertNull(testEngineer.getEquippedWeapon());
    testEngineer.equipAxe(testAxe);
    assertEquals(testAxe, testEngineer.getEquippedWeapon());
    assertNotEquals(testBow, testEngineer.getEquippedWeapon());
  }

  @Test
  void equipBowTest() {
    testEngineer.equipBow(testBow);
    assertEquals(testBow, testEngineer.getEquippedWeapon());
    assertNotEquals(testAxe, testEngineer.getEquippedWeapon());
  }
}
