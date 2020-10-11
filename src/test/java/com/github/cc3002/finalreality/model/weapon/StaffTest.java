package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StaffTest extends WeaponTest {
  private static final String STAFF_NAME = "Test Staff";
  private Staff testStaff;

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

    assertEquals(testStaff, testStaff);
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertNotEquals(notExpectedStaff1, testStaff);
    assertNotEquals(notExpectedStaff1.hashCode(), testStaff.hashCode());
    assertNotEquals(notExpectedStaff2, testStaff);
    assertNotEquals(notExpectedStaff2.hashCode(), testStaff.hashCode());
    assertNotEquals(notExpectedStaff3, testStaff);
    assertNotEquals(notExpectedStaff3.hashCode(), testStaff.hashCode());
    assertNotEquals(notExpectedStaff4, testStaff);
    assertNotEquals(notExpectedStaff4.hashCode(), testStaff.hashCode());
    assertNotEquals(notExpectedStaff5, testStaff);
    assertNotEquals(notExpectedStaff5.hashCode(), testStaff.hashCode());
    assertFalse(testStaff.equals(new Axe("Not Staff", DAMAGE, WEIGHT, WeaponType.AXE)));
  }

  @Test
  void magicDamageTest() {
    assertEquals(MAGIC_DAMAGE, testStaff.getMagicDamage());
    assertNotEquals(MAGIC_DAMAGE + 5, testStaff.getMagicDamage());
  }

}
