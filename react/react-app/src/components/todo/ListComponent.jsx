import { getList } from "@api/todoApi";
import useCustomMove from "@hooks/useCustomMove";
import { useEffect, useState } from "react"
import PageComponent from "@components/common/PageComponent"

const initState = {
  dtoList:[],
  pageNumList:[],
  pageRequestDTO: null,
  prev: false,
  next: false,
  totoalCount: 0,
  prevPage: 0,
  nextPage: 0,
  totalPage: 0,
  current: 0
}

const ListComponent = () => {

  const {moveToList, moveToModify, moveToRead, page, size, refresh} = useCustomMove();
  const [list, setList]= useState(initState);
  useEffect(() => {
    getList({page, size}).then((data) => {
      setList(data);
    })
  }, [page, size, refresh])
  return (
    <div className="border-2 border-blue-100 mt-10 mr-2 ml-2">   
      <div className="flex flex-wrap mx-auto justify-center p-6">
      { list.dtoList.map((todo, index) =>
        <div
        key= {todo.tno} 
        className="w-full min-w-[400px]  p-2 m-2 rounded shadow-md"
        onClick={() => moveToRead(todo.tno)} //이벤트 처리 추가 
        >  
          <div className="flex ">
            <div className="font-extrabold text-2xl p-2 w-1/12">
              {todo.tno}
            </div>
            <div className="text-1xl m-1 p-2 w-8/12 font-extrabold">
              {todo.title}
            </div>
            <div className="text-1xl m-1 p-2 w-2/10 font-medium">
              {todo.dueDate}
            </div>
          </div>
        </div>
        )
      }
      </div>
      <PageComponent data={list} movePage={moveToList}></PageComponent>
    </div>
  );
}

export default ListComponent;