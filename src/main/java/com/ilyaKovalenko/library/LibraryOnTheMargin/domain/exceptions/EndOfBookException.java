package com.ilyaKovalenko.library.LibraryOnTheMargin.domain.exceptions;

public class EndOfBookException extends RuntimeException {
    public EndOfBookException(String message) {
        super(message);
    }
}
