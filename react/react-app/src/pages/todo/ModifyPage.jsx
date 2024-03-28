import { useNavigate, useParams } from "react-router-dom";
import ModifyComponent from "@components/todo/ModifyComponent";

const ModifyPage = () => {
  const {tno} = useParams();
  return ( 
    <div className="text-3xl font-extrabold">
      Todo Modify Page 
      <ModifyComponent tno={tno}/>
    </div> 
   );
}
 
export default ModifyPage;