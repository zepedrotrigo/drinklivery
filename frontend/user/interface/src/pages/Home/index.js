import React, { } from 'react'
import {useNavigate} from 'react-router-dom'


const Home = () => {

    const navigate = useNavigate();
    return (
        <div className="container-4/5 mt-16">
            <div className="flex w-full justify-between">
                <div className="flex flex-col max-w-2xl self-center px-2">
                    <p className="text-5xl">Having that mid afternoon craving for a drink from a refined winery?</p>
                    <p className="text-3xl text-right mt-8">Say no more, we have it!</p>
                    <button onClick={()=>navigate("/wines")} className="bg-primary text-white text-2xl self-center px-8 py-4 rounded-full mt-10 hover:scale-[101%] active:scale-95">Check it out!</button>
                </div>
                <img className="max-w-lg lg:max-w-2xl w-full" src="undraw_wine_tasting_re_4jjf.svg" alt=""/>
            </div>
        </div>
    )
}

export default Home