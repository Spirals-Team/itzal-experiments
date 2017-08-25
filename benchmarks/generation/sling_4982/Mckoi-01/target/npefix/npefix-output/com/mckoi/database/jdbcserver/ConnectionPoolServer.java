package com.mckoi.database.jdbcserver;


interface ConnectionPoolServer {
    void addConnection(ServerConnection connection);

    void close();
}

