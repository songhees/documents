import React, { Suspense } from 'react';
import { createBrowserRouter } from 'react-router-dom'
import App from '@/App.jsx'
const TodoLayout = React.lazy(() => import("@pages/todo/IndexPage"));
import MainRouter from '@router/main'
import TodoRouter from '@router/todo'
let loading = <div style={{backgroundColor: 'black'}}>Loading...</div>


const router =  createBrowserRouter([
  {
    path: '/',
    element: <App/>,
    children: MainRouter
  },
  {
    path: '/todo',
    element: <Suspense fallback={loading}><TodoLayout/></Suspense>,
    children: TodoRouter,
  }
])
export default router;