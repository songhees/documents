import NewPost, { action as postAction } from "../../components/NewPost"
import PostDetails, { loader as postLoader } from "../../components/PostDetails"

export default [
  {
    path: '/create-post',
    action: postAction,
    element: <NewPost/>,
  },
  {
    path: '/:postId',
    loader: postLoader,
    element: <PostDetails/>,
  }

]
