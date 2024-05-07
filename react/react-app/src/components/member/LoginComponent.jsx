import { useState } from "react"
import { useDispatch } from "react-redux"
import useCustomLogin from "@hooks/useCustomLogin"
import KakaoLoginComponent from "@components/member/KakaoLoginComponent"

const initUserInfo = {
  email: '',
  pw: '',
}

const LoginComponent = () => {
  const [userInfo, setUserInfo] = useState(initUserInfo);
  const dispatch = useDispatch();
  const {doLogin, moveToPath} = useCustomLogin();

  const clickLogin = () => {
    doLogin(userInfo)
    .then(data => {
      console.log("after ....")
      console.log(data)
      if (data.error) {
        
      } else {
        moveToPath(`/`)
      }
    })
  }
  const handleData = (event) => {
    userInfo[event.target.name] = event.target.value;
     setUserInfo({...userInfo})
  }

  return (
    <div className = "border-2 border-sky-200 mt-10 m-2 p-4">
      <div className="flex justify-center">
        <div className="text-4xl m-4 p-4 font-extrabold text-blue-500">Login Component</div>
      </div> 
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-full p-3 text-left font-bold">Email</div>
          <input className="w-full p-3 rounded-r border border-solid border-neutral-500 shadow-md" 
            type={'text'} 
            name="email" 
            value={userInfo.email} 
            onChange={handleData} 
          />
        </div> 
      </div>
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-full p-3 text-left font-bold">Password</div>
          <input className="w-full p-3 rounded-r border border-solid border-neutral-500 shadow-md" 
            type={'password'} name="pw" value={userInfo.password} onChange={handleData} /> 
        </div>
      </div>
      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full justify-center">
          <div className="w-2/5 p-6 flex justify-center font-bold">
            <button 
              className="rounded p-4 w-36 bg-blue-500 text-xl  text-white"
              onClick={clickLogin} type={'button'} >login
            </button>
          </div>
        </div>
      </div>
      <KakaoLoginComponent/>
    </div>
  )
}

export default LoginComponent