import useCustomLogin from "@hooks/useCustomLogin";
import BasicMenu from "@components/menu/BasicMenu";

function AboutPage() {
  const {isLogin, moveToLogin} = useCustomLogin();
  if (!isLogin) {
    return moveToLogin();
  }
  return (
    <div className='fixed top-0 left-0 z-[1055] flex flex-col h-full w-full'>
      <BasicMenu></BasicMenu>
      <div>
        asdsadasdads
      </div>
    </div>
  )
}

export default AboutPage;