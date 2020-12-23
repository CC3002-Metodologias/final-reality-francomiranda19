package com.github.francomiranda19.finalreality.controller;

import com.github.francomiranda19.finalreality.model.character.ICharacter;

public class WaitingTurn extends State {

  /**
   * Waiting turn state
   */
  public WaitingTurn() {
    name = "Waiting Turn";
  }

  @Override
  void inTurn() {
    this.changeState(new InTurn());
  }

  /**
   * Returns true if the controller is in this state
   */
  @Override
  public boolean isWaitingTurn() {
    return true;
  }

  /**
   * Pops the first character and returns it to the turns queue
   */
  @Override
  public void poll() {
    ICharacter character = controller.removeFromTurnsQueue();
    character.waitTurn();
    if (!(controller.getTurnsQueue().isEmpty())) {
      inTurn();
    }
    if (controller.partyIsEmpty() || controller.enemiesIsEmpty()) {
      gameOver();
    }
  }

}
