'use client';

import React from 'react';
import { useCounter } from './counter-context';
import { Boundary } from './boundary';

export const ContextClickCounter = () => {
  const [count, setCount] = useCounter();

  return (
    <Boundary
      labels={['클라이언트 컴포넌트: 카운터에 +1']}
      type="client"
      size="small"
    >
      <button
        onClick={() => setCount(count + 1)}
        className="px-3 py-1 text-sm font-medium text-gray-100 bg-gray-700 rounded-lg tabular-nums hover:bg-gray-500 hover:text-white"
      >
        {count} 번 클릭된 횟수에 더하기
      </button>
    </Boundary>
  );
};

export const ContextClickCounterMinus = () => {
  const [count, setCount] = useCounter();

  return (
    <Boundary
      labels={['클라이언트 컴포넌트: 카운터에 -1']}
      type="client"
      size="small"
    >
      <button
        onClick={() => setCount(count - 1)}
        className="px-3 py-1 text-sm font-medium text-gray-800 border border-gray-700 rounded-lg hover:bg-gray-500 hover:text-black"
      >
        다른 버튼에서 {count} 번 클릭된 횟수에 빼기
      </button>
    </Boundary>
  );
};

export const CounterStatus= () => {
  const [count] = useCounter();

  return (
    <Boundary
      labels={['클라이언트 컴포넌트: 카운터 컨텍스트 현황']}
      type="client"
      size="small"
    >
      <div className="text-xl font-bold text-black span">
        <span className="tabular-nums">{count}</span> 번 클릭됨
      </div>
    </Boundary>
  );
};

