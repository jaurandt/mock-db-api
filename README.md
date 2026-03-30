# mock-db-api

A lightweight in-memory REST API built with Java and Spark. It simulates a simple database with full CRUD support — create, read, update, and delete records over HTTP. Useful as a mock backend for testing clients, learning REST concepts, or prototyping without a real database.

---

## Requirements

- Java 21+
- Maven

---

## Running the server

```bash
mvn exec:java
```

The server starts on **http://localhost:4567**. Two demo records are pre-loaded on startup.

To stop the server, press `Ctrl+C`.

---

## Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/records` | List all records |
| GET | `/records/:id` | Get a record by id |
| POST | `/records` | Create a new record |
| PUT | `/records/:id` | Update an existing record |
| DELETE | `/records/:id` | Delete a record |

### Record fields

| Field | Type | Description |
|-------|------|-------------|
| `id` | integer | Auto-assigned primary key (do not set manually) |
| `name` | string | A short label for the record |
| `value` | string | Any string payload |

---

## Examples

> **Windows PowerShell users:** `curl` is an alias for `Invoke-RestMethod` in PowerShell and does not support the same flags. Use the PowerShell commands below instead.

**List all records**

```bash
# Bash
curl http://localhost:4567/records
```

```powershell
# PowerShell
Invoke-RestMethod -Uri http://localhost:4567/records
```

**Get a single record**

```bash
# Bash
curl http://localhost:4567/records/1
```
```powershell
# PowerShell
Invoke-RestMethod -Uri http://localhost:4567/records/1
```

**Create a record**

```bash
# Bash
curl -X POST http://localhost:4567/records \
  -H "Content-Type: application/json" \
  -d '{"name": "my-record", "value": "hello world"}'
```
```powershell
# PowerShell
Invoke-RestMethod -Uri http://localhost:4567/records -Method POST -ContentType "application/json" -Body '{"name": "my-record", "value": "hello world"}'
```

**Update a record**

```bash
# Bash
curl -X PUT http://localhost:4567/records/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "updated-name", "value": "new value"}'
```
```powershell
# PowerShell
Invoke-RestMethod -Uri http://localhost:4567/records/1 -Method PUT -ContentType "application/json" -Body '{"name": "updated-name", "value": "new value"}'
```

**Delete a record**

```bash
# Bash
curl -X DELETE http://localhost:4567/records/1
```
```powershell
# PowerShell
Invoke-RestMethod -Uri http://localhost:4567/records/1 -Method DELETE
```

---

## Notes

- All data is stored in memory and is lost when the server stops. This is intentional.
- Record IDs are auto-incremented integers. Passing a non-integer ID (e.g. `/records/abc`) returns a `400` error.
- All responses are JSON.
