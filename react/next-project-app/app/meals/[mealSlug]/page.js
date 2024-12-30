export default function MealDetailsPage({ params }) {
    return (
        <>
            <h1>MealsSubPage</h1>
            <p>{ params.mealSlug }</p>
        </>
    )
}