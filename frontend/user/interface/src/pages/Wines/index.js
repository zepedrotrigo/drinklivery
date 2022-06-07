import React from 'react'

import drinks from './sample'

const Wines = () => {
    return (
        <div className="container-4/5 mt-16 mb-8">

            <div className="">
                <p className="ml-16 text-4xl font-bold underline underline-offset-2">Our wines</p>
            </div>

            <div className="mt-16">
                <p className="text-2xl font-medium"></p>
                <div className="mt-8 grid grid-cols-4 gap-x-8 gap-y-8">
                    {drinks.map((drink, index) => {
                        return (
                                <div key={index} className="shadow shadow-primary-tint-11 py-5 px-8 flex flex-col rounded-xl ">
                                    <img className="w-[200px] h-[200px] self-center rounded-xl" src={drink.image === "" ? "https://picsum.photos/200" : drink.image} alt="" ></img>
                                    <p className="mt-4 text-xl self-center font-semibold">{drink.name}</p>
                                    <p className="mt-3"><span className="font-semibold mr-2">Volume: </span>{drink.volume} L</p>
                                    <p className="mt-1"><span className="font-semibold mr-2">Alcohol/Volume: </span>{drink.alcoholVolume}%</p>
                                    <p className="mt-1"><span className="font-semibold mr-2">Price: </span>{drink.price}€</p>
                                    <p className="mt-1"><span className="font-semibold mr-2">Quantity: </span>{drink.quantity} un</p>
                                    <button className="bg-primary-shade-4 py-2 px-4 text-white self-center mt-4 rounded-xl active:scale-95">Add to Cart!</button>
                                </div>
                        )

                    })}
                </div>
            </div>


        </div>
    )
}

export default Wines