'use client';

import React, { useRef, useImperativeHandle, forwardRef } from 'react';

export const FancyInput = forwardRef((props, ref) => {
  const inputRef = useRef<HTMLInputElement>(null);

  useImperativeHandle(ref, () => ({
    focus: () => {
      if (inputRef.current) {
        inputRef.current.focus();
      }
    }
  }));

  return (
    <input
      ref={inputRef}
      className="p-2 border border-gray-300 rounded-lg focus:border-blue-500"
    />
  );
});

FancyInput.displayName = 'FancyInput';

function FancyInputHolder() {
  const inputRef = useRef<HTMLInputElement>(null);

  const focusInput = () => {
    if (inputRef.current) {
      inputRef.current.focus();
    }
  };

  return (
    <div className="flex flex-col items-center p-4 space-y-4">
      <FancyInput ref={inputRef} />
      <button
        onClick={focusInput}
        className="px-4 py-2 text-white bg-blue-500 rounded-lg hover:bg-blue-700"
      >
        포커스
      </button>
    </div>
  );
}

export default FancyInputHolder;
