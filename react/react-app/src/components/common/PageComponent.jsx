import useCustomMove from "@hooks/useCustomMove";

const PageComponent = ({data, movePage}) => {
  return (
    <div className="m-6 flex justify-center">
      {
        data.prev && 
        <div 
          className="m-2 p-2 w-16 text-center  font-bold text-blue-400 "
          onClick={() => movePage({page:data.prevPage} )}>
          Prev</div>
      }
      {
        data.pageNumList.map(pageNum => 
          <div 
          key={pageNum}
          className={ `m-2 p-2 w-12  text-center rounded shadow-md text-white ${data.current === pageNum? 'bg-gray-500':'bg-blue-400'}`}
          onClick={() => movePage( {page:pageNum})}>
          {pageNum}
          </div>
        )
      }
      {
        data.next &&
        <div
          className="m-2 p-2 w-16 text-center  font-bold text-blue-400 "
          onClick={() => movePage({page:data.nextPage} )}>
          Next</div>
      }
    </div>
  )
}

export default PageComponent;