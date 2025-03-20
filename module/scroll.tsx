"use client";

import { ReactNode, useEffect, useRef, useState } from "react";

type Props = {
  data: any[];
  fetchData: (page: number) => Promise<number>;
  isReset: boolean;
  initPage?: number;
  isFirstLoad?: boolean;
};

/**
 *
 * @param param0
 * isFirstLoad: infiniteScroll에서 첫번째 pageNo =1를 load하는 경우 = true
 *              부모 컴포넌트에서 load하는 경우 = false
 * isReset: 값이 변경되면 observer 다시 생성
 * data: 스크롤 할 데이터
 * initPage: 처음부터 불러올 pageNo
 * fetchData: 스크롤 할 때 데이터(data)를 불러(저장)올 함수
 * @returns
 */
export function InfiniteScroll({
  data,
  fetchData,
  isReset,
  initPage = 1,
  isFirstLoad = false,
}: Props) {
  const observerRef = useRef<HTMLDivElement>(null);
  const [page, setPage] = useState<number>(initPage);
  const [observer, setObserver] = useState<IntersectionObserver>();
  const [isFirstLoadComplete, setIsFirstLoadComplete] = useState(isFirstLoad);

  const createObserver = () => {
    if (observerRef.current) {
      observer?.disconnect();
      const newObserver = new IntersectionObserver(
        (entries) => {
          if (entries[0].isIntersecting) {
            setPage((prev) => prev + 1);
          }
        },
        { threshold: 1.0 }
      );

      setPage(initPage);
      newObserver.observe(observerRef.current);
      setObserver(newObserver); // 새로운 observer 저장
    }
  };

  useEffect(() => {
    createObserver();

    return () => {
      observer?.disconnect();
    };
  }, [isReset]);

  useEffect(() => {
    if (!observer) return;

    fetchData(page).then((value: number) => {
      if (value == 0) {
        observer.disconnect();
      }
    });
  }, [observer, page]);

  return { observerRef };
}
