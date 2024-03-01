fetch('http://localhost:8080/api/v1/task-manager')
                                                .then(response => response.json())
                                                    .then(tasks => {
                                                        const taskList = document.getElementById('taskList');
                                                        tasks.forEach(task => {
                                                            const li = document.createElement('li');
                                                            li.innerHTML = `

                                                                </div>
                                                                <div class="card border-success mb-3" style="max-width: 18rem;">
                                                                  <div class="card-header"></div>
                                                                  <div class="card-body text-secondary">
                                                                    <h5 class="card-title">Titulo: ${task.title}</h5>
                                                                    <p class="card-text">Descripcion: ${task.description}</p>
                                                                    <p class="card-text">Prioridad: ${task.priority}</p>
                                                                    <p class="card-text">Status: ${task.status}</p>
                                                                  </div>
                                                            `;
                                                            taskList.appendChild(li);
                                                        });
                                                    })
                                                    .catch(error => {
                                                        console.error('Error fetching tasks:', error);
                                                    });
  const deleteAllButton = document.getElementById('deleteAllButton');
  deleteAllButton.addEventListener('click', () => {
  fetch('http://localhost:8080/api/v1/task-manager', {
                method: 'DELETE'
            })
                .then(console.log('deleted'))
                .then(
                   location.reload());
  });

  const createTaskFormButton = document.getElementById('createTaskFormButton');
  createTaskFormButton.addEventListener('click', () => {
      const form = document.createElement('form');
      form.innerHTML = `
      <form>
        <div class="form-group">
          <label for="title">Title:</label><br>
          <input type="text" id="title" name="title" required>
          <label for="description">Description:</label>
          <textarea id="description" name="description" required></textarea>
          <label for="priority">Priority:</label>
          <select class="form-control" id="priority" name="priority" required>
              <option value="HIGH">High</option>
              <option value="MEDIUM">Medium</option>
              <option value="LOW">Low</option>
          </select>
          <label for="status">Status:</label>
          <select class="form-control" id="status" name="status" required>
              <option value="CREATED">New</option>
              <option value="IN_PROGRESS">In Progress</option>
              <option value="COMPLETED">Completed</option>
          </select>
          </div>
          <button class="btn btn-primary" type="submit">Create Task</button>
          </form>
      `;

      form.addEventListener('submit', (event) => {
          event.preventDefault();

          const formData = new FormData(form);
          const newTask = {};
          formData.forEach((value, key) => {
              newTask[key] = value;
          });

          fetch('http://localhost:8080/api/v1/task-manager', {
              method: 'POST',
    headers: new Headers({'content-type': 'application/json'}),
              body: JSON.stringify(newTask)
          })
              .then(response => response.json())
              .then(task => {
                  const taskList = document.getElementById('taskList');
                  const li = document.createElement('li');
                  li.innerHTML = `
                      <strong>Title:</strong> ${task.title}<br>
                      <strong>Description:</strong> ${task.description}<br>
                      <strong>Priority:</strong> ${task.priority}<br>
                      <strong>Status:</strong> ${task.status}<br>
                  `;
                  taskList.appendChild(li);
                   location.reload();
              })
              .catch(error => {
                  console.error('Error creating task:', error);
              });
      });

      document.body.appendChild(form);
  });