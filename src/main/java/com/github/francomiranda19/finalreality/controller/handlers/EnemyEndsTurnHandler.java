package com.github.francomiranda19.finalreality.controller.handlers;

import com.github.francomiranda19.finalreality.controller.GameController;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class EnemyEndsTurnHandler implements IEventHandler {
  private final GameController controller;

  public EnemyEndsTurnHandler(GameController controller) {
    this.controller = controller;
  }

  /**
   * Notifies when an enemy ends turn to the controller
   * @param evt that is notified
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.enemyTurnPlayed((IEnemy) evt.getNewValue(), (IPlayerCharacter) evt.getOldValue());
  }
}
