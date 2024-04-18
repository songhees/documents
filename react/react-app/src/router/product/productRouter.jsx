import { Navigate } from "react-router-dom";
import React, { Suspense } from 'react';
const AddProduct = React.lazy(() => import("@pages/product/AddProduct"))
const ListPage = React.lazy(() => import("@pages/product/ListPage"))
const ReadPage = React.lazy(() => import("@pages/product/ReadPage"))
const ModifyPage = React.lazy(() => import("@pages/product/ModifyPage"))
const loading = <div style={{backgroundColor: 'black'}}>loding...</div>

export default [
  {
    path: 'list',
    element: <Suspense fallback={loading}><ListPage/></Suspense>
  },
  {
    path: '',
    element: <Navigate replace={true} to="list"></Navigate>
  },
  {
    path: 'add',
    element: <Suspense fallback={loading}><AddProduct/></Suspense> 
  },
  {
    path: 'read/:pno',
    element: <Suspense fallback={loading}><ReadPage/></Suspense> 
  },
  {
    path: 'modify/:pno',
    element: <Suspense fallback={loading}><ModifyPage/></Suspense> 
  }
]