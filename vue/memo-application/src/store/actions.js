import {FETCH_MEMOS, ADD_MEMO, DELETE_MEMO,
  UPDATE_MEMO} from './mutations-types';
import axios from 'axios';

const memoAPICore = axios.create({
  baseURL: 'http://localhost:8000/api/memos',
});

// eslint-disable-next-line require-jsdoc
export function fetchMemos({commit}) {
  memoAPICore.get('/').then((res) => {
    commit(FETCH_MEMOS, res.data);
  });
}

// eslint-disable-next-line require-jsdoc
export function addMemo({commit}, payload) {
  memoAPICore.post('/', payload).then((res) => {
    commit(ADD_MEMO, res.data);
  });
}

// eslint-disable-next-line require-jsdoc
export function deleteMemo({commit}, id) {
  memoAPICore.delete(`/${id}`).then(()=> {
    commit(DELETE_MEMO, id);
  });
}

// eslint-disable-next-line require-jsdoc
export function updateMemo({commit}, payload) {
  const {id, content} = payload;
  memoAPICore.put(`/${id}`, {content}).then(()=> {
    commit(UPDATE_MEMO, payload);
  });
}

export default {
  fetchMemos,
  addMemo,
  deleteMemo,
  updateMemo,
};


