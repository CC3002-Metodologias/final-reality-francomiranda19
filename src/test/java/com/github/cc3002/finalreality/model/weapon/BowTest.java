package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BowTest extends WeaponTest {

  @BeforeEach
  void setUp() {
    testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT, WeaponType.BOW);
  }

  @Test
  void constructorTest() {
    var expectedBow = new Bow(BOW_NAME, DAMAGE, WEIGHT, WeaponType.BOW);
    var notExpectedBow1 = new Bow("Not Bow", DAMAGE, WEIGHT, WeaponType.BOW);
    var notExpectedBow2 = new Bow(BOW_NAME, 45, WEIGHT, WeaponType.BOW);
    var notExpectedBow3 = new Bow(BOW_NAME, DAMAGE, 5, WeaponType.BOW);
    var notExpectedBow4 = new Bow(BOW_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    var notEqualsTestWeapon = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);

    assertEquals(testBow, testBow);
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertFalse(testBow.equals(notEqualsTestWeapon));
    assertFalse(notExpectedBow1.equals(testBow));
    assertFalse(notExpectedBow2.equals(testBow));
    assertFalse(notExpectedBow3.equals(testBow));
    assertFalse(notExpectedBow4.equals(testBow));
  }

}
