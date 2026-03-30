"use client"

import { useState } from "react"
import Image from "next/image";
import Link from "next/link";
import { InputField } from "@/src/components/InputField";

export default function Login(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    return(
        <div className="grid grid-rows-4 justify-items-center min-h-screen">
            <Link href="/">
                <Image className="row-span-1 pt-30" src="/img/logo_black1.png" alt="Logo" width={310} height={10} />
            </Link>
            
            <div className="mt-6 row-span-3 self-end w-158 h-158 border border-white/10 rounded-t-2xl bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                <div className="flex flex-col h-full">
                    <h1 className="flex justify-center text-3xl pt-8 pb-2 font-bold">Login</h1>

                    <div className="flex flex-col self-center">
                        <InputField
                            label="Usuário"
                            type="text"
                            placeholder="Digite seu usuário..."
                            icon="/img/user.png"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />

                        <InputField
                            label="Senha"
                            type="password"
                            placeholder="Digite sua senha..."
                            icon="/img/pin.png"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />

                        <button className="flex items-center justify-center w-120 h-13 mt-7 border border-white/10 rounded-full bg-blue-800 duration-300 hover:bg-blue-700 backdrop-blur-md shadow-inner shadow-black/30 hover:scale-102 hover:font-bold">
                            <span className="text-white font-medium">Entrar</span>
                        </button >

                        <div className="flex items-center w-full my-8">
                            <div className="flex-1 h-px ml-2 bg-white/30"></div>
                           
                            <span className="px-4 text-white/30 text-sm">Ou continue com</span>
                            
                            <div className="flex-1 h-px mr-2 bg-white/30"></div>
                        </div>

                        <button className="flex items-center justify-center w-120 h-13 border border-white/10 rounded-full bg-white/80 duration-300 hover:bg-white/90 backdrop-blur-md shadow-inner shadow-black/30 hover:scale-102 hover:font-medium">
                            <Image src="/img/IconGoogle.png" alt="Google" width={25} height={25} />
                            <span className="pl-3 text-black">Entrar com Google</span>
                        </button >

                        <span className="flex justify-center mt-25 px-4 text-white/80 text-md">Aura Music © 2026 </span>
                    </div>
                </div>
            </div>        
        </div>
    );
}
             