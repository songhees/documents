import React from 'react';

const WelcomeMessage = ({ isLoggedIn }: { isLoggedIn: boolean }) => {
  return (
    <div className="max-w-md p-4 mx-auto text-center">
      {isLoggedIn ? (
        <h1 className="text-xl font-bold text-blue-600">다시 오신 것을 환영합니다!</h1>
      ) : (
        <h1 className="text-xl font-semibold text-red-600 bg-gray-200">로그인 해주세요.</h1>
      )}
    </div>
  );
};

export default function Page() {
  return (
        <main className="flex flex-col p-4 space-y-2">
          <WelcomeMessage isLoggedIn={true} />
          <WelcomeMessage isLoggedIn={false} />
        </main>

  );
}
