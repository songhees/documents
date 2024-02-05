import classes from './Modal.module.css'
import { useNavigate } from 'react-router-dom';

function Modal({children}) {
  const navigate = useNavigate()
  function closeHanlder(event) {
    navigate('/')
  }

  return (
  <>
    <div className={classes.backdrop} onClick={closeHanlder}/> 
    <dialog open className={classes.modal}>
      {children}
    </dialog>
  </>
  )
}

export default Modal;