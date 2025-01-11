import fs from 'fs/promises';
import Link from 'next/link';
import path from 'path';

function HomePage(props) {
  const {products} = props;
  return (
    <ul>
      {products && products.map(product => <li key={product.id}>
        <Link href={`/${product.id}`}>{product.title}</Link></li>)}
    </ul>
  );
}

export async function getStaticProps() {
  const filePath = path.join(process.cwd(), 'data', 'dummy-backend.json')
  const jsonData = await fs.readFile(filePath)
  const data = JSON.parse(jsonData);
  console.log(JSON.parse(jsonData))

	return {
		props: {
      products: data.products || null,
    },
	}
} 
export default HomePage;
