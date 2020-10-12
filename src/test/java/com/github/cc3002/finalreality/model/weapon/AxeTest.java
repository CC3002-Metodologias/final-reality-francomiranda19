package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Axe} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Axe
 */
public class AxeTest extends WeaponTest {
  private static final String AXE_NAME = "Test Axe";
  private Axe testAxe;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    var notExpectedAxe1 = new Axe("Not Axe", DAMAGE, WEIGHT, WeaponType.AXE);
    var notExpectedAxe2 = new Axe(AXE_NAME, 57, WEIGHT, WeaponType.AXE);
    var notExpectedAxe3 = new Axe(AXE_NAME, DAMAGE, 9, WeaponType.AXE);
    var notExpectedAxe4 = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.BOW);

    assertEquals(testAxe, testAxe);
    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertNotEquals(notExpectedAxe1, testAxe);
    assertNotEquals(notExpectedAxe1.hashCode(), testAxe.hashCode());
    assertNotEquals(notExpectedAxe2, testAxe);
    assertNotEquals(notExpectedAxe2.hashCode(), testAxe.hashCode());
    assertNotEquals(notExpectedAxe3, testAxe);
    assertNotEquals(notExpectedAxe3.hashCode(), testAxe.hashCode());
    assertNotEquals(notExpectedAxe4, testAxe);
    assertNotEquals(notExpectedAxe4.hashCode(), testAxe.hashCode());
    assertFalse(testAxe.equals(new Bow("Not Axe", DAMAGE, WEIGHT, WeaponType.BOW)));
  }
}
