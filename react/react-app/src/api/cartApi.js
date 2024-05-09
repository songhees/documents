import axios from "axios"
import jwtAxios from "@util/jwtUtil"
import { API_SERVER_HOST } from "./todoApi"

const host = `${API_SERVER_HOST}/api/cart`

export const getCartItems = async () => {
  const result = await jwtAxios.get(`${host}/items`);
  return result.data;
}

export const postChangeCart = async (cartItem) => {
  const result = await jwtAxios.post(`${host}/change`, cartItem);
  return result.data
}