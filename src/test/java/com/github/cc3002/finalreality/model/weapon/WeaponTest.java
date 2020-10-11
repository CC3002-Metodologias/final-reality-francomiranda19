package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {

  protected static final String WEAPON_NAME = "Test Weapon";
  protected static final String AXE_NAME = "Test Axe";
  protected static final String STAFF_NAME = "Test Staff";
  protected static final String SWORD_NAME = "Test Sword";
  protected static final String BOW_NAME = "Test Bow";
  protected static final String KNIFE_NAME = "Test Knife";
  protected static final int DAMAGE = 15;
  protected static final int WEIGHT = 10;
  protected static final int MAGIC_DAMAGE = 40;

  protected Weapon testWeapon;
  protected Axe testAxe;
  protected Staff testStaff;
  protected Sword testSword;
  protected Bow testBow;
  protected Knife testKnife;

  @BeforeEach
  void setUp() {
    testWeapon = new Weapon(WEAPON_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
  }

  @Test
  void constructorTest() {
    var expectedWeapon = new Weapon(WEAPON_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
    var notExpectedWeapon1 = new Weapon("Not Weapon", DAMAGE, WEIGHT, WeaponType.SWORD);
    var notExpectedWeapon2 = new Weapon(WEAPON_NAME, 23, WEIGHT, WeaponType.SWORD);
    var notExpectedWeapon3 = new Weapon(WEAPON_NAME, DAMAGE, 12, WeaponType.SWORD);
    var notExpectedWeapon4 = new Weapon(WEAPON_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);
    var notEqualsTestWeapon = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);

    assertEquals(testWeapon, testWeapon);
    assertEquals(expectedWeapon, testWeapon);
    assertEquals(expectedWeapon.hashCode(), testWeapon.hashCode());
    assertFalse(testWeapon.equals(notEqualsTestWeapon));
    assertFalse(notExpectedWeapon1.equals(testWeapon));
    assertFalse(notExpectedWeapon2.equals(testWeapon));
    assertFalse(notExpectedWeapon3.equals(testWeapon));
    assertFalse(notExpectedWeapon4.equals(testWeapon));
  }

}