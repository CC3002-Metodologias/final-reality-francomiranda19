package com.github.francomiranda19.finalreality.controller.exceptions;

/**
 * A class that will be used for invalid movements in some states
 */
public class InvalidMovementException extends Exception {

  /**
   * Invalid movement exception
   * @param message that the user will see
   */
  public InvalidMovementException(final String message) {
    super(message);
  }

}
