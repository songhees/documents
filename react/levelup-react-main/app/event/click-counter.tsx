'use client';

import React from 'react';

export function ClickCounter() {
  const [count, setCount] = React.useState(0);

  return (
    <button
      onClick={() => setCount(count + 1)}
      className="px-2 py-1 text-sm bg-gray-100 rounded hover:bg-gray-300"
    >
      이 버튼을 {count}번 클릭
    </button>
  );
}
