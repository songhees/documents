import PageComponent from "@components/common/PageComponent";
import { useEffect, useState } from "react";
import { getList } from "@api/productApi"
import useCustomMove from "@hooks/useCustomMove";
import useCustomLogin from "@hooks/useCustomLogin";
import { useQuery, useQueryClient } from "@tanstack/react-query";
import FetchingModal from "@components/common/FetchingModal";

const initList = {
  dtoList:[],
  pageNumList:[],
  pageRequestDTO: null,
  prev: false,
  next: false,
  totoalCount: 0,
  prevPage: 0,
  nextPage: 0,
  totalPage: 0,
}

const ListComponent = () => {
  const {moveToList, page, size, refresh} = useCustomMove();
  const {exceptionHandle, moveToLogin} = useCustomLogin();
  const {moveToRead} = useCustomMove();

  const { isError, data, error, isFetching } = useQuery(
      ['products/list', {page, size, refresh}],
      () => getList({page:page, size:size}),
      {staleTime: 1000*5}
  )

  const queryClient = useQueryClient();

  const handleClickPage = (pageParam) => {
    // if (pageParam.page == page) {
    //   queryClient.invalidateQueries("products/list");
    // }
    moveToList(pageParam);
  }
  
  if (isError) {
    console.log(error)
    return moveToLogin();
  }

  const serverData = data || initList;
  // useEffect(() => {
  //   getList({page:page, size:size})
  //   .then((result) => {
  //     console.log(result.dtoList)
  //     setResult(result);
  //   })
  //   .catch((error) => {
  //     exceptionHandle(error);
  //     console.log(error);
  //   })
  // }, [page, size, refresh])

  return (
    <div className="border-2 border-blue-100 mt-10 mr-2 ml-2">
      {isFetching && <FetchingModal/>}
      <div className="felx flex-wrap mx-auto p-6">
      {serverData.dtoList.length > 0 &&
        serverData.dtoList.map((item, index) => {
          return (
            <div key={index} onClick={() => moveToRead(item.pno)}>
              <p>{item.pno}</p>
              <p>{item.pname}</p>
              <p>{item.price}</p>
              <p>{item.pdesc}</p>
              <p>{item.delFlag}</p>
              <img/>
            </div>
          )
        })
      }
      </div>
      <PageComponent data={serverData} movePage={handleClickPage}/>
    </div>
  )
}

export default ListComponent;