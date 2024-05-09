import loginSlice from '@slice/LoginSlice'
import cartSlice from '@slice/CartSlice'
import { configureStore } from '@reduxjs/toolkit'

export default configureStore({
  reducer: {
    "loginSlice" : loginSlice,
    "cartSlice" : cartSlice,
  },
})
