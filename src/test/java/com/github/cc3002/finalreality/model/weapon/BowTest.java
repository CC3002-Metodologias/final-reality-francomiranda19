package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Set of tests for the {@code Bow} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Bow
 */
public class BowTest {
  private static final String BOW_NAME = "Test Bow";
  private Bow testBow;
  private static final int DAMAGE = 15;
  private static final int WEIGHT = 10;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    var notExpectedBow1 = new Bow("Not Bow", DAMAGE, WEIGHT);
    var notExpectedBow2 = new Bow(BOW_NAME, 45, WEIGHT);
    var notExpectedBow3 = new Bow(BOW_NAME, DAMAGE, 5);

    assertEquals(testBow, testBow);
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow1, testBow);
    assertNotEquals(notExpectedBow1.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow2, testBow);
    assertNotEquals(notExpectedBow2.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedBow3, testBow);
    assertNotEquals(notExpectedBow3.hashCode(), testBow.hashCode());
    assertNotEquals(testBow, new Knife("Not Bow", DAMAGE, WEIGHT));
  }

}
