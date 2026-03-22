package com.mockdb.store;

import com.mockdb.model.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In-memory storage for Record objects.
 *
 * Uses a HashMap<Integer, Record> as the backing store — think of it as a
 * single database table keyed by the record's id.
 *
 * All data is lost when the server stops. That is intentional for this mock server.
 */
public class RecordStore {

    // The "table": maps id -> Record
    private final Map<Integer, Record> table = new HashMap<>();

    // Auto-increment counter, just like a real DB primary key sequence
    private int nextId = 1;

    // CREATE
    public Record create(String name, String value) {
        Record r = new Record(nextId, name, value);
        table.put(nextId, r);
        nextId++;
        return r;
    }

    // READ - all
    public List<Record> findAll() {
        return new ArrayList<>(table.values());
    }

    // READ - one
    public Record findById(int id) {
        return table.get(id);
    }

    // UPDATE
    public Record update(int id, String name, String value) {
        Record existing = table.get(id);
        if (existing == null) return null;
        existing.setName(name);
        existing.setValue(value);
        return existing;
    }

    // DELETE
    public boolean delete(int id) {
        return table.remove(id) != null;
    }
}
