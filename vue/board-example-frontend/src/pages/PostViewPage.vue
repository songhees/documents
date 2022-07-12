<template>
  <div class="post-view-page">
    <!-- <div class="post-view">
      <div>
        <h1>게시글의 제목</h1>
        <span>게시글 번호 1</span>
        <strong>이름 . 2019-01-01 09:00</strong>
      </div>
      <p>내용</p>
    </div> -->
    <post-view v-if="post" :post="post"/>
    <p v-else>게시글 불러오는중...</p>
    <router-link :to="{ name: 'PostListPage'}">목록</router-link>
  </div>
</template>
<script>
import {mapState, mapActions} from 'vuex'
import PostView from '@/components/PostView'

export default ({
  name: 'PostViewPage',
  components: {
    PostView
  },
  props: {
    postId: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState([
      'post'
    ])
  },
  created () {
    this.fetchPost(this.postId)
      .catch(err => {
        alert(err.response.data.msg)
        this.$router.back()
      })
  },
  methods: {
    ...mapActions([
      'fetchPost'
    ])
  }
})
</script>
