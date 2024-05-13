import './App.css'
import "./index.css";
import { Outlet } from 'react-router-dom';
import { Provider, useSelector, useDispatch } from 'react-redux';
import store from '/store';
import BasicLayout from "@layouts/BasicLayout";
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <Provider store={store}>
        <Outlet/>
      </Provider>
      <ReactQueryDevtools initialIsOpen={true} />
    </QueryClientProvider>
  )
}
export default App
