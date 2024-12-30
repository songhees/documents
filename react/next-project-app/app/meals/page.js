import Link from "next/link"

export default function MealsPage() {
    return (
        <>
            <h1>MealsPage</h1>
            <p><Link href="/meals/share">share</Link></p>
            <p><Link href="/meals/icecream">ice</Link></p>
        </>
    )
}