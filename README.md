# TaskManager
Introduction

The Task Manager API provides endpoints to manage tasks. It allows users to create, read, update, and delete tasks.
## Base URL
* /api/v1/task-manager *

## Endpoints

## Create a New Task

### POST /api/v1/task-manager
Request

```json

{
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "2024-03-01",
  "priority": "HIGH"
}
```
Response

    Status: 201 Created
    Body:

```json
{
  "id": 1,
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "2024-03-01",
  "priority": "HIGH"
}
```
# Get All Tasks

### GET /api/v1/task-manager

Response

    Status: 200 OK
    Body:

```json
[
  {
    "id": 1,
    "title": "Task Title",
    "description": "Task Description",
    "dueDate": "2024-03-01T00:00:00Z",
    "priority": "HIGH"
  },
  {
    "id": 2,
    "title": "Another Task",
    "description": "Another Description",
    "dueDate": "2024-03-02T00:00:00Z",
    "priority": "MEDIUM"
  }
]
```
## Get a Task by ID

### GET /api/v1/task-manager/{taskId}
Response

    Status: 200 OK
    Body:

```json
{
  "id": 1,
  "title": "Task Title",
  "description": "Task Description",
  "dueDate": "2024-03-01T00:00:00Z",
  "priority": "HIGH"
}
```
## Update a Task

### PUT /api/v1/task-manager/{taskId}
Request

```json
{
  "id": 1,
  "title": "Updated Task Title",
  "description": "Updated Task Description",
  "dueDate": "2024-03-02T00:00:00Z",
  "priority": "MEDIUM"
}
```
Response

    Status: 200 OK
    Body:

```json
{
  "id": 1,
  "title": "Updated Task Title",
  "description": "Updated Task Description",
  "dueDate": "2024-03-02T00:00:00Z",
  "priority": "MEDIUM"
}
```
## Delete a Task

### DELETE /api/v1/task-manager/{taskId}
Response

    Status: 204 No Content

## Delete All Tasks

### DELETE /api/v1/task-manager
Response

    Status: 204 No Content

Error Responses

    Status: 404 Not Found
    Status: 400 Bad Request
    Status: 500 Internal Server Error

## Running with Docker

A `Dockerfile` is included so the application can be built and run without installing Java or Gradle locally.

1. Build the container image:
   ```bash
   docker build -t task-manager .
   ```
   If you need to build for a different platform (for example, building an 
   amd64 image on an Apple Silicon machine) use **buildx** and be sure to
   include the final `.` for the build context:
   ```bash
   docker buildx build --platform linux/amd64 -t task-manager .
   ```
2. Run the application:
   ```bash
   docker run -p 8080:8080 task-manager
   ```

The API will be available at `http://localhost:8080`.

### Using Docker Compose

If Docker Compose is installed, you can build and run the container with a single command:

```bash
docker compose up --build
```

This starts the application on port `8080`. Stop it with `Ctrl+C`.

### Windows

If you are using Windows, install [Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/).
Run the same commands from **PowerShell** or **Command Prompt**:

```powershell
docker build -t task-manager .
docker run -p 8080:8080 task-manager
```

You can also use Docker Compose:

```powershell
docker compose up --build
```

If you need an amd64 image, use buildx instead:

```powershell
docker buildx build --platform linux/amd64 -t task-manager .
docker run -p 8080:8080 task-manager
```

Docker Desktop must be running in Linux container mode (the default).
