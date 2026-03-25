import Image from "next/image";
import Link from "next/link";

export default function Login(){
    return(
        <div className="grid grid-rows-4 justify-items-center min-h-screen">
            <Link href="/">
                <Image className="row-span-1 pt-30" src="/img/logo_black1.png" alt="Logo" width={310} height={10} />
            </Link>
            
            <div className="mt-6 row-span-3 self-end w-158 h-158 border border-white/10 rounded-t-2xl bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                <div className="flex flex-col h-full">
                    <h1 className="flex justify-center text-3xl pt-8 pb-2 font-bold">Login</h1>

                    <div className="flex flex-col self-center">
                        <p className="flex flex-row pl-5 pb-2">Usuário</p>
                        <div className="flex items-center justify-center w-120 border border-white/10 rounded-full bg-white/8 hover:bg-white/12 backdrop-blur-md shadow-inner shadow-black/30">
                            <Image className="p-4 ml-2 mr-2" src="/img/user.png" alt="User" width={50} height={50} />
                            <input className="w-full outline-none bg-transparent" type="text" placeholder="Digite seu usuário..."/>
                        </div>

                        <p className="flex flex-row pl-5 pb-2 pt-5">Senha</p>
                        <div className="flex items-center justify-center w-120 border border-white/10 rounded-full bg-white/8 hover:bg-white/12 backdrop-blur-md shadow-inner shadow-black/30">
                            <Image className="p-4 ml-2 mr-2" src="/img/pin.png" alt="Pin" width={50} height={50} />
                            <input className="w-full outline-none bg-transparent" type="password" placeholder="Digite sua senha..."/>
                        </div>

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
             