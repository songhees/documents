import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import App, { loader as postsLoader  } from '../App'
import RootLayout from '../components/routers/RootLayout'
import postRouter from './post'

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
        children: postRouter 
      },
    ]
  },
])
export default router;