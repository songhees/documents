import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import App, { loader as postsLoader  } from '../App'
import RootLayout from '../components/routers/RootLayout'
import NewPost from '../components/NewPost'
// import mainRouter from './router'

const router = 
createBrowserRouter([
  {
    path: '/',
    element: <RootLayout/>,
    children: [
      {
        path: '/',
        element: <App/>,
        loader: postsLoader,
        children: [
           {
            path: '/create-post',
            element: <NewPost/>
          }
        ]
      },
    ]
  },
])
export default router;