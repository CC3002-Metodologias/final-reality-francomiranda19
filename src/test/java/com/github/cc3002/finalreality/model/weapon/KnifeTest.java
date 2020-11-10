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
public class KnifeTest {
  private static final String KNIFE_NAME = "Test Knife";
  private Knife testKnife;
  private static final int DAMAGE = 15;
  private static final int WEIGHT = 10;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    var notExpectedKnife1 = new Knife("Not Knife", DAMAGE, WEIGHT);
    var notExpectedKnife2 = new Knife(KNIFE_NAME, 77, WEIGHT);
    var notExpectedKnife3 = new Knife(KNIFE_NAME, DAMAGE, 44);

    assertEquals(testKnife, testKnife);
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife1, testKnife);
    assertNotEquals(notExpectedKnife1.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife2, testKnife);
    assertNotEquals(notExpectedKnife2.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedKnife3, testKnife);
    assertNotEquals(notExpectedKnife3.hashCode(), testKnife.hashCode());
    assertNotEquals(testKnife, new Sword("Not Knife", DAMAGE, WEIGHT));
  }

}
