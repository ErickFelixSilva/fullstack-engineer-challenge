import { useEffect, useState } from 'react';
import {
  createTodo,
  getTodos,
  Todo,
} from '../services/todoService';

function TodoComponent() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [newTodo, setNewTodo] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const loadTodos = async () => {
    setLoading(true);
    setError('');

    try {
      const data = await getTodos();
      setTodos(data);
    } catch (error) {
      console.error('Error loading todos', error);
      setError('Could not load todos. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleCreateTodo = async () => {
    const trimmedTodo = newTodo.trim();

    if (!trimmedTodo) {
      setError('Please type a todo before adding.');
      return;
    }

    setError('');

    try {
      const createdTodo = await createTodo(trimmedTodo);

      setTodos((currentTodos) => [
        ...currentTodos,
        createdTodo,
      ]);

      setNewTodo('');
    } catch (error) {
      console.error('Error creating todo', error);
      setError('Could not create todo. Please try again.');
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

      {loading && <p>Loading todos...</p>}

      {error && (
        <p style={{ color: 'red' }}>
          {error}
        </p>
      )}

      {!loading && !error && todos.length === 0 && (
        <p>No todos found.</p>
      )}

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