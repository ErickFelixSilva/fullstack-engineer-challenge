import { api } from './api';

export interface Todo {
  id: number;
  text: string;
}

export const getTodos = async () => {
  const response = await api.get('/todos');
  return response.data;
};

export const createTodo = async (todo: string) => {
  const response = await api.post('/todos', { todo });
  return response.data;
};