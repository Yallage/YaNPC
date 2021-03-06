package com.nanokylin.mc.yanpc.exception;

public class NPCLoaderNoSuchOnMemoryException extends NoSuchOnMemoryException{
    public NPCLoaderNoSuchOnMemoryException() {
        super();
    }

    public NPCLoaderNoSuchOnMemoryException(String message) {
        super(message);
    }

    public NPCLoaderNoSuchOnMemoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NPCLoaderNoSuchOnMemoryException(Throwable cause) {
        super(cause);
    }

    protected NPCLoaderNoSuchOnMemoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
