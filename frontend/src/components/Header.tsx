import Image from "next/image";
import Link from "next/link";

export function Header(){
    return(
        <header>
            <div className="grid grid-cols-[auto_1fr] ml-7 mr-20 pt-6 gap-8 items-center">
                <Link href={"/"}>
                    <Image src="/img/icon_black.png" alt="Logo" width={45} height={45} />
                </Link>
                
                <div className="flex  items-center border border-white/10 rounded-full bg-white/8 backdrop-blur-md shadow-inner shadow-black/30">
                    <Image className="p-4 ml-2 mr-2" src="/img/search.png" alt="Lupa" width={50} height={50} />
                    <input className="w-full outline-none bg-transparent" type="text" placeholder="Search Artists"/>
                </div>
            </div>                
        </header>
    );
}
             