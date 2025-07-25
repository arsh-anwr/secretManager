package com.secret.manager.exception;

public class SecretKeyNotFoundException extends Exception {
    public SecretKeyNotFoundException() {
        super();
    }
    public SecretKeyNotFoundException(String message) {
        super(message);
    }
    public SecretKeyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public SecretKeyNotFoundException(Throwable cause) {
        super(cause);
    }
}
