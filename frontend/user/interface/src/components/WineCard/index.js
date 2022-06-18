import React, { useEffect, useState } from 'react'
import { IoStar, IoStarOutline, IoClose } from 'react-icons/io5'

const WineCard = (props) => {
    let stars = new Array(5);
    for (let index = 0; index < stars.length; index++) {
        if (index < Math.round(props.wine.ratingScore)) stars[index]=<IoStar className="mx-0.5"></IoStar>
        else stars[index]=<IoStarOutline className="mx-0.5"></IoStarOutline>
    }
    




    return (
        <div className="rounded-lg bg-dark flex p-8 pr-16 relative">
            <div className="absolute right-4 top-4 text-xl cursor-pointer" onClick={()=>props.closeModal()}><IoClose></IoClose></div>
            <div className="flex flex-col">
                <img className="w-[400px] h-[400px] self-center rounded-lg" src={props.wine.image === undefined ? "https://picsum.photos/400" : props.wine.image} alt=""></img>
                <p className="mt-8 text-xl text-semibold">Price:<span className="ml-2">{props.wine.price}</span></p>
                <p className="mt-4 text-xl text-semibold">Quantity:<span className="ml-2">{props.wine.quantity}</span></p>
                <p className="mt-8 text-xl text-semibold">Rating <span className="text-sm font-normal">({props.wine.numRatings} rates)</span>:</p>
                <div className="flex mt-1 text-yellow-500 text-lg">{stars}</div>
            </div>
            <div className="flex flex-col ml-20 mt-14">
                <p className="text-3xl font-bold">Vinho del Puerto <span className="font-normal">,</span> <span className="font-normal ml-4"> 0.75 L</span></p>
                <p className="mt-2 text-base text-semibold">From <span className="ml-2">{props.wine.winery}</span></p>
                <p className="mt-8 text-xl text-semibold">Type:<span className="ml-2">{props.wine.type}</span></p>
                <p className="mt-3 text-xl text-semibold">Grapes:<span className="ml-2">{props.wine.grapeVariety}</span></p>
                <p className="mt-3 text-xl text-semibold">Country:<span className="ml-2">{props.wine.country}</span></p>
                <p className="mt-3 text-xl text-semibold">Region:<span className="ml-2">{props.wine.region}</span></p>
                <p className="mt-8 text-xl text-semibold">Description:</p>
                <p className="mt-2 text-lg text-justify">{props.wine.description}</p>

            </div>


        </div>
    )
}

export default WineCard