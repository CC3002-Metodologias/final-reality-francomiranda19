package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Set of tests for the {@code Knife} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Knife
 */
public class KnifeTest extends WeaponTest {
  private static final String KNIFE_NAME = "Test Knife";
  private Knife testKnife;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);
    var notExpectedKnife1 = new Knife("Not Knife", DAMAGE, WEIGHT, WeaponType.KNIFE);
    var notExpectedKnife2 = new Knife(KNIFE_NAME, 77, WEIGHT, WeaponType.KNIFE);
    var notExpectedKnife3 = new Knife(KNIFE_NAME, DAMAGE, 44, WeaponType.KNIFE);
    var notExpectedKnife4 = new Knife(KNIFE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);

    assertEquals(testKnife, testKnife);
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife1, testKnife);
    assertNotEquals(notExpectedKnife1.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife2, testKnife);
    assertNotEquals(notExpectedKnife2.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife3, testKnife);
    assertNotEquals(notExpectedKnife3.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife4, testKnife);
    assertNotEquals(notExpectedKnife4.hashCode(), testKnife.hashCode());
    assertFalse(testKnife.equals(new Sword("Not Knife", DAMAGE, WEIGHT, WeaponType.SWORD)));
  }

}
