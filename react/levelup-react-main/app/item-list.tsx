'use client';

import React from "react";

type Props = {
  name: string;
  age?: number;
};

function Welcome(props: Props) {
  return <h4>Hello, {props.name}</h4>;
}

function ItemList() {
  const [items, setItems] = React.useState<string[]>([]);
  const [inputValue, setInputValue] = React.useState<string>('');

  const addItem = () => {
      setItems([...items, inputValue])
      setInputValue('')
  };

  return (
      <div>
        <Welcome name="Alice" />

        <h5 className="text-xl font-bold">웹 기본</h5>
        <h1 className="text-2xl font-bold">구성 요소</h1>
        <ul id="itemList" className="list-disc list-inside">
          <li>HTML</li>
          <li>자바스크립트</li>
          <li>CSS</li>
          {items.map((item, index) => (
          <li key={index}>{item}</li>
          ))}
        </ul>
      <input
          type="text"
          value={inputValue}
          onChange={e => setInputValue(e.target.value)}
          placeholder="항목 추가"
      />
      <button onClick={addItem}>항목 추가</button>
      </div>
  )
}

export default ItemList;