import React, { Suspense } from 'react';
import { createBrowserRouter } from 'react-router-dom'
import App from '@/App.jsx'
import { Outlet, useNavigate } from "react-router-dom";
const IndexPage = React.lazy(() => import("@pages/todo/IndexPage"));
import MainRouter from '@router/main'
import TodoRouter from '@router/todo'
import ProductRouter from '@router/product'
import MemberRouter from '@router/member/memberRouter'
let loading = <div style={{backgroundColor: 'black'}}>Loading...</div>


const router =  createBrowserRouter([
  {
    path: '/',
    element: <App/>,
    children: [...MainRouter,
      {
        path: '/todo',
        element: <Suspense fallback={loading}><IndexPage/></Suspense>,
        children: TodoRouter,
      },
      {
        path: '/product',
        element: <Suspense fallback={loading}><IndexPage/></Suspense>,
        children: ProductRouter,
      },
      {
        path: '/member',
        element: <Suspense fallback={loading}><Outlet/></Suspense>,
        children: [...MemberRouter],
      },
    ]
  },
])
export default router;