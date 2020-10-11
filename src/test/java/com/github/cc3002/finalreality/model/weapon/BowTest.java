package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BowTest extends WeaponTest {
  private static final String BOW_NAME = "Test Bow";
  private Bow testBow;

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

    assertEquals(testBow, testBow);
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow1, testBow);
    assertNotEquals(notExpectedBow1.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow2, testBow);
    assertNotEquals(notExpectedBow2.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow3, testBow);
    assertNotEquals(notExpectedBow3.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow4, testBow);
    assertNotEquals(notExpectedBow4.hashCode(), testBow.hashCode());
    assertFalse(testBow.equals(new Staff("Not Bow", DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE)));
  }

}
