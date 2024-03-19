import React,{ Suspense } from "react";
import AboutPage from "@pages/main/AboutPage"

let MainPage = React.lazy(() => import("@pages/main/MainPage"));
let loading = <div style={{backgroundColor: 'black'}}>Loading...</div>

export default [
  {
    path: '',
    element: <Suspense fallback={loading}>
      <MainPage/>
    </Suspense>
  },
  {
    path: 'about',
    element: <AboutPage/>
  }
]