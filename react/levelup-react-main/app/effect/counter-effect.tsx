'use client';

import React, { useState, useEffect } from 'react';

function CounterEffect() {
  const [count, setCount] = useState(0);
  const [messages, setMessages] = useState<string[]>([]);

  // 컴포넌트 마운트 후 실행됩니다.
  useEffect(() => {
    setMessages(prev => [...prev, '컴포넌트가 마운트되었습니다.']);
    console.log('컴포넌트가 마운트되었습니다.');

    // 컴포넌트 언마운트 시 실행될 클린업 함수입니다.
    return () => {
      // 클린업 함수의 메시지는 실제로 화면에 표시되지 않습니다.
      setMessages(prev => [...prev, '컴포넌트가 언마운트되었습니다.']);
      console.log('컴포넌트가 언마운트되었습니다.');
    };
  }, []);

  // count 상태가 변경될 때마다 실행됩니다.
  useEffect(() => {
    setMessages(prev => [...prev, `카운트가 업데이트되었습니다: ${count}`]);
    // 브라우저 API를 사용하여 문서 제목을 업데이트합니다.
    document.title = `클릭 횟수: ${count}`;

    console.log(`카운트가 업데이트되었습니다: ${count}`);
  }, [count]);

  return (
    <div className="flex flex-col items-center justify-center p-4">
      <div className="h-40 p-2 mb-4 overflow-auto border border-gray-300 rounded-lg w-80">
        {messages.map((msg, index) => (
          <p key={index} className="text-sm text-gray-700">{msg}</p>
        ))}
      </div>
      <div className="flex flex-col items-center">
        <p className="mb-2 text-lg font-bold">카운트: {count}</p>
        <button
          onClick={() => setCount(count + 1)}
          className="px-4 py-2 font-semibold text-white bg-blue-500 rounded-lg hover:bg-blue-700"
        >
          증가
        </button>
      </div>
    </div>
  );
}

export default CounterEffect;
