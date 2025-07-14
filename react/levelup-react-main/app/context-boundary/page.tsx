import { CounterProvider } from './counter-context';
import { Boundary } from './boundary';
import { CounterStatus, ContextClickCounter, ContextClickCounterMinus } from './context-click-counter';

export default function Page() {
  return (
    <Boundary
        labels={['서버 컴포넌트: 페이지']}
        type="server"
        size="small"
      >
      <CounterProvider>
        <main className="flex flex-col p-4 space-y-2">
          <h1 className="text-xl font-bold">리액트 컨텍스트</h1>
          <ContextClickCounter />
          <ContextClickCounterMinus />
          <CounterStatus />
        </main>
      </CounterProvider>
    </Boundary>
  );
}
