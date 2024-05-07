import loginSlice from '@slice/LoginSlice'
import { configureStore } from '@reduxjs/toolkit'

export default configureStore({
  reducer: {
    "loginSlice" : loginSlice,
  },
})
