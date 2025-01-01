import Link from "next/link"
import classes from './page.module.css'
import MealsGrid from "@/components/meals/meals-gird"
import { getMeals } from "@/lib/meals"
import { Suspense } from "react";

export const metadata = {
    title: 'All Meals',
    description: 'Browse the delicious meals.',
  };

async function Melas() {
    const meals = await getMeals();
    return (
        <MealsGrid meals={meals}/>
    )
}

export default function MealsPage() {
    return (
        <>
            <header className={classes.header}>
                <h1>
                    Delicious, meals, created{' '}
                    <span className={classes.highlight}>by you</span>
                </h1>
                <p>Choose yout recipe</p>
                <p className={classes.cta}>
                    <Link href="/meals/share">
                        Share your recipe
                    </Link>
                </p>
            </header>
            <main className={classes.main}>
                <Suspense fallback={<p className={classes.loading}>Fetching meals...</p>}>
                    <Melas/>
                </Suspense>
            </main>
        </>
    )
}