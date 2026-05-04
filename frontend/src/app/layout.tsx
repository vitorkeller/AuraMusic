import type { Metadata } from "next";
import { Quicksand } from "next/font/google";
import "./globals.css";
import AuthProvider from "../components/AuthProvider";
import Sidebar from "../components/Sidebar";
import Player from "../components/Player";

const quicksand = Quicksand({
  variable: "--font-quicksand",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "Aura Music",
  description: "Streaming de música",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-BR">
      <body className={`${quicksand.variable} font-sans antialiased overflow-hidden`}>
        <AuthProvider>
          <div className="flex h-screen w-full bg-black/20">
            <Sidebar />
            <main className="flex-1 overflow-y-auto relative pb-32">
              {children}
            </main>
          </div>
          <Player />
        </AuthProvider>
      </body>
    </html>
  );
}