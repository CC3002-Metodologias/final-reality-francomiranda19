package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Sword;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnifeTest extends WeaponTest {

  @BeforeEach
  void setUp() {
    testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);
    var notExpectedKnife1 = new Knife("Not Knife", DAMAGE, WEIGHT, WeaponType.KNIFE);
    var notExpectedKnife2 = new Knife(KNIFE_NAME, 77, WEIGHT, WeaponType.KNIFE);
    var notExpectedKnife3 = new Knife(KNIFE_NAME, DAMAGE, 44, WeaponType.KNIFE);
    var notExpectedKnife4 = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    var notEqualsTestWeapon = new Bow(BOW_NAME, DAMAGE, WEIGHT, WeaponType.BOW);

    assertEquals(testKnife, testKnife);
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertFalse(testKnife.equals(notEqualsTestWeapon));
    assertFalse(notExpectedKnife1.equals(testKnife));
    assertFalse(notExpectedKnife2.equals(testKnife));
    assertFalse(notExpectedKnife3.equals(testKnife));
    assertFalse(notExpectedKnife4.equals(testKnife));
  }

}
