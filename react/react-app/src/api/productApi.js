import axios from "axios";

export const addOne = async (data) => {
  const header = { headers : {'Content-Type' : 'multipart/form-data'}};
  let result = await axios.post('http://localhost:8080/api/products/', data, header);
  return result.data;
}

export const getList = async (data) => {
  let result = await axios.get(`http://localhost:8080/api/products/list?page=${data.page}&size=${data.size}`)
  return result.data
}

export const getOne = async (data) => {
  let result = await axios.get(`http://localhost:8080/api/products/${data}`)
  return result.data;
}

export const putOne = async (pno, payload) => {
  const header = { headers : {'Content-Type' : 'multipart/form-data'}};
  let result = await axios.put(`http://localhost:8080/api/products/${pno}`, payload, header);
  return result.data;
}

export const deleteOne = async (data) => {
  let result = await axios.delete(`http://localhost:8080/api/products/${data}`)
  return result.data;
}