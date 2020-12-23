package com.github.francomiranda19.finalreality.controller;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;
import com.github.francomiranda19.finalreality.model.weapon.IWeapon;

import java.util.Random;

public class InTurn extends State {
  private ICharacter character;

  /**
   * In turn state
   */
  public InTurn() {
    name = "In Turn";
  }

  @Override
  void waitTurn() {
    this.changeState(new WaitingTurn());
  }

  /**
   * Returns true if the controller is in this state
   */
  @Override
  public boolean isInTurn() {
    return true;
  }

  /**
   * Equips a weapon to a player character
   * @param weapon that will be equipped by a player character
   */
  @Override
  public void equip(IWeapon weapon) {
    character = controller.getTurnsQueue().peek();
    if (controller.getParty().contains(character)) {
      controller.equip(weapon, (IPlayerCharacter) character);
    }
  }

  /**
   * Attacks another character
   * @param enemy that is going to be attacked if the first of the turns queue,
   *              is a player character, if it is not, this parameter is irrelevant
   */
  @Override
  public void attack(IEnemy enemy) throws InterruptedException {
    character = controller.getTurnsQueue().peek();
    if (controller.getParty().contains(character)) {
      controller.characterAttack((IPlayerCharacter) character, enemy);
    }
    else if (controller.getEnemies().contains(character)) {
      Random r = new Random();
      int random = r.nextInt(controller.getPartySize());
      IPlayerCharacter player = controller.getParty().get(random);
      controller.enemyAttack((IEnemy) character, player);
    }
    waitTurn();
  }

}
