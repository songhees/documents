import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import './globals.css'
import { GlobalNav } from './global-nav'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: '레벨업 리액트',
  description: '최신 리액트 개발 기법 with Next.js',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <GlobalNav />
        <div className="lg:pl-72">{children}</div>
      </body>
    </html>
  )
}
