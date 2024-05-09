import { useEffect, useState } from "react";
import { getOne, deleteOne } from "@api/productApi";
import FetchingModal from "@components/common/FetchingModal";
import useCustomMove from "@hooks/useCustomMove"
import useCustomCart from "@hooks/useCustomCart"
import useCustomLogin from "@hooks/useCustomLogin"

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
  const {changeCart, cartItems} = useCustomCart();
  const {loginState} = useCustomLogin();
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
  const handleChangeCartItem = () => {
    let qty = 1;
    let target = cartItems.filter(item => item.pno == pno)[0];
    if (target) {
      if(window.confirm("이미 추가된 상품입니다. 추가하시겠습니까? ") === false) {
        return 
      }
      qty = 1 + target.qty;
    }
    changeCart({email: loginState.email, pno:pno, qty:qty})
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
      <button type="button" onClick={handleChangeCartItem}>Add</button>
      <button type="button" onClick={() => moveToModify(pno)}>Modify</button>
      <button type="button" onClick={deletePro}>Delete</button>
    </div>
  )
}

export default ReadComponent;