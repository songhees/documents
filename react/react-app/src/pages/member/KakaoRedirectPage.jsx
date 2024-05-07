import { useSearchParams } from "react-router-dom";
import { useEffect } from "react";
import { getAccessToken, getMemberWithAccessToken } from "@api/kakoApi"
import { useDispatch } from "react-redux";
import { login } from "@slice/LoginSlice";
import useCustomLogin from "@hooks/useCustomLogin"

const KakaoRedirectPage = () => {
  const [params] = useSearchParams();
  const dispatch = useDispatch();
  const {moveToPath} = useCustomLogin();

  const authCode = params.get("code");
  useEffect(() => {
    getAccessToken(authCode)
    .then(code => {
      getMemberWithAccessToken(code)
      .then((memberInfo) => {
        console.log(memberInfo);
        dispatch(login(memberInfo));

        if (memberInfo && !memberInfo.social) {
          moveToPath("/");
        } else {
          moveToPath("/member/modify")
        }
      })
    })
  }, [authCode])
  return (
    <div>
      <div>Kakao Login Redirect</div>
      <div>{authCode}</div>
    </div>
  )
}

export default KakaoRedirectPage;