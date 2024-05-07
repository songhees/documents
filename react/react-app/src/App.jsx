import './App.css'
import "./index.css";
import { Outlet } from 'react-router-dom';
import { Provider, useSelector, useDispatch } from 'react-redux';
import store from '/store';
import BasicLayout from "@layouts/BasicLayout";

function App() {
  return (
    <Provider store={store}>
      <Outlet/>
    </Provider>
  )
}

export default App
