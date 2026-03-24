import Image from "next/image";

export default function Login(){
    return(
        <div className="grid grid-rows-4 justify-items-center min-h-screen">
            <Image className="row-span-1 pt-30 pb-2" src="/img/logo_black1.png" alt="Logo" width={310} height={10} />
            
            <div className="row-span-3 self-end w-170 h-150 border border-white/10 rounded-t-2xl bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                <div className="flex flex-col h-full">
                    <h1 className="flex justify-center text-3xl pt-8 pb-6 font-bold">Login</h1>

                    <div className="flex flex-col self-center">
                        <p className="flex flex-row pl-5 pb-2">Usuário</p>
                        <div className="flex items-center justify-center w-130 border border-white/10 rounded-full bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                            <Image className="p-4 ml-2 mr-2" src="/img/user.png" alt="User" width={50} height={50} />
                            <input className="w-full outline-none bg-transparent" type="text" placeholder="Digite seu usuário..."/>
                        </div>

                        <p className="flex flex-row pl-5 pb-2 pt-7">Senha</p>
                        <div className="flex items-center justify-center w-130 border border-white/10 rounded-full bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                            <Image className="p-4 ml-2 mr-2" src="/img/pin.png" alt="Pin" width={50} height={50} />
                            <input className="w-full outline-none bg-transparent" type="password" placeholder="Digite sua senha..."/>
                        </div>

                        <button className="flex items-center justify-center w-130 h-13 mt-7 border border-white/10 rounded-full bg-blue-800 00 backdrop-blur-md shadow-inner shadow-black/30">
                            <span className="text-white">Entrar</span>
                        </button >

                        <div className="flex items-center w-full my-6">
                            <div className="flex-1 h-px ml-2 bg-white/30"></div>
                           
                            <span className="px-4 text-white/30 text-sm">Ou continue com</span>
                            
                            <div className="flex-1 h-px mr-2 bg-white/30"></div>
                        </div>
                    </div>
                </div>
            </div>        
        </div>
    );
}
             