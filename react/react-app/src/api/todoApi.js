import axios from "axios";

export const API_SERVER_HOST = 'http://localhost:8080'
const prefix = `${API_SERVER_HOST}/api/todo`;

export const getOne = async(tno) => {
  const res = await axios.get(`${prefix}/${tno}`);
  console.log(res)
  return res.data;
}

export const getList = async({page, size}) => {
  const res = await axios.get(`${prefix}/list`, {params: {page: page, size: size}});
  return res.data;
}

export const addOne = async(todo) => {
  console.log(todo)
  const res = await axios.post(`${prefix}`, todo)
  return res.data;
}

export const modifyOne = async(todo) => {
  console.log(todo)
  const res = await axios.put(`${prefix}/${todo.tno}`, todo);
  return res.data;
}

export const deleteOne = async(tno) => {
  const res = await axios.delete(`${prefix}/${tno}`);
  return res.data;
}