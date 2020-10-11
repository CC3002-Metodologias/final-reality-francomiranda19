package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StaffTest extends WeaponTest {

  @BeforeEach
  void setUp() {
    testStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);
  }

  @Test
  void constructorTest() {
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);
    var notExpectedStaff1 = new Staff("Not Staff", DAMAGE, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);
    var notExpectedStaff2 = new Staff(STAFF_NAME, 32, WEIGHT, WeaponType.STAFF, MAGIC_DAMAGE);
    var notExpectedStaff3 = new Staff(STAFF_NAME, DAMAGE, 12, WeaponType.STAFF, MAGIC_DAMAGE);
    var notExpectedStaff4 = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE, MAGIC_DAMAGE);
    var notExpectedStaff5 = new Staff(STAFF_NAME, DAMAGE, WEIGHT, WeaponType.STAFF, 5);
    var notEqualsTestWeapon = new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.AXE);

    assertEquals(testStaff, testStaff);
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertFalse(testStaff.equals(notEqualsTestWeapon));
    assertFalse(notExpectedStaff1.equals(testStaff));
    assertFalse(notExpectedStaff2.equals(testStaff));
    assertFalse(notExpectedStaff3.equals(testStaff));
    assertFalse(notExpectedStaff4.equals(testStaff));
    assertFalse(notExpectedStaff5.equals(testStaff));
  }

  @Test
  void magicDamageTest() {
    assertEquals(MAGIC_DAMAGE, testStaff.getMagicDamage());
  }

}
