import Image from "next/image";
import Link from "next/link";

export function Header(){
    return(
        <header className="relative">
            <div className="grid grid-cols-[auto_1fr] ml-7 mr-20 pt-6 gap-8 relative z-10 items-center">
                <Link href={"/"}>
                    <Image className="z-10" src="/img/icon_black.png" alt="Logo" width={45} height={45} />
                </Link>
                
                <div className="flex  items-center border border-white/10 rounded-full z-10 bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                    <Image className="p-4 ml-2 mr-2" src="/img/search.png" alt="Lupa" width={50} height={50} />
                    <input className="w-full outline-none bg-transparent" type="text" placeholder="Search Artists"/>
                </div>
            </div>

            <Image className="z-0 absolute top-0 w-full mask-top" src="/img/page-top-bg.jpg" alt="Background" width={2608} height={188} />                
        </header>
    );
}
             