<template>
  <div class="post-list-page">
    <h1>포스트 게시글</h1>
    <post-list :posts="posts" />
  </div>
</template>
<script>
import PostList from '@/components/PostList.vue'
// import api from '@/api/index.js'
import {mapState, mapActions} from 'vuex'

export default ({
  name: 'PostListPage',
  components: {
    PostList
  },
  // data () {
  //   return {
  //     posts: []
  //   }
  // },
  computed: {
    ...mapState([
      'posts'
    ])
  },
  created () {
    // api.get('/posts').then(res => {
    //   this.posts = res.data
    // })
    this.fetchPostList()
  },
  methods: {
    ...mapActions([
      'fetchPostList'
    ])
  }
})
</script>
