package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int WEIGHT = 10;
  private static final int MAGIC_DAMAGE = 40;

  protected Axe testAxe;
  protected Staff testStaff;
  protected Sword testSword;
  protected Bow testBow;
  protected Knife testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    testStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);
    testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
    testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT, WeaponType.BOW);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    var notExpectedAxe1 = new Axe(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    var notExpectedAxe2 = new Axe(AXE_NAME, DAMAGE + 1, WEIGHT, WeaponType.AXE);
    var notExpectedAxe3 = new Axe(AXE_NAME, DAMAGE, WEIGHT + 1, WeaponType.AXE);
    var notExpectedAxe4 = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.STAFF);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, WEIGHT, WeaponType.BOW);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertFalse(notExpectedAxe1.equals(testAxe));
    assertFalse(notExpectedAxe2.equals(testAxe));
    assertFalse(notExpectedAxe3.equals(testAxe));
    assertFalse(notExpectedAxe4.equals(testAxe));
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(40, testStaff.getMagicDamage());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }

}