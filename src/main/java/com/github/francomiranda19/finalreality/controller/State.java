package com.github.francomiranda19.finalreality.controller;

import com.github.francomiranda19.finalreality.controller.exceptions.InvalidMovementException;
import com.github.francomiranda19.finalreality.controller.exceptions.InvalidTransitionException;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.weapon.IWeapon;

/**
 * State pattern
 *
 * @author Franco Miranda Oyarzún
 */
public class State {
  protected static GameController controller;
  protected String name;

  /**
   * Returns the name of the state the controller is in
   */
  public String getName() {
    return name;
  }

  /**
   * Sets a controller as the context of this state
   * @param controller context of this state
   */
  public void setController(GameController controller) {
    State.controller = controller;
  }

  protected void changeState(State state) {
    controller.setState(state);
  }

  void invalidMovement() throws InvalidMovementException {
    throw new InvalidMovementException("Can't do this on " + this.getName() + " state");
  }

  void invalidTransition() throws InvalidTransitionException {
    throw new InvalidTransitionException("Can't change to that state");
  }

  void waitTurn() throws InvalidTransitionException {
    invalidTransition();
  }

  void inTurn() throws InvalidTransitionException {
    invalidTransition();
  }

  void gameOver() {
    this.changeState(new GameOver());
  }

  /**
   * Returns false if the controller is not in the waiting turn state
   */
  public boolean isWaitingTurn() {
    return false;
  }

  /**
   * Returns false if the controller is not in the in turn state
   */
  public boolean isInTurn() {
    return false;
  }

  /**
   * Returns false if the controller is not in the game over state
   */
  public boolean theGameIsOver() {
    return false;
  }

  void equip(IWeapon weapon) throws InvalidMovementException {
    invalidMovement();
  }

  void attack(IEnemy enemy) throws InvalidMovementException, InterruptedException {
    invalidMovement();
  }

  void poll() throws InvalidMovementException {
    invalidMovement();
  }

}
