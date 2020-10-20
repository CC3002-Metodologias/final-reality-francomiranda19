package com.github.cc3002.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.character.player.Knight;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Weapon} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Weapon
 */
public class WeaponTest {
  private BlockingQueue<ICharacter> turns;

  protected static final int DAMAGE = 15;
  protected static final int WEIGHT = 10;
  protected static final int MAGIC_DAMAGE = 40;

  private static final String WEAPON_NAME = "Test Weapon";
  private Weapon testWeapon;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testWeapon = new Weapon(WEAPON_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
    turns = new LinkedBlockingQueue<>();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedWeapon = new Weapon(WEAPON_NAME, DAMAGE, WEIGHT, WeaponType.SWORD);
    var notExpectedWeapon1 = new Weapon("Not Weapon", DAMAGE, WEIGHT, WeaponType.SWORD);
    var notExpectedWeapon2 = new Weapon(WEAPON_NAME, 23, WEIGHT, WeaponType.SWORD);
    var notExpectedWeapon3 = new Weapon(WEAPON_NAME, DAMAGE, 12, WeaponType.SWORD);
    var notExpectedWeapon4 = new Weapon(WEAPON_NAME, DAMAGE, WEIGHT, WeaponType.KNIFE);

    assertEquals(testWeapon, testWeapon);
    assertEquals(expectedWeapon, testWeapon);
    assertEquals(expectedWeapon.hashCode(), testWeapon.hashCode());
    assertNotEquals(notExpectedWeapon1, testWeapon);
    assertNotEquals(notExpectedWeapon1.hashCode(), testWeapon.hashCode());
    assertNotEquals(notExpectedWeapon2, testWeapon);
    assertNotEquals(notExpectedWeapon2.hashCode(), testWeapon.hashCode());
    assertNotEquals(notExpectedWeapon3, testWeapon);
    assertNotEquals(notExpectedWeapon3.hashCode(), testWeapon.hashCode());
    assertNotEquals(notExpectedWeapon4, testWeapon);
    assertNotEquals(notExpectedWeapon4.hashCode(), testWeapon.hashCode());
    assertNotEquals(testWeapon, new Knight("Not Weapon", turns, CharacterClass.KNIGHT, 100, 40));
  }

}