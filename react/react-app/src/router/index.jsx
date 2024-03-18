import { createBrowserRouter } from 'react-router-dom'
import App from '@/App.jsx'
import MainRouter from '@router/main'
import Template from '@pages/Template'

const router =  createBrowserRouter([
  {
    path: '/',
    element: <App/>
  },
  {
    path: '/main',
    element: <Template/>,
    children: MainRouter
  }
])
export default router;