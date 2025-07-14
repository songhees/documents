'use client';

import React from 'react';
import { useFormState } from "react-dom";
import { addToCart } from "./actions";
import { AddToCartState } from './actions';

interface AddToCartFormProps {
  itemID: string;
  itemTitle: string;
}

export default function AddToCartForm({ itemID, itemTitle }: AddToCartFormProps) {
  const initialState: AddToCartState = { success: null, message: '', cartSize: 0 };
  const updateProjectWithId = addToCart.bind(null, itemID);
  const [formState, dispatch] = useFormState(updateProjectWithId, initialState);
  return (
    <form action={dispatch} className="p-4 space-y-2 border-2 border-gray-200 rounded-lg shadow">
      <h2 className="text-lg font-semibold">{itemTitle}</h2>
      <input type="hidden" name="itemID" value={itemID} />
      <button type="submit" className="px-4 py-2 text-white bg-blue-500 rounded hover:bg-blue-700">장바구니에 추가</button>
      {formState?.success &&
        <div className="p-2 text-green-800 bg-green-200 rounded">
          장바구니에 추가됨! 장바구니에는 현재 {formState.cartSize}개의 상품이 있습니다.
        </div>
      }
      {formState?.success === false &&
        <div className="p-2 text-red-800 bg-red-200 rounded">
          장바구니에 추가 실패: {formState.message}
        </div>
      }
    </form>
  );
}
