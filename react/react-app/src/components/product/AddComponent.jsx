import { useRef, useState } from "react";
import ResultModal from "@components/common/ResultModal";
import {addOne } from "@api/productApi"
import useCustomMove from "@hooks/useCustomMove";
import FetchingModal from "@components/common/FetchingModal";

const initProduct = {
  pname: '',
  pdesc: '',
  price: 0,
  files: [],
}
const Addcomponent = () => {
  const [product, setProduct] = useState(initProduct);
  const [fetching, setFeching] = useState(false);
  const uploadRef = useRef();

  const [result, setResult] = useState('');
  const {moveToList} = useCustomMove();
  const handleChangeProduct = (e) => {
    product[e.target.name] = e.target.value;
    setProduct({...product});
  }
  const handleClickAdd = (e) => {
    setFeching(true);
    const files = uploadRef.current.files;
    console.log(files)
    var formData = new FormData();

    for (let i = 0; i < files.length; i++) {
      formData.append('files', files[i]);
    }
    formData.append('pname', product.pname);
    formData.append('pdesc', product.pdesc);
    formData.append('price', product.price);
    addOne(formData)
    .then((response) => {
      if (response.result) {
        setResult(response.result);
        setFeching(false);
      }
    })
    .catch((error) => {
      console.log(error);
      setFeching(false);
    })
  }
  const closeModal = (e) => {
    moveToList();
    setResult(null);
  }

  return (
    <div className = "border-2 border-sky-200 mt-10 m-2 p-4"> 
      { 
        fetching && <FetchingModal/>
      }
      { result && <ResultModal title={'Product Add Result'} content={`New ${result} Added`} callbackFn={closeModal} />
      }
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">Product Name</div>
          <input className="w-4/5 p-6 rounded-r border border-solid border-neutral-500 shadow-md" 
           name="pname"
           type={'text'} 
           value={product.pname}
           onChange={handleChangeProduct}
           >
           </input>

        </div>
      </div>
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">Desc</div>
          <input className="w-4/5 p-6 rounded-r border border-solid border-neutral-500 shadow-md" 
           name="pdesc"
           type={'textarea'} 
           value={product.pdesc}
           onChange={handleChangeProduct}
           >
           </input>
        </div>  
      </div>
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">Price</div>
          <input className="w-4/5 p-6 rounded-r border border-solid border-neutral-500 shadow-md" 
           name="price"
           type={'number'} 
           value={product.price}
           onChange={handleChangeProduct}
           >
           </input>
        </div>
      </div>
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">Files</div>
          <input className="w-4/5 p-6 rounded-r border border-solid border-neutral-500 shadow-md" 
           name="files"
           type={'file'} 
           ref={uploadRef}
           multiple={true}
           >
           </input>
        </div>
      </div>
      <div className="flex justify-end">
        <div className="relative mb-4 flex p-4 flex-wrap items-stretch">
          <button type="button" 
          className="rounded p-4 w-36 bg-blue-500 text-xl  text-white "
          onClick={handleClickAdd}          
          >
          ADD
          </button>
        </div>
      </div>
    </div>
  )
};

export default Addcomponent;