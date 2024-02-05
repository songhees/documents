
import { useLoaderData } from 'react-router-dom'
import Post from "./Post";
import classes from "./PostList.module.css";

function PostList() {
  const posts = useLoaderData();
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
      {posts.length > 0 && (
        <ul className={classes.posts}>
          {posts.map((post, index) => <Post key={index} author={post.author} body={post.body}/> )
          }
        </ul>
      )} 
      {posts.length === 0 && (
        <div style={{textAlign: 'center', color: 'white'}}>
          <h2>There is no posts yet</h2>
          <p>start adding some</p>
        </div>
      )}
    </>
  )
}

export default PostList;