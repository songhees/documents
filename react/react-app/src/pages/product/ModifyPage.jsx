import {useParams} from "react-router-dom"
import ModifyComponent from "@components/product/ModifyComponent"

const ModifyPage = () => {
  const {pno} = useParams('pno');
  return (
    <div>
      <ModifyComponent pno={pno}/>
    </div>
  )
}

export default ModifyPage;