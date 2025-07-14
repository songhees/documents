'use server';

export interface AddToCartState {
  success: boolean | null;
  cartSize?: number;
  message?: string;
}

export async function addToCart(
  id: string,
  prevState: AddToCartState,
  formData: FormData,
) {
  // formData에서 itemID 값을 추출하여 처리
  const formItemId = formData.get('itemID');
  if (formItemId === id && (prevState.cartSize === undefined || prevState.cartSize < 10)) {
    // prevState의 cartSize를 증가시키거나 새로운 값으로 설정
    const newCartSize = prevState.cartSize ? prevState.cartSize + 1 : 1;
    return {
      success: true,
      cartSize: newCartSize,
    };
  } else {
    return {
      success: false,
      message: "상품이 매진되었습니다.",
    };
  }
}
