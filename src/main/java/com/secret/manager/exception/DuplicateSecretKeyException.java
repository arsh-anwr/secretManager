package com.secret.manager.exception;

public class DuplicateSecretKeyException extends Exception {
    public DuplicateSecretKeyException() {
        super();
    }
    public DuplicateSecretKeyException(String message) {
        super(message);
    }
    public DuplicateSecretKeyException(String message, Throwable cause) {
        super(message, cause);
    }
    public DuplicateSecretKeyException(Throwable cause) {
        super(cause);
    }
}
