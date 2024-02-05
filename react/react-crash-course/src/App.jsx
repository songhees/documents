import { useState } from 'react'
import { Outlet } from 'react-router-dom';
import PostList from './components/PostList'

function App() {
  return (
    <>
      <Outlet/>
      <main>
        <PostList></PostList>
      </main>
    </>
  )
}

export default App

export async function loader() {
  const response = await fetch('http://localhost:8080/posts')
  const resData = await response.json(); 
  return resData.posts;
}