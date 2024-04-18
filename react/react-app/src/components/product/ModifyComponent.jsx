import { useEffect, useState, useRef } from "react";
import { getOne, putOne } from "@api/productApi";
import FetchingModal from "@components/common/FetchingModal";
import useCustomMove from "@hooks/useCustomMove"
import ResultModal from "@components/common/ResultModal";

const initProduct = {
  pno: '',
  pname: '',
  price: 0,
  pdesc: '',
  delFlag: false,
  files: [],
  uploadFileNames: [],
}

const ModifyComponent = ({pno}) => {
  const [product, setProduct] = useState(initProduct);
  const [fetching, setFetching] = useState(false);
  const [result, setResult] = useState(false);
  const {moveToList, moveToRead} = useCustomMove();
  const uploadRef = useRef();

  useEffect(() => {
    console.log(pno)
    setFetching(true);
    getOne(pno)
    .then((response) => {
      setProduct(response);
      setFetching(false);
    })
    .catch((error) => {
      setFetching(false);
    })
  }, [pno])

  const handleChangeProduct = (e) => {
    product[e.target.name] = e.target.value;
    setProduct({...product});
  }
  const handleClickModify = (e) => {
    setFetching(true);
    const files = uploadRef.current.files;
    console.log(files)
    var formData = new FormData();

    for (let i = 0; i < files.length; i++) {
      formData.append('files', files[i]);
    }

    for (let i = 0; i < product.uploadFileNames.length; i++) {
      formData.append('uploadFileNames', product.uploadFileNames[i])
    }
    formData.append('pname', product.pname);
    formData.append('pdesc', product.pdesc);
    formData.append('price', product.price);
    putOne(pno, formData)
    .then((response) => {
      console.log(response)
      if (response.RESULT == 'SUCCESS') {
        setResult('Modify');
        setFetching(false);
      }
    })
    .catch((error) => {
      console.log(error);
      setFetching(false);
    })
  }
  const closeModal = (e) => {
    if (result == 'Modify') {
      moveToRead(pno);
    }
    setResult(null)
  }
  const deleteOldImages = (fileName) => {
    const resultFileList = product.uploadFileNames.filter(file => file !== fileName);
    product.uploadFileNames = resultFileList
    setProduct({...product});
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
        <div className="w-1/5 p-6 text-right font-bold">DELETE</div>
          <select 
          name="delFlag" value={product.delFlag}
          onChange={handleChangeProduct}
          className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md">
            <option value={false}>사용</option>
            <option value={true}>삭제</option>
          </select>
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
    <div className="flex justify-center">
      <div className="relative mb-4 flex w-full flex-wrap items-stretch">
        <div className="w-1/5 p-6 text-right font-bold">
          Images          
        </div>
        <div className="w-4/5 justify-center flex flex-wrap items-start">
        
        {product.uploadFileNames.map( (imgFile, i) => 
            <div
              className="flex justify-center flex-col w-1/3" 
              key = {i}>
              <button className="bg-blue-500 text-3xl text-white"
              onClick={() => deleteOldImages(imgFile)}
              >DELETE</button>
              <img 
              alt ="img" 
              src={`http://localhost:8080/api/products/view/s_${imgFile}`}/>
              
            </div>
        )}
        </div>
      </div>
    </div>
    <div className="flex justify-end p-4">
      <button type="button" 
      className="inline-block rounded p-4 m-2 text-xl w-32  text-white bg-orange-500"
      onClick={handleClickModify}
      >
        Modify
      </button>
      
      <button type="button" 
      className="rounded p-4 m-2 text-xl w-32 text-white bg-blue-500"
      onClick={moveToList}
      >
        List
      </button>

    </div>
  </div>
  )
}

export default ModifyComponent;