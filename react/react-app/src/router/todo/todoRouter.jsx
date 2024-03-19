import React,{ Suspense } from "react";
import AddPage from "@pages/todo/AddPage";
const ListPage = React.lazy(() => import("@pages/todo/ListPage"));
const ReadPage = React.lazy(() => import("@pages/todo/ReadPage"));
let loading = <div style={{backgroundColor: 'black'}}>Loading...</div>

export default [
  {
    path: "",
    element: <Suspense fallback={loading}><ListPage/></Suspense>,
  },
  {
    path: "read/:tno",
    element: <Suspense fallback={loading}><ReadPage/></Suspense>,
  },
  {
    path: "add",
    element: <AddPage/>,
  }
]