import React, { Suspense } from "react";
const LoginPage = React.lazy(() => import('@pages/member/LoginPage'));
const LogoutPage = React.lazy(() => import('@pages/member/LogoutPage'));
const ModifyPage = React.lazy(() => import('@pages/member/ModifyPage'));
const KakaoRedirectPage = React.lazy(() => import('@pages/member/KakaoRedirectPage'));
const loading = <div style={{backgroundColor: 'black'}}>loding...</div>

export default [
  {
    path: 'login',
    element: <Suspense fallback={loading}><LoginPage/></Suspense>
  },
  {
    path: 'logout',
    element: <Suspense fallback={loading}><LogoutPage/></Suspense>
  },
  {
    path: 'kakao',
    element: <Suspense fallback={loading}><KakaoRedirectPage/></Suspense>
  },
  {
    path: 'modify',
    element: <Suspense fallback={loading}><ModifyPage/></Suspense>
  }
]