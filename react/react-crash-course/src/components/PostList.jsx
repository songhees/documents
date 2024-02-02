
import { useState, useEffect } from "react";
import Post from "./Post";
import classes from "./PostList.module.css";
import NewPost from "./NewPost";
import Modal from "./Modal";

function PostList({isPosting, showModalHandler}) {
  const [posts, setPosts] = useState([]);
  const [isFetching, setIsFetching] = useState(false);
  console.log(posts)
  useEffect(() => {
    async function fetchPosts() {
      setIsFetching(true);
      const response = await fetch('http://localhost:8080/posts')
      const resData = await response.json(); 
      setPosts(resData.posts);
      setIsFetching(false);
    }
    fetchPosts();
  }, [])
  function addPostsHandler(postData) {
    fetch('http://localhost:8080/posts', {
      method: 'POST',
      body: JSON.stringify(postData),
      headers: {
        'Content-type': 'application/json'
      }
    })
    setPosts((existingPosts) => [postData, ...existingPosts]);
  }
  return (
    <>
      {isPosting && (    
        <Modal onClose={showModalHandler}>
          <NewPost onCancel={showModalHandler} onAddPost={addPostsHandler}></NewPost>
        </Modal> )}
      {!isFetching && posts.length > 0 && (
        <ul className={classes.posts}>
          {posts.map((post, index) => <Post key={index} author={post.author} body={post.body}/> )
          }
        </ul>
      )} 
      {!isFetching && posts.length === 0 && (
        <div style={{textAlign: 'center', color: 'white'}}>
          <h2>There is no posts yet</h2>
          <p>start adding some</p>
        </div>
      )}
      {isFetching && (
        <div style={{textAlign: 'center', color: 'white'}}>
          <p>Loading posts...</p>
        </div>
      )}
    </>
  )
}

export default PostList;