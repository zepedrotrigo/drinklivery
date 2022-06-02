import React from 'react'
import { useParams } from 'react-router-dom'

import riders from '../Riders/sample'

const Rider = () => {
    const params = useParams();
    const rider = riders[params.riderId - 1]
    return (
        <div className="container-4/5 mt-16 mb-8">
            <p className="text-2xl font-medium ml-16">{rider.name}</p>
            <div className=" container-4/5 shadow-md bg-slate-50 flex flex-col py-4 px-8 rounded-lg mt-8">
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Internal Number</p>
                    <p>{rider.id}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Plate</p>
                    <p>{rider.plate}</p>
                </div>
                <div className="flex my-4 items-center">
                    <p className="w-1/4 text-xl underline underline-offset-1">Current Status</p>
                    {rider.active ?

                        <div className="flex items-center">
                            {rider.delivering ?

                                <p className="mr-16">Delivering</p>

                                : <p>Free</p>}
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
                    <p>{rider.numberOfDeliveries}</p>
                </div>
            </div>
        </div>

    )
}

export default Rider