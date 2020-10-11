package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SwordTest extends WeaponTest {
  private static final String SWORD_NAME = "Test Sword";
  private Sword testSword;

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

    assertEquals(testSword, testSword);
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword1, testSword);
    assertNotEquals(notExpectedSword1.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword2, testSword);
    assertNotEquals(notExpectedSword2.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword3, testSword);
    assertNotEquals(notExpectedSword3.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword4, testSword);
    assertNotEquals(notExpectedSword4.hashCode(), testSword.hashCode());
    assertFalse(testSword.equals(new Bow("Not Sword", DAMAGE, WEIGHT, WeaponType.BOW)));

  }

}
