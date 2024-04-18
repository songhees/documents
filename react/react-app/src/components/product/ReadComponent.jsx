import { useEffect, useState } from "react";
import { getOne, deleteOne } from "@api/productApi";
import FetchingModal from "@components/common/FetchingModal";
import useCustomMove from "@hooks/useCustomMove"

const initProduct = {
  pno: '',
  pname: '',
  price: 0,
  pdesc: '',
  delFlag: false,
  files: [],
  uploadFileNames: [],
}

const ReadComponent = ({pno}) => {
  const [result, setResult] = useState(initProduct);
  const [fetching, setFetching] = useState(false);
  const {moveToModify, moveToList} = useCustomMove();
  useEffect(() => {
    console.log(pno)
    setFetching(true);
    getOne(pno)
    .then((response) => {
      setResult(response);
      setFetching(false);
    })
    .catch((error) => {
      setFetching(false);
    })
  }, [pno])
  const deletePro = () => {
    deleteOne(pno).then((response) => {
      if (response.RESULT == 'SUCCESS') {
        moveToList();
      }
    })
    .catch((error) => {
      console.log(error)
    })
  }
  return (
    <div>
      {fetching && <FetchingModal/> }
      { result &&
        <div>
          {result.pno}
          {result.pname}
          {result.price}
          {result.pdesc}
          {result.delFlag}
          {result.files}
          {result.uploadFileNames.map((file, index) => {
            return (<img alt="products"  src={`http://localhost:8080/api/products/view/${file}`}/>)
          })}
        </div>
      }
      <button type="button" onClick={() => moveToModify(pno)}>Modify</button>
      <button type="button" onClick={deletePro}>Delete</button>
    </div>
  )
}

export default ReadComponent;