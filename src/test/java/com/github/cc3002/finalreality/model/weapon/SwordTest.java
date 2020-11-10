package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Set of tests for the {@code Sword} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Sword
 */
public class SwordTest {
  private static final String SWORD_NAME = "Test Sword";
  private Sword testSword;
  private static final int DAMAGE = 15;
  private static final int WEIGHT = 10;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    var notExpectedSword1 = new Sword("Not Sword", DAMAGE, WEIGHT);
    var notExpectedSword2 = new Sword(SWORD_NAME, 1, WEIGHT);
    var notExpectedSword3 = new Sword(SWORD_NAME, DAMAGE, 2);

    assertEquals(testSword, testSword);
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword1, testSword);
    assertNotEquals(notExpectedSword1.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword2, testSword);
    assertNotEquals(notExpectedSword2.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedSword3, testSword);
    assertNotEquals(notExpectedSword3.hashCode(), testSword.hashCode());
    assertNotEquals(testSword, new Bow("Not Sword", DAMAGE, WEIGHT));
  }

}
