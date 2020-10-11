package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.Sword;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AxeTest extends WeaponTest {

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);
    var notExpectedAxe1 = new Axe("Not Axe", DAMAGE, WEIGHT, WeaponType.AXE);
    var notExpectedAxe2 = new Axe(AXE_NAME, 57, WEIGHT, WeaponType.AXE);
    var notExpectedAxe3 = new Axe(AXE_NAME, DAMAGE, 9, WeaponType.AXE);
    var notExpectedAxe4 = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.BOW);
    var notEqualsTestWeapon = new Sword(SWORD_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);

    assertEquals(testAxe, testAxe);
    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertFalse(testAxe.equals(notEqualsTestWeapon));
    assertFalse(notExpectedAxe1.equals(testAxe));
    assertFalse(notExpectedAxe2.equals(testAxe));
    assertFalse(notExpectedAxe3.equals(testAxe));
    assertFalse(notExpectedAxe4.equals(testAxe));
  }
}
