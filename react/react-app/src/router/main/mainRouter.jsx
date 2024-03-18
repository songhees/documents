import React,{ Suspense } from "react";

let MainPage = React.lazy(() => import("@pages/MainPage"));
let loading = <div style={{backgroundColor: 'black'}}>Loading...</div>

export default [
  {
    path: '/',
    element: <Suspense fallback={loading}>
      <MainPage/>
    </Suspense>
  },
  {
    path: '/about',
  }
]