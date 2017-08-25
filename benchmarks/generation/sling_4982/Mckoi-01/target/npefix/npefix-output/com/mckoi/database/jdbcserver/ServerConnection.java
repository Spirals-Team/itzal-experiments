package com.mckoi.database.jdbcserver;

import java.io.IOException;

interface ServerConnection {
    boolean requestPending() throws IOException;

    void processRequest() throws IOException;

    void blockForRequest() throws IOException;

    void ping() throws IOException;

    void close() throws IOException;
}

