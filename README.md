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
