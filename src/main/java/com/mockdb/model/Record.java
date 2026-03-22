package com.mockdb.model;

/**
 * Represents a single record in the mock database.
 *
 * Fields:
 *   id    - auto-assigned integer, acts as the primary key
 *   name  - a short label for the record
 *   value - any string payload (think of it as a "data" column)
 */
public class Record {

    private int    id;
    private String name;
    private String value;

    // No-arg constructor required by Gson when deserializing JSON -> Record
    public Record() {}

    public Record(int id, String name, String value) {
        this.id    = id;
        this.name  = name;
        this.value = value;
    }

    public int    getId()    { return id; }
    public String getName()  { return name; }
    public String getValue() { return value; }

    public void setId(int id)          { this.id    = id; }
    public void setName(String name)   { this.name  = name; }
    public void setValue(String value) { this.value = value; }

    @Override
    public String toString() {
        return "Record{id=" + id + ", name='" + name + "', value='" + value + "'}";
    }
}
