'use client';

import React from 'react';
import { useAtBottom } from './use-at-bottom';
import { useCopyToClipboard } from './use-copy-to-clipboard';

export function ScrollTracker() {
  const atBottom = useAtBottom(100);

  return (
    <div className="min-h-screen p-4 space-y-4 bg-gray-100">
      <p className="text-lg">
        {atBottom ? '페이지 하단에 도달했습니다!' : '더 스크롤하세요.'}
      </p>
      {Array.from({ length: 5 }, (_, index) => (
        <Content key={index} />
      ))}
      <p className="text-lg">
        {atBottom ? '페이지 하단에 도달했습니다!' : '더 스크롤하세요.'}
      </p>
    </div>
  );
}

function Content() {
  const { isCopied, copyToClipboard } = useCopyToClipboard({ timeout: 2000 });

  const textToCopy = "클립보드에 복사할 텍스트입니다.";
  const handleCopyClick = () => {
    copyToClipboard(textToCopy);
  };

  return (
    <div className="p-4 text-center text-gray-700 border border-gray-300 rounded-lg">
      <p>{textToCopy}</p>
      <button
        onClick={handleCopyClick}
        className="px-4 py-2 mt-2 text-white bg-blue-500 rounded-lg hover:bg-blue-700"
      >
        복사하기
      </button>
      {isCopied && <p className="mt-2 text-green-500">복사되었습니다!</p>}
    </div>
  );
}
