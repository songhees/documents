import { useEffect, useState } from "react"
import useSWR from "swr";

export default function LastSalesPage(props) {
    const [sales, setSales] = useState(props.sales);
    // const [isLoading, setIsLoading] = useState(false);
    

    // useEffect(() => {
    //     const transformedSales = []

    //     for (const key in data) {
    //         transformedSales.push({
    //             id: key,
    //             username: data[key].username,
    //             username: data[key].volume,
    //         })
    //     }
    //     setSales(transformedSales)
    // }, [data])

    // useEffect(() => {
    //     setIsLoading(true)
    //     fetch('api/url')
    //     .then(response => response.json())
    //     .then(data => {
    //         const transformedSales = []

    //         for (const key in data) {
    //             transformedSales.push({
    //                 id: key,
    //                 username: data[key].username,
    //                 username: data[key].volume,
    //             })
    //         }

    //         setSales(transformedSales)
    //         setIsLoading(false)
    //     })
    // }, [])

    // if (!sales) {
    //     return <p>no data</p>
    // }

    // if (error) {
    //     return <p>Failed to load</p>
    // }

    // if (!data && !sales) {
    //     return <p>Loading...</p>
    // }

    return (
        <ul>
            {/* {sales.map(sale => <li key={sale.id}>{sale.username} - ${sale.volume}</li>)} */}
        </ul>
    )
    
}

// export async function getStaticProps() {
//     return fetch('http://localhost:3000')
//     .then(response => response.json())
//     .then(data => {
//         const transformedSales = []

//         for (const key in data) {
//             transformedSales.push({
//                 id: key,
//                 username: data[key].username,
//                 username: data[key].volume,
//             })
//         }

//         return { props: {sales: transformedSales}, revalidate: 10 }
//     })
// } 