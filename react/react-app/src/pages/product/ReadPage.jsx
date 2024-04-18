import ReadComponent from "@components/product/ReadComponent"
import { useParams } from 'react-router-dom';

const ReadPage = () => {
  const {pno} = useParams('pno');

  return (
    <div>
      <ReadComponent pno={pno}/>
  </div>
  )
}

export default ReadPage;