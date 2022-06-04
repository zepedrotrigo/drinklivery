import React, { useState } from 'react'
import { IoAtOutline, IoCardOutline, IoHomeOutline } from 'react-icons/io5'
import { Outlet, useNavigate } from 'react-router-dom'

import { person, cart as cartSample } from './sample.js'

const Profile = () => {

    const [cart, setCart] = useState(cartSample)
    let totalPrice = 0

    const navigate = useNavigate();

    return (
        <div className="container-4/5 mt-16 mb-8">

            <div className=" flex justify-between">
                <div className="flex items-start">
                    <div className=" py-8 px-16 rounded-xl flex flex-col drop-shadow-xl border-r-2 border-b-[1px]">
                        <p className="text-3xl text-center font-medium">{person.name}</p>
                        <img className="mt-10 border-4 border-primary-shade-6 rounded-full h-[300px] aspect-square justify-self-center" src={person.image} alt=""></img>
                        <div className="flex items-center mt-10">
                            <IoAtOutline className="text-xl"></IoAtOutline>
                            <p className="ml-8 text-xl font-medium border-b-2 border-b-primary-shade-6 flex-1">{person.email}</p>
                        </div>
                        <div className="flex items-center mt-8">
                            <IoCardOutline className="text-xl"></IoCardOutline>
                            <p className="ml-8 text-xl font-medium border-b-2 border-b-primary-shade-6 flex-1">{person.card}</p>
                        </div>
                        <div className="flex items-center mt-8">
                            <IoHomeOutline className="text-xl"></IoHomeOutline>
                            <p className="ml-8 text-xl font-medium border-b-2 border-b-primary-shade-6 flex-1">{person.address}</p>
                        </div>
                    </div>
                </div>
                <div>
                    <div className="border-b-[1px] border-l-2 py-8 px-16 rounded-xl flex flex-col">
                        <p className="text-4xl font-medium">Cart</p>
                        <div className="grid grid-cols-3 gap-8 mt-10">
                            {cart.map((item, index) => {
                                totalPrice += item.priceUn * item.unities;
                                return (
                                    <div key={index} className="bg-primary/20 py-4 px-8 rounded-lg flex flex-col">
                                        <img className="rounded-full w-[100px] h-[100px] self-center" alt="" src={item.image}></img>
                                        <p className="mt-4 text-xl font-semibold">{item.name}</p>
                                        <p className="mt-1"><span className="font-semibold mr-2">Price: </span>{item.priceUn * item.unities}€</p>
                                        <div className="flex items-center mt-3 justify-between">
                                            <button className="bg-primary-shade-3 aspect-square w-8 h-8 text-white rounded-full mr-3">-</button>
                                            <p className="">{item.unities}</p>
                                            <button className="bg-primary-shade-3 aspect-square w-8 h-8 text-white rounded-full ml-3">+</button>
                                        </div>
                                    </div>
                                )
                            })}
                        </div>
                        <div className="flex mt-10 justify-end">
                            <p className="text-lg"><span className="font-bold mr-4">Total Price:</span>{totalPrice}€</p>
                        </div>

                        <button onClick={()=>navigate("checkout")} className="bg-primary-shade-6 px-4 py-2 self-end text-white rounded-lg mt-4">Checkout</button>
                    </div>
                    <Outlet></Outlet>


                </div>


            </div>



        </div>
    )
}

export default Profile