import React,{ Suspense } from "react";
import { Navigate } from "react-router-dom";
import AddPage from "@pages/todo/AddPage";
const ListPage = React.lazy(() => import("@pages/todo/ListPage"));
const ReadPage = React.lazy(() => import("@pages/todo/ReadPage"));
const ModifyPage = React.lazy(() => import("@pages/todo/ModifyPage"));
let loading = <div style={{backgroundColor: 'black'}}>Loading...</div>

export default [
  {
    path: "list",
    element: <Suspense fallback={loading}><ListPage/></Suspense>,
  },
  {
    path: "",
    element: <Navigate replace to={"list"}></Navigate>
  },
  {
    path: "read/:tno",
    element: <Suspense fallback={loading}><ReadPage/></Suspense>,
  },
  {
    path: "add",
    element: <AddPage/>,
  },
  {
    path: "modify/:tno",
    element: <Suspense fallback={loading}><ModifyPage/></Suspense>
  }
]