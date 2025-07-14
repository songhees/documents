'use client';

import React, { useReducer } from 'react';

// 상태(state)와 액션(action)의 타입 정의
interface State {
  count: number;
}

type Action = { type: 'INCREMENT' } | { type: 'DECREMENT' };

const initialState: State = { count: 0 };

const reducer = (state: State, action: Action): State => {
  switch (action.type) {
    case 'INCREMENT':
      return { count: state.count + 1 };
    case 'DECREMENT':
      return { count: state.count - 1 };
    default:
      return state;
  }
};

export const CounterWithReducer = () => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <div>
      <p className="mb-4 text-lg font-semibold">카운트: {state.count}</p>
      <button
        onClick={() => dispatch({ type: 'INCREMENT' })}
        className="px-4 py-2 mr-2 text-white bg-blue-500 rounded hover:bg-blue-700"
      >
        +
      </button>
      <button
        onClick={() => dispatch({ type: 'DECREMENT' })}
        className="px-4 py-2 text-red-500 bg-white border border-red-500 rounded hover:bg-red-200"
      >
        -
      </button>
    </div>
  );
};
