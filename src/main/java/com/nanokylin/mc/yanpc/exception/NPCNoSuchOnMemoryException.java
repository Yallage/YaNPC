package com.nanokylin.mc.yanpc.exception;

public class NPCNoSuchOnMemoryException extends NoSuchOnMemoryException {
    public NPCNoSuchOnMemoryException() {
        super();
    }

    public NPCNoSuchOnMemoryException(String message) {
        super(message);
    }

    public NPCNoSuchOnMemoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NPCNoSuchOnMemoryException(Throwable cause) {
        super(cause);
    }

    protected NPCNoSuchOnMemoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
