"use client";

import { InfiniteScroll } from "@/components/board/List/InfiniteScroll";
import SearchForm from "@/components/board/List/SearchFormScoll";
import { handleFileDownload } from "@/components/common/FileDownload";
import apiClient from "@/libs/apiClient";
import { ApiResponse, DataInfo } from "@/types/common";
import { NewsInfo } from "@/types/lounge";
import { WebzineInfo } from "@/types/mesh-hub";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useCallback, useEffect, useRef, useState } from "react";

const searchObject = {
  searchText: "",
  pageNo: 1,
  pageSize: 8,
  order: "",
  attachType: "news",
};

type Props = {
  defaultValue?: NewsInfo[];
};

const News = ({ defaultValue }: Props) => {
  const [list, setList] = useState<NewsInfo[]>(defaultValue || []);
  const [isReset, setIsReset] = useState<boolean>(true);
  const [keyword, setKeyword] = useState<string>("");

  const fetchData = async (page: number) => {
    const { data } = await apiClient.post<ApiResponse<NewsInfo[]>>(
      `/news/list`,
      JSON.stringify({
        ...searchObject,
        ...{ searchText: keyword, pageNo: page },
      })
    );
    if (page == 1) {
      setList([...data.data]);
    } else {
      setList((prev) => [...prev, ...data.data]);
    }
    return data.data.length;
  };

  const { observerRef } = InfiniteScroll({
    data: list,
    fetchData,
    isReset,
    initPage: 2,
    isFirstLoad: false,
  });

  const handleKeyword = (e: React.ChangeEvent<HTMLInputElement>) => {
    const inputValue = (e.target as HTMLInputElement).value;
    setKeyword(inputValue);
  };

  const handleSearch = async () => {
    const { data } = await apiClient.post<ApiResponse<NewsInfo[]>>(
      `/news/list`,
      JSON.stringify({
        ...searchObject,
        ...{ searchText: keyword, pageNo: 1 },
      })
    );
    setList(data.data);
    setIsReset((prev) => !prev);
  };

  return (
    <>
      <div className="wrapper">
        <div className="wrap">
          <SearchForm
            onKeyWord={handleKeyword}
            onClick={handleSearch}
            placeholder={"제목, 내용 검색"}
            value={keyword}
          />
          <div className="table">
            <ul className="gallery-type">
              {list?.map((item, index) => {
                return (
                  <li key={index}>
                    <Link href={item.url} target="_blank">
                      <div className="img-area">
                        <img
                          src={
                            item.imgUrl
                              ? `${item.imgUrl}`
                              : "../img/main/dummy.jpeg"
                          }
                          alt={"썸네일"}
                        />
                      </div>
                      <div className="txt-area">
                        <div className="title">{item.title}</div>
                        <div className="sub-txt">{item.contents}</div>
                      </div>
                    </Link>
                  </li>
                );
              })}
            </ul>
          </div>
          <div ref={observerRef} />
        </div>
      </div>
    </>
  );
};

export default News;
