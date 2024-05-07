import jwtAxios from "@util/jwtUtil"
import axios from "axios";
import { API_SERVER_HOST } from "./todoApi"

export const addOne = async (data) => {
  const header = { headers : {'Content-Type' : 'multipart/form-data'}};
  let result = await jwtAxios.post(`${API_SERVER_HOST}/api/products/`, data, header);
  return result.data;
}

export const getList = async (data) => {
  let result = await jwtAxios.get(`${API_SERVER_HOST}/api/products/list?page=${data.page}&size=${data.size}`)
  return result.data
}

export const getOne = async (data) => {
  let result = await jwtAxios.get(`${API_SERVER_HOST}/api/products/${data}`)
  return result.data;
}

export const putOne = async (pno, payload) => {
  const header = { headers : {'Content-Type' : 'multipart/form-data'}};
  let result = await jwtAxios.put(`${API_SERVER_HOST}/api/products/${pno}`, payload, header);
  return result.data;
}

export const deleteOne = async (data) => {
  let result = await jwtAxios.delete(`${API_SERVER_HOST}/api/products/${data}`)
  return result.data;
}