package com.github.cc3002.finalreality.model.controller;

import com.github.francomiranda19.finalreality.controller.GameController;
import com.github.francomiranda19.finalreality.controller.exceptions.InvalidTransitionException;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;
import com.github.francomiranda19.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {
  private GameController controller;

  private IPlayerCharacter blackMage;
  private IPlayerCharacter engineer;
  private IPlayerCharacter knight;

  private IEnemy enemy1;
  private IEnemy enemy2;

  private IWeapon axe;
  private IWeapon bow;
  private IWeapon knife;
  private IWeapon staff;
  private IWeapon sword;

  @BeforeEach
  void setUp() {
    controller = new GameController();

    axe = controller.createAxe("Axe", 35, 2);
    bow = controller.createBow("Bow", 20, 3);
    knife = controller.createKnife("Knife", 30, 4);
    staff = controller.createStaff("Staff", 10, 5, 30);
    sword = controller.createSword("Sword", 15, 1);

    blackMage = controller.createBlackMage("Brad", 100, 5, 10, sword);
    engineer = controller.createEngineer("Taylor", 120, 10, axe);
    knight = controller.createKnight("Amy", 75, 20, bow);

    enemy1 = controller.createEnemy("Adam", 3, 80, 5, 20);
    enemy2 = controller.createEnemy("Michael", 4, 50, 5, 10);
  }

  @Test
  void statesTest() throws InterruptedException {
    assertTrue(controller.isInTurn());
    assertFalse(controller.isWaitingTurn());
    assertFalse(controller.theGameIsOver());

    Thread.sleep(110);
    assertEquals(blackMage, controller.getTurnsQueue().peek());
    controller.tryToEquip(knife);
    controller.tryToAttack(enemy1);

    Thread.sleep(100);
    assertEquals(engineer, controller.getTurnsQueue().peek());
    controller.tryToEquip(axe);
    controller.tryToAttack(enemy2);

    Thread.sleep(100);
    assertEquals(knight, controller.getTurnsQueue().peek());
    controller.tryToEquip(bow);
    controller.tryToAttack(enemy2);

    Thread.sleep(100);
    assertEquals(enemy1, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy1);

    Thread.sleep(100);
    assertEquals(enemy2, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy2);

    Thread.sleep(100);
    assertEquals(blackMage, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy2);

    Thread.sleep(100);
    assertEquals(engineer, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy1);

    Thread.sleep(100);
    assertEquals(knight, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy1);

    Thread.sleep(100);
    assertEquals(enemy1, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy1);

    Thread.sleep(100);
    assertEquals(blackMage, controller.getTurnsQueue().peek());
    controller.tryToAttack(enemy1);

    assertFalse(controller.isInTurn());
    assertFalse(controller.isWaitingTurn());;
    assertTrue(controller.theGameIsOver());
  }

  @Test
  void errorTest() {
    assertThrows(InvalidTransitionException.class, () -> controller.inTurn());
  }

}
