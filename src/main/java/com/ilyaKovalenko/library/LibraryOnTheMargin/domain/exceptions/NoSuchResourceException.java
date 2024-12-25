package com.ilyaKovalenko.library.LibraryOnTheMargin.domain.exceptions;

public class NoSuchResourceException extends RuntimeException {
  public NoSuchResourceException(String message) {
    super(message);
  }
}
