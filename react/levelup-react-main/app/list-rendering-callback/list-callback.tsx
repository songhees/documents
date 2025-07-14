'use client';

import React, { useState, useCallback, useEffect } from 'react';

export const Item = React.memo(({ content }: {content: string}) => {
  return <li className="p-2 mb-2 bg-gray-100 rounded shadow">{content}</li>;
});

Item.displayName = 'Item';

export default function ItemList() {
  const [items, setItems] = useState(['Item 1', 'Item 2']);
  const [input, setInput] = useState('');
  const [unrelatedInput, setUnrelatedInput] = useState('');
  const [renderCount, setRenderCount] = useState(0);

  const handleAdd = useCallback(() => {
    if (input) {
      setItems(prevItems => [...prevItems, input]);
      setInput('');
    }
  }, [input]);

  useEffect(() => {
    setRenderCount(count => count + 1);
  }, [unrelatedInput]);

  return (
    <div className="p-4">
      <input
        className="p-2 mb-2 border border-gray-300 rounded"
        value={input}
        onChange={e => setInput(e.target.value)}
        placeholder="새 아이템 입력"
      />
      <button
        className="p-2 text-white bg-blue-500 rounded hover:bg-blue-600"
        onClick={handleAdd}
      >
        아이템 추가
      </button>
      <ul className="mt-4">
        {items.map((item, index) => (
          <Item key={index} content={item} />
        ))}
      </ul>
      <input
        className="p-2 mt-2 border border-gray-300 rounded"
        value={unrelatedInput}
        onChange={e => setUnrelatedInput(e.target.value)}
        placeholder="별도의 입력 필드"
      />
      <p className="mb-4 text-sm text-gray-600">리렌더링 횟수: {renderCount}</p>
    </div>
  );
}
