import React, { useEffect, useState } from 'react'
import { useDispatch } from 'react-redux';
import { IoStar, IoStarOutline, IoClose } from 'react-icons/io5'

import { addToCart } from '../../redux/actions'

const WineCard = (props) => {
    const [quantity, setQuantity] = useState(1);
    const [itemAdded, setItemAdded] = useState(false);
    const [animation, setAnimation] = useState("fade-in");
    const dispatch = useDispatch();


    let stars = new Array(5);
    for (let index = 0; index < stars.length; index++) {
        if (index < Math.round(props.wine.ratingScore)) stars[index] = <IoStar key={index} className="mx-0.5"></IoStar>
        else stars[index] = <IoStarOutline key={index} className="mx-0.5"></IoStarOutline>
    }


    const addItemToCart = (wine) => {
        const item = {
            wine, quantity
        }
        dispatch(addToCart(item));
        if(localStorage.getItem("cart")){
            let tempCart = JSON.parse(localStorage.getItem("cart"));
            localStorage.setItem("cart", JSON.stringify([...tempCart, item]));
        }
        else {
            localStorage.setItem("cart", JSON.stringify([item]));

        }
        setItemAdded(true);
        setTimeout(()=>setAnimation("fade-out"), 1000);
        setTimeout(()=>setItemAdded(false), 1300);
        setAnimation("fade-in");
    }


    return (
        <div className="rounded-lg bg-dark flex p-8 pr-16 relative">
            <div className="absolute right-4 top-4 text-xl cursor-pointer" onClick={() => props.closeModal()}><IoClose></IoClose></div>
            <div className="flex flex-col">
                <img className="w-[400px] h-[400px] self-center rounded-lg" src={props.wine.image === undefined ? "https://picsum.photos/400" : props.wine.image} alt=""></img>
                <p className="mt-8 text-xl text-semibold">Price :<span className="ml-3 text-normal">{props.wine.buyPrice} €</span></p>
                <p className="mt-4 text-xl text-semibold">Stock :<span className="ml-3">{props.wine.stock} uns</span></p>
                <p className="mt-8 text-xl text-semibold">Rating <span className="text-sm font-normal">({props.wine.numRatings} rates)</span> :</p>
                <div className="flex mt-1 text-yellow-500 text-lg items-center">
                    {stars}
                <p className="ml-4 text-white">{props.wine.ratingScore}</p>
                </div>
            </div>
            <div className="flex flex-col justify-between ml-20 mt-14">
                <div>
                    <p className="text-3xl font-bold">{props.wine.name} <span className="font-normal">,</span> <span className="font-normal ml-4"> 0.75 L</span></p>
                    <p className="mt-2 text-base text-semibold">From <span className="ml-2">{props.wine.winery}</span></p>
                    <p className="mt-8 text-xl text-semibold">Alcoholic Volume:<span className="ml-2">{props.wine.alcoholicVolume}%</span></p>
                    <p className="mt-2 text-xl text-semibold">Type:<span className="ml-2">{props.wine.type}</span></p>
                    <p className="mt-2 text-xl text-semibold">Grapes:<span className="ml-2">{props.wine.grapeVariety}</span></p>
                    <p className="mt-2 text-xl text-semibold">Country:<span className="ml-2">{props.wine.country}</span></p>
                    <p className="mt-2 text-xl text-semibold">Region:<span className="ml-2">{props.wine.region}</span></p>
                    <p className="mt-8 text-xl text-semibold">Description:</p>
                    <p className="mt-2 text-lg text-justify">{props.wine.description}</p>
                </div>

                <div className="place-self-end">
                    <button className="text-primary-shade-4 border-2 border-primary-shade-4 rounded-full aspect-square w-[40px] hover:bg-primary-shade-4 hover:text-white active:scale-95" onClick={()=>quantity>1 && setQuantity(quantity-1)}>-</button>
                    <button className="bg-primary-shade-4 rounded-lg p-3 text-white mx-2 active:scale-95" onClick={()=>addItemToCart(props.wine)}>Add {quantity} to Cart</button>
                    <button className="text-primary-shade-4 border-2 border-primary-shade-4 rounded-full aspect-square w-[40px] hover:bg-primary-shade-4 hover:text-white active:scale-95" onClick={()=>setQuantity(quantity+1)}>+</button>
                </div>
                {itemAdded && <div id="addedToCart" className={`bg-primary/20 p-4 absolute bottom-4 left-1/2 -translate-x-1/2 rounded-xl ${animation}`}>
                    <p className="">Item added to cart!</p>
                </div>}

            </div>


        </div>
    )
}

export default WineCard