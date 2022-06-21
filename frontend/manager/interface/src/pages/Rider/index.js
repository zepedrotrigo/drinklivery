import React, {useEffect, useState} from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios';

// import riders from '../Riders/sample'

const Rider = () => {
    const params = useParams();

    const [rider, setRider] = useState({});

    useEffect(() =>{
            axios.get(`/riders/${params.riderId}`)
            .then(response =>{
                setRider(response.data);
            })
    }, [rider, params.riderId])

    const free = rider.occupied ?

    <p className="mr-16">Delivering</p>

    : <p>Free</p>


    return (
        <div className="container-4/5 mt-16 mb-8">
            <p className="text-2xl font-medium ml-16 capitalize">{rider.firstName} {rider.lastName}, {rider.age}</p>
            <div className=" container-4/5 shadow-md bg-slate-50 flex flex-col py-4 px-8 rounded-lg mt-8">
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Internal Number</p>
                    <p>{rider.id}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Plate</p>
                    <p>{rider.licensePlate}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Email</p>
                    <p>{rider.email}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Phone</p>
                    <p>{rider.phone}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Address</p>
                    <p>{rider.address}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">NIF</p>
                    <p>{rider.nif}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Current Status</p>
                    {rider.active ?

                        <div className="flex items-center">
                            {free}
                        </div>
                        : <p>Not active</p>}

                </div>
                {rider.delivering &&
                    <div className="flex my-4 items-center">
                        <p className="w-1/4 text-xl underline underline-offset-1">Service: </p>
                        <p className="">{rider.service}</p>
                    </div>
                }
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Number of Deliveries</p>
                    <p>{rider.numDeliveries}</p>
                </div>
            </div>
        </div>

    )
}

export default Rider