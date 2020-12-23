package com.github.francomiranda19.finalreality.controller.handlers;

import com.github.francomiranda19.finalreality.controller.GameController;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class CharacterEndsTurnHandler implements IEventHandler {
  private final GameController controller;

  public CharacterEndsTurnHandler(GameController controller) {
    this.controller = controller;
  }

  /**
   * Notifies when a player character ends turn to the controller
   * @param evt that was fired
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.characterTurnPlayed((IPlayerCharacter) evt.getNewValue(), (IEnemy) evt.getOldValue());
  }
}
