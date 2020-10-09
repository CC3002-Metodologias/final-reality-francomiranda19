package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.cc3002.finalreality.model.character.PlayerCharacterTest;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  protected Axe testAxe;
  protected Staff testStaff;
  protected Sword testSword;
  protected Bow testBow;
  protected Knife testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }

}