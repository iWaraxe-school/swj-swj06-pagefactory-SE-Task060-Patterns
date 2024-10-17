package com.coherentsolutions.page;

/**
 * Custom exception to make error handling at the constructor more specific.
 */
public class PageNotLoadedException extends RuntimeException {
    public PageNotLoadedException(String message) {
        super(message);
    }
}

