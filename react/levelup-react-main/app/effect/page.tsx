import CounterEffect from "./counter-effect";
import Timer from "./timer";

export default function Page() {
  return (
        <main className="flex flex-col p-4 space-y-2">
          <Timer />
          <CounterEffect />
        </main>

  );
}
