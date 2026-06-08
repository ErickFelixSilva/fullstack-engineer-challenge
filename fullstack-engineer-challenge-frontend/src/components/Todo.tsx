import { useEffect, useState } from 'react';
import {
  createTodo,
  getTodos,
  Todo,
} from '../services/todoService';

function TodoComponent() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [newTodo, setNewTodo] = useState('');

  const loadTodos = async () => {
    try {
      const data = await getTodos();
      setTodos(data);
    } catch (error) {
      console.error('Error loading todos', error);
    }
  };

  const handleCreateTodo = async () => {
    if (!newTodo.trim()) {
      return;
    }

    try {
      const createdTodo = await createTodo(newTodo);

      setTodos((currentTodos) => [
        ...currentTodos,
        createdTodo,
      ]);

      setNewTodo('');
    } catch (error) {
      console.error('Error creating todo', error);
    }
  };

  useEffect(() => {
    loadTodos();
  }, []);

  return (
    <div>
      <h2>Todos</h2>

      <input
        value={newTodo}
        onChange={(e) => setNewTodo(e.target.value)}
        placeholder="New todo"
      />

      <button onClick={handleCreateTodo}>
        Add
      </button>

      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            {todo.text}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoComponent;