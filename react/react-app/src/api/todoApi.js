import axios from "axios";
import jwtAxios from "@util/jwtUtil"

export const API_SERVER_HOST = 'http://localhost:8080'
const prefix = `${API_SERVER_HOST}/api/todo`;

export const getOne = async(tno) => {
  const res = await jwtAxios.get(`${prefix}/${tno}`);
  console.log(res)
  return res.data;
}

export const getList = async({page, size}) => {
  const res = await jwtAxios.get(`${prefix}/list`, {params: {page: page, size: size}});
  return res.data;
}

export const addOne = async(todo) => {
  console.log(todo)
  const res = await jwtAxios.post(`${prefix}`, todo)
  return res.data;
}

export const modifyOne = async(todo) => {
  console.log(todo)
  const res = await jwtAxios.put(`${prefix}/${todo.tno}`, todo);
  return res.data;
}

export const deleteOne = async(tno) => {
  const res = await jwtAxios.delete(`${prefix}/${tno}`);
  return res.data;
}