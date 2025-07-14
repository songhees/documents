'use client';
import React, { useRef, useEffect } from 'react';

function InputForm() {
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    if (inputRef.current) {
      inputRef.current.focus();
    }
  }, []);

  return (
    <div className="flex flex-col items-center justify-center space-y-4">
      <input
        ref={inputRef}
        type="text"
        placeholder="여기에 입력하세요"
        className="px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
      <button
        onClick={() => {
          if (inputRef.current) {
            console.log(inputRef.current.value);
          }
        }}
        className="px-4 py-2 text-white bg-blue-500 rounded-lg hover:bg-blue-700 focus:outline-none"
      >
        콘솔에 값 출력
      </button>
    </div>
  );
}

export default InputForm;
