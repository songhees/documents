import BasicMenu from "@components/menu/BasicMenu";

function MainPage() {
  return (
    <div className='fixed top-0 left-0 z-[1055] flex flex-col h-full w-full'>
      <BasicMenu></BasicMenu>
      <div className=" text-3xl underline">Main Page</div>
    </div>
  )
}

export default MainPage;