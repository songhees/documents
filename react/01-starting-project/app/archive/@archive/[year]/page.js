import NewsList from "@/components/news-list";
import { getNewsForYear } from "@/lib/news";

export default function FilteredNewsPage({params}) {
    const newsYear = params.year;

    return <NewsList news={getNewsForYear(newsYear)}/>
}