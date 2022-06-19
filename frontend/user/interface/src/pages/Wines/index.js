import React, { useState, useEffect } from 'react'
import axios from 'axios';
import WineCard from '../../components/WineCard';

const Wines = () => {

    const [wines, setWines] = useState([]);
    const [checkedWine, setCheckedWine] = useState({});
    const [fetched, setFetched] = useState(false);
    const [modalOpen, setModalOpen] = useState(false);
    

    useEffect(() => {
        !fetched && axios.get('/allproducts')
            .then(response => {
                console.log(response);
                setWines(response.data);
                setFetched(true);
            })
            .catch(err => {
                console.log(err);
            })
    })

    const openModal = (wine)=>{
        setCheckedWine(wine);
        setModalOpen(true);
    }



    return (
        <div className="container-4/5 mt-16 mb-8">

            <div className="">
                <p className="ml-16 text-4xl font-bold underline underline-offset-2">Our wines</p>
            </div>

            <div className="mt-16">
                <p className="text-2xl font-medium"></p>
                <div className="mt-8 grid grid-cols-4 gap-x-8 gap-y-8">
                    {wines.map((wine, index) => {
                        return (
                            <div key={index} className="shadow shadow-primary-tint-11 py-5 px-8 flex flex-col rounded-xl ">
                                <img className="w-[200px] h-[200px] self-center rounded-xl" src={wine.image === undefined ? "https://picsum.photos/200" : wine.image} alt="" ></img>
                                <p className="mt-4 text-xl self-center font-semibold">{wine.name} [{wine.type}]</p>
                                <p className="mt-3"><span className="font-semibold mr-2">Volume: </span>{wine.volume} L</p>
                                <p className="mt-1"><span className="font-semibold mr-2">Alcohol/Volume: </span>{wine.alcoholicVolume}%</p>
                                <p className="mt-1"><span className="font-semibold mr-2">Price: </span>{wine.buyPrice}€</p>
                                <p className="mt-1"><span className="font-semibold mr-2">Quantity: </span>{wine.stock} un</p>
                                <button onClick={() => openModal(wine)} className="bg-primary-shade-4 py-2 px-4 text-white self-center mt-4 rounded-xl active:scale-95">View Details</button>
                            </div>
                        )

                    })}
                </div>
            </div>
            {modalOpen && <div className="fixed left-0 top-0 flex justify-center items-center bg-white/30 w-full h-full fade-in">
                <WineCard wine={checkedWine} closeModal={()=> {setModalOpen(false); }}></WineCard>
            </div>}

        </div>
    )
}

export default Wines