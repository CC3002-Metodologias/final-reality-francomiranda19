package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SwordTest extends WeaponTest {

  @BeforeEach
  void setUp() {
    testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
  }

  @Test
  void constructorTest() {
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
    var notExpectedSword1 = new Sword("Not Sword", DAMAGE, WEIGHT, WeaponType.SWORD);
    var notExpectedSword2 = new Sword(SWORD_NAME, 1, WEIGHT, WeaponType.SWORD);
    var notExpectedSword3 = new Sword(SWORD_NAME, DAMAGE, 2, WeaponType.SWORD);
    var notExpectedSword4 = new Sword(SWORD_NAME, DAMAGE, WEIGHT, WeaponType.STAFF);
    var notEqualsTestWeapon = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);

    assertEquals(testSword, testSword);
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertFalse(testSword.equals(notEqualsTestWeapon));
    assertFalse(notExpectedSword1.equals(testSword));
    assertFalse(notExpectedSword2.equals(testSword));
    assertFalse(notExpectedSword3.equals(testSword));
    assertFalse(notExpectedSword4.equals(testSword));

  }

}
