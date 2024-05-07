import axios from "axios";
import { API_SERVER_HOST } from "./todoApi";

const rest_api_key = `71e2efdb0c14f3927d0d886a2762ab97`
const redirect_uri = `http://localhost:4000/member/kakao`

const auth_code_path = `https://kauth.kakao.com/oauth/authorize`
const auth_token_url = `https://kauth.kakao.com/oauth/token`

export const getKakaoLoginLink = () => {
  const kakaoURL = `${auth_code_path}?client_id=${rest_api_key}&redirect_uri=${redirect_uri}&response_type=code`;
  return kakaoURL;
}

export const getAccessToken = async (authCode) => {
  const header = {headers: {"Content-Type": "application/x-www-form-urlencoded"}}
  const params = {
    grant_type : 'authorization_code',
    client_id : rest_api_key,
    redirect_uri : redirect_uri,
    code : authCode,
  }
  const result = await axios.post(auth_token_url, params, header)
  return result.data.access_token;
}

export const getMemberWithAccessToken = async (accessToken) => {
  const result = await axios.get(`${API_SERVER_HOST}/api/member/kakao?accessToken=${accessToken}`);
  return result.data
}