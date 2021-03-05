package com.nanokylin.mc.yanpc.exception;

public class NoSuchOnMemoryException extends Exception{
    public NoSuchOnMemoryException() {
        super();
    }

    public NoSuchOnMemoryException(String message) {
        super(message);
    }

    public NoSuchOnMemoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchOnMemoryException(Throwable cause) {
        super(cause);
    }

    protected NoSuchOnMemoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
