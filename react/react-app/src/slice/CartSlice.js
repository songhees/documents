import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { getCartItems, postChangeCart } from "@api/cartApi";

const initState = []

export const getCartItemsAsync = createAsyncThunk('getCartItemsAsync', (param) => {
  return getCartItems();
})

export const postChangeCartAsync = createAsyncThunk('postChangeCartAsync', (param) => {
  return postChangeCart(param);
})

const cartSlice = createSlice({
  name: 'cartSlice',
  initialState: initState,
  reduces: {

  },
  extraReducers: (builder) => {
    builder.addCase(getCartItemsAsync.fulfilled, (state, action) => {
      return action.payload
    })
    .addCase(postChangeCartAsync.fulfilled, (state, action) => {
      return action.payload;
    })
  }
})

export default cartSlice.reducer;