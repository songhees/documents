import ListComponent from "@components/product/ListComponent";
import { useState } from "react";
import useCustomMove from "@hooks/useCustomMove";

const ListPage = () => {
  const [result, setResult] = useState([]);
  const {moveToList} = useCustomMove();
  return (
    <div>
      <ListComponent/>
    </div>
  )
}

export default ListPage;