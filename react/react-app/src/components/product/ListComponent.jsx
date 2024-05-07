import PageComponent from "@components/common/PageComponent";
import { useEffect, useState } from "react";
import { getList } from "@api/productApi"
import useCustomMove from "@hooks/useCustomMove";
import useCustomLogin from "@hooks/useCustomLogin";

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
  const {exceptionHandle} = useCustomLogin();
  const [result, setResult] = useState(initList);
  const {moveToRead} = useCustomMove();

  useEffect(() => {
    getList({page:page, size:size})
    .then((result) => {
      console.log(result.dtoList)
      setResult(result);
    })
    .catch((error) => {
      exceptionHandle(error);
      console.log(error);
    })
  }, [page, size, refresh])

  return (
    <div>
      {result.dtoList.length > 0 &&
        result.dtoList.map((item, index) => {
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
      <PageComponent data={result} movePage={moveToList}/>
    </div>
  )
}

export default ListComponent;