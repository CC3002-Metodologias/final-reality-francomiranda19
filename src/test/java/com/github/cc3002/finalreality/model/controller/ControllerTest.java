package com.github.cc3002.finalreality.model.controller;

import com.github.francomiranda19.finalreality.controller.GameController;
import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;
import com.github.francomiranda19.finalreality.model.character.player.classes.Knight;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

  private GameController testController;
  private BlockingQueue<ICharacter> turns;
  private List<String> characterNames;
  private List<String> weaponNames;

  private IPlayerCharacter testBlackMage;
  private IPlayerCharacter testEngineer;
  private IPlayerCharacter testKnight;
  private IPlayerCharacter testThief;
  private IPlayerCharacter testWhiteMage;
  private IEnemy testEnemy;

  private IWeapon testAxe;
  private IWeapon testBow;
  private IWeapon testKnife;
  private IWeapon testStaff;
  private IWeapon testSword;

  private final static String BLACK_MAGE_NAME = "Test Black Mage";
  private final static String ENGINEER_NAME = "Test Engineer";
  private final static String KNIGHT_NAME = "Test Knight";
  private final static String THIEF_NAME = "Test Thief";
  private final static String WHITE_MAGE_NAME = "Test White Mage";
  private final static String ENEMY_NAME = "Test Enemy";

  private final static String AXE_NAME = "Test Axe";
  private final static String BOW_NAME = "Test Bow";
  private final static String KNIFE_NAME = "Test Knife";
  private final static String STAFF_NAME = "Test Staff";
  private final static String SWORD_NAME = "Test Sword";

  private final static int MAX_LIFE = 100;
  private final static int DEFENSE = 5;
  private final static int MANA = 30;
  private final static int WEIGHT = 10;
  private final static int ATTACK = 60;
  private final static int DAMAGE = 60;
  private final static int MAGIC_DAMAGE = 10;

  @BeforeEach
  void setUp() {
    testController = new GameController();
    turns = new LinkedBlockingQueue<>();
    characterNames = new ArrayList<>();
    weaponNames = new ArrayList<>();

    characterNames.add(BLACK_MAGE_NAME);
    characterNames.add(ENGINEER_NAME);
    characterNames.add(KNIGHT_NAME);
    characterNames.add(THIEF_NAME);
    characterNames.add(WHITE_MAGE_NAME);

    weaponNames.add(AXE_NAME);
    weaponNames.add(BOW_NAME);
    weaponNames.add(KNIFE_NAME);
    weaponNames.add(STAFF_NAME);
    weaponNames.add(SWORD_NAME);
  }

  @Test
  void createCharactersTest() {
    assertTrue(testController.partyIsEmpty());
    assertFalse(testController.isAValidCharacter(new Knight(KNIGHT_NAME, turns, MAX_LIFE, DEFENSE)));
    testBlackMage = testController.createBlackMage(BLACK_MAGE_NAME, MAX_LIFE, DEFENSE, MANA);
    testEngineer = testController.createEngineer(ENGINEER_NAME, MAX_LIFE, DEFENSE);
    testKnight = testController.createKnight(KNIGHT_NAME, MAX_LIFE, DEFENSE);
    testThief = testController.createThief(THIEF_NAME, MAX_LIFE, DEFENSE);
    testWhiteMage = testController.createWhiteMage(WHITE_MAGE_NAME, MAX_LIFE, DEFENSE, MANA);
    assertEquals(5, testController.getPartySize());
    for (int i = 0; i < testController.getPartySize(); i++) {
      IPlayerCharacter character = testController.getParty().get(i);
      String name = characterNames.get(i);
      assertTrue(testController.isAValidCharacter(character));
      assertEquals(name, testController.getCharacterName(character));
      assertEquals(100, testController.getLife(character));
      assertEquals(5, testController.getDefense(character));
      assertEquals(0, testController.getAttack(character));
      assertNull(testController.getEquippedWeapon(character));
      assertFalse(testController.isDead(character));
    }
  }

  @Test
  void createEnemiesTest() {
    assertTrue(testController.enemiesIsEmpty());
    assertFalse(testController.isAValidCharacter(new Enemy(ENEMY_NAME, WEIGHT, turns, MAX_LIFE, DEFENSE, ATTACK)));
    for (int i = 0; i < 5; i++) {
      testEnemy = testController.createEnemy(ENEMY_NAME, WEIGHT, MAX_LIFE, DEFENSE, ATTACK);
    }
    assertEquals(5, testController.getEnemiesSize());
    testController.createEnemy(ENEMY_NAME, WEIGHT, MAX_LIFE, DEFENSE, ATTACK);
    assertEquals(5, testController.getEnemiesSize());
    for (IEnemy enemy : testController.getEnemies()) {
      assertTrue(testController.isAValidCharacter(enemy));
      assertEquals("Test Enemy", testController.getCharacterName(enemy));
      assertEquals(10, testController.getEnemyWeight(enemy));
      assertEquals(100, testController.getLife(enemy));
      assertEquals(5, testController.getDefense(enemy));
      assertEquals(60, testController.getAttack(enemy));
      assertFalse(testController.isDead(enemy));
    }
  }

  @Test
  void createWeaponsTest() {
    assertTrue(testController.inventoryIsEmpty());
    testAxe = testController.createAxe(AXE_NAME, DAMAGE, WEIGHT);
    testBow = testController.createBow(BOW_NAME, DAMAGE, WEIGHT);
    testKnife = testController.createKnife(KNIFE_NAME, DAMAGE, WEIGHT);
    testStaff = testController.createStaff(STAFF_NAME, DAMAGE, WEIGHT, MAGIC_DAMAGE);
    testSword = testController.createSword(SWORD_NAME, DAMAGE, WEIGHT);
    assertEquals(5, testController.getInventorySize());
    for (int i = 0; i < testController.getInventorySize(); i++) {
      IWeapon weapon = testController.getInventory().get(i);
      String name = weaponNames.get(i);
      assertTrue(testController.isAValidWeapon(weapon));
      assertEquals(name, testController.getWeaponName(weapon));
      assertEquals(60, testController.getDamage(weapon));
      assertEquals(10, testController.getWeaponWeight(weapon));
    }
  }

  @Test
  void notValidCharactersTest() {
    testKnight = new Knight(KNIGHT_NAME, turns, MAX_LIFE, DEFENSE);
    testEnemy = new Enemy(ENEMY_NAME, WEIGHT, turns, MAX_LIFE, DEFENSE, ATTACK);
    assertFalse(testController.isAValidCharacter(testKnight));
    assertNull(testController.getCharacterName(testKnight));
    assertEquals(-1, testController.getLife(testKnight));
    assertEquals(-1, testController.getDefense(testKnight));
    assertEquals(-1, testController.getAttack(testKnight));
    assertNull(testController.getEquippedWeapon(testKnight));
    assertEquals(-1, testController.getEnemyWeight(testEnemy));
  }

  @Test
  void notValidWeaponsTest() {
    testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    assertFalse(testController.isAValidWeapon(testAxe));
    assertNull(testController.getWeaponName(testAxe));
    assertEquals(-1, testController.getDamage(testAxe));
    assertEquals(-1, testController.getWeaponWeight(testAxe));
  }

  @Test
  void notRemovingWeaponsTest() {
    testAxe = testController.createAxe(AXE_NAME, DAMAGE, WEIGHT);
    testSword = testController.createSword(SWORD_NAME, DAMAGE, WEIGHT);
    testThief = testController.createThief(THIEF_NAME, MAX_LIFE, DEFENSE);
    testController.equip(testSword, testThief);
    assertEquals(testSword, testController.getEquippedWeapon(testThief));
    testController.equip(testAxe, testThief);
    assertEquals(testSword, testController.getEquippedWeapon(testThief));
  }

  @Test
  void notNullWeaponsTest() {
    testSword = testController.createSword(SWORD_NAME, DAMAGE, WEIGHT);
    testBow = testController.createBow(BOW_NAME, DAMAGE, WEIGHT);
    testThief = testController.createThief(THIEF_NAME, MAX_LIFE, DEFENSE);
    testController.equip(testSword, testThief);
    assertEquals(testSword, testController.getEquippedWeapon(testThief));
    assertEquals(1, testController.getInventorySize());
    testController.equip(testBow, testThief);
    assertEquals(testBow, testController.getEquippedWeapon(testThief));
    assertEquals(1, testController.getInventorySize());
  }

  @Test
  void victoryTest() throws InterruptedException {
    testKnight = testController.createKnight(KNIGHT_NAME, MAX_LIFE, DEFENSE);
    testSword = testController.createSword(SWORD_NAME, DAMAGE, 2);
    testEnemy = testController.createEnemy(ENEMY_NAME, 3, MAX_LIFE, DEFENSE, 10);
    IEnemy anotherTestEnemy = testController.createEnemy("Another Test Enemy", 2, 30, DEFENSE, 20);

    testController.equip(testSword, testKnight);

    Thread.sleep(200);
    assertEquals(testKnight, testController.nextTurn());
    testController.characterAttack(testKnight, testEnemy);

    assertEquals(testEnemy, testController.nextTurn());
    testController.enemyAttack(testEnemy, testKnight);

    assertEquals(anotherTestEnemy, testController.nextTurn());
    testController.enemyAttack(anotherTestEnemy, testKnight);

    Thread.sleep(200);
    assertEquals(testKnight, testController.nextTurn());
    testController.characterAttack(testKnight, testEnemy);

    assertEquals(anotherTestEnemy, testController.nextTurn());
    testController.enemyAttack(anotherTestEnemy, testKnight);

    Thread.sleep(200);
    assertEquals(testKnight, testController.nextTurn());
    testController.characterAttack(testKnight, anotherTestEnemy);
  }

  @Test
  void lossTest() throws InterruptedException {
    testEnemy = testController.createEnemy(ENEMY_NAME, 2, MAX_LIFE, DEFENSE, ATTACK);
    Thread.sleep(200);
    testThief = testController.createThief(THIEF_NAME, MAX_LIFE, DEFENSE);
    testEngineer = testController.createEngineer(ENGINEER_NAME, MAX_LIFE, DEFENSE);
    testBow = testController.createBow(BOW_NAME, 10, WEIGHT);

    testController.equip(testBow, testThief);
    testController.equip(testBow, testEngineer);

    assertEquals(testEnemy, testController.nextTurn());
    testController.enemyAttack(testEnemy, testThief);

    assertEquals(testThief, testController.nextTurn());
    testController.characterAttack(testThief, testEnemy);

    assertEquals(testEngineer, testController.nextTurn());
    testController.characterAttack(testEngineer, testEnemy);

    Thread.sleep(200);
    assertEquals(testEnemy, testController.nextTurn());
    testController.enemyAttack(testEnemy, testThief);

    assertEquals(testEngineer, testController.nextTurn());
    testController.characterAttack(testEngineer, testEnemy);

    Thread.sleep(200);
    assertEquals(testEnemy, testController.nextTurn());
    testController.enemyAttack(testEnemy, testEngineer);

    assertEquals(testEngineer, testController.nextTurn());
    testController.characterAttack(testEngineer, testEnemy);

    Thread.sleep(200);
    assertEquals(testEnemy, testController.nextTurn());
    testController.enemyAttack(testEnemy, testEngineer);
  }

}
