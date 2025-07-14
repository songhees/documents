'use client';

import React, { useState, useMemo, useEffect } from 'react';

export type Item = {
  id: number;
  name: string;
};

const expensiveCalculation = (item: Item): Item => {
  console.log('Calculating for:', item.name);
  return { ...item, name: item.name.toUpperCase() };
};

type ListComponentProps = {
  items: Item[];
};

export default function ListComponent({ items }: ListComponentProps) {
  const [filter, setFilter] = useState('');
  const [renderCount, setRenderCount] = useState(0);

  useEffect(() => {
    setRenderCount(count => count + 1);
  }, [filter]);

  const transformedItems = useMemo(() => {
    return items.map(item => expensiveCalculation(item));
  }, [items]);

  const handleFilterChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFilter(e.target.value);
  };

  return (
    <div className="p-4">
      <input
        type="text"
        value={filter}
        onChange={handleFilterChange}
        placeholder="필터 입력"
        className="p-2 mb-2 border border-gray-300 rounded-lg focus:outline-none focus:border-blue-500"
      />
      <p className="mb-4 text-sm text-gray-600">리렌더링 횟수: {renderCount}</p>
      <ul className="pl-5 list-disc">
        {transformedItems.map(item => (
          <li key={item.id} className="text-lg text-gray-800">{item.name}</li>
        ))}
      </ul>
    </div>
  );
}
