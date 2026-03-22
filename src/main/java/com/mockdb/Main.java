package com.mockdb;

import com.mockdb.api.RecordRoutes;
import com.mockdb.store.RecordStore;

import static spark.Spark.*;

/**
 * Application entry point.
 * Starts an HTTP server on port 4567.
 * Access the API at: http://localhost:4567/records
 */
public class Main {

    public static void main(String[] args) {

        port(4567);

        RecordStore store = new RecordStore();

        // Seed two demo records so the DB isn't empty on first run
        store.create("first-record",  "hello world");
        store.create("second-record", "foo bar baz");

        new RecordRoutes(store).register();

        awaitInitialization();
        System.out.println("=========================================");
        System.out.println(" Mock DB API is running!");
        System.out.println(" Base URL: http://localhost:4567/records");
        System.out.println("=========================================");
    }
}
