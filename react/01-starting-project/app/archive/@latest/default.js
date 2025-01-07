import NewsList from "@/components/news-list";
import { getLatestNews } from "@/lib/news"

export default function LatestNewsPAge() {
    const latestNews = getLatestNews();
    return <>
        <h1>LatestNewsPAge</h1>
        <NewsList news={latestNews}/>
    </>
}