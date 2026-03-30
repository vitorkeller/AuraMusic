import type { Metadata } from "next";
import { Quicksand } from "next/font/google";
import "./globals.css";


const geistSans = Quicksand({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Quicksand({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "Aura Music",
  description: "Streaming de música",
  icons: {
    icon: [
      {
        url: "/img/icon_black.png",
        sizes: "16x16",
        type: "image/png"
      }
    ]
  }
};


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-BR">
      <body
        className={`${geistSans.variable} ${geistMono.variable} antialiased`}
      >
        {children}
      </body>
    </html>
  );
}
