package com.github.francomiranda19.finalreality.controller.exceptions;

/**
 * A class that will be used for invalid transitions through states
 */
public class InvalidTransitionException extends Exception {

  /**
   * Invalid transition exception
   * @param message that the user will see
   */
  public InvalidTransitionException(final String message) {
    super(message);
  }

}
