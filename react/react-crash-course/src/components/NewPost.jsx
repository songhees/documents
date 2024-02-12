import Modal from './Modal';
import classes from './NewPost.module.css'
import { Link, redirect, Form } from 'react-router-dom';

function NewPost(props) {
  return (
    <Modal>
      <Form className={classes.form} method="post">
        <p>
          <label htmlFor="body">Text</label>
          <textarea id="body" required rows={3} name="body"></textarea>
        </p>
        <p>
          <label htmlFor="name">Your name</label>
          <input type="text" id="name" required name="author"/>
        </p>
        <p className={classes.actions}>
          <Link type="button" to="..">Cancel</Link>
          <button>Submit</button>
        </p>
      </Form>
    </Modal>
  )
}

export default NewPost;

export async function action(data) {
  console.log(data)
  const formData = await data.request.formData();
  const postData = Object.fromEntries(formData);
  await fetch('http://localhost:8080/posts', {
    method: 'POST',
    body: JSON.stringify(postData),
    headers: {
      'Content-type': 'application/json'
    }
  })
  return redirect('/');
}