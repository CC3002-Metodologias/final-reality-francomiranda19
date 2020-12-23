package com.github.francomiranda19.finalreality.controller;

public class GameOver extends State {

  /**
   * Game over state
   */
  public GameOver() {
    name = "Game Over";
  }

  /**
   * Returns true if the controller is in this state
   */
  @Override
  public boolean theGameIsOver() {
    return true;
  }

}
