package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.classes.Engineer;
import com.github.francomiranda19.finalreality.model.character.player.classes.Knight;
import com.github.francomiranda19.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Set of tests for the {@code Enemy} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Enemy
 */
public class EnemyTest extends AbstractCharacterTest {
  private static final String ENEMY_NAME = "Test Enemy";
  private Enemy testEnemy, testDefensiveEnemy;
  private Knight testPlayerCharacter, testDeadPlayerCharacter;
  private static final int ATTACK = 15;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testEnemy = new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK);
    testDefensiveEnemy = new Enemy("Test Defensive Enemy", 10, turns, LIFE, 80, ATTACK);
    testPlayerCharacter = new Knight("Test Player Character", turns, 100, 5);
    testDeadPlayerCharacter = new Knight("Test Dead Player Character", turns, 0, 5);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedEnemy = new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK);
    var notExpectedEnemy1 = new Enemy("Not Enemy", 10, turns, LIFE, DEFENSE, ATTACK);
    var notExpectedEnemy2 = new Enemy(ENEMY_NAME, 15, turns, LIFE, DEFENSE, ATTACK);
    var notExpectedEnemy3 = new Enemy(ENEMY_NAME, 10, turns, LIFE + 1, DEFENSE, ATTACK);
    var notExpectedEnemy4 = new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE + 1, ATTACK);
    var notExpectedEnemy5 = new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK + 1);

    assertEquals(testEnemy, testEnemy);
    assertEquals(expectedEnemy, testEnemy);
    assertEquals(expectedEnemy.hashCode(), testEnemy.hashCode());
    assertNotEquals(notExpectedEnemy1, testEnemy);
    assertNotEquals(notExpectedEnemy1.hashCode(), testEnemy.hashCode());
    assertNotEquals(notExpectedEnemy2, testEnemy);
    assertNotEquals(notExpectedEnemy2.hashCode(), testEnemy.hashCode());
    assertNotEquals(notExpectedEnemy3, testEnemy);
    assertNotEquals(notExpectedEnemy3.hashCode(), testEnemy.hashCode());
    assertNotEquals(notExpectedEnemy4, testEnemy);
    assertNotEquals(notExpectedEnemy4.hashCode(), testEnemy.hashCode());
    assertNotEquals(notExpectedEnemy5, testEnemy);
    assertNotEquals(notExpectedEnemy5.hashCode(), testEnemy.hashCode());
    assertNotEquals(testEnemy, new Engineer("Not Knight", turns, LIFE, DEFENSE));
  }

  /**
   * Checks if the attacks from a player character to an enemy are correct.
   */
  @Test
  void attackTest() {
    assertEquals(100, testDefensiveEnemy.getCurrentLife());
    testPlayerCharacter.attack(testDefensiveEnemy);
    assertEquals(100, testDefensiveEnemy.getCurrentLife());

    assertEquals(100, testEnemy.getCurrentLife());
    testPlayerCharacter.attack(testEnemy);
    assertEquals(100, testEnemy.getCurrentLife());

    testPlayerCharacter.equipSword(new Sword("Test Sword", 20, 10));
    testPlayerCharacter.attack(testEnemy);
    assertEquals(90, testEnemy.getCurrentLife());

    testDeadPlayerCharacter.equipSword(new Sword("Test Sword", 20, 10));
    testDeadPlayerCharacter.attack(testEnemy);
    assertEquals(90, testEnemy.getCurrentLife());
  }
}