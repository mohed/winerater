package com.example;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016-09-29.
 */
public class WineRepositoryException extends RuntimeException {
    public WineRepositoryException() {
    }

    public WineRepositoryException(String message) {
        super(message);
    }

    public WineRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public WineRepositoryException(Throwable cause) {
        super(cause);
    }

    public WineRepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WineRepositoryException(SQLException e) {

    }
}
