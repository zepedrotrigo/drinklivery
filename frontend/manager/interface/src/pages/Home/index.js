import React from 'react'

import riders from './sample'

const Home = () => {
    return (
        <div className="container-4/5 mt-16">
            <p className="text-3xl font-medium underline underline-offset-1">Welcome to the Management department.</p>
            <div className="bg-slate-50 py-4 px-8 mt-8 border-2 rounded-lg shadow-md">
                <p className="text-2xl font-medium ml-4 mt-2">Riders list</p>
                <div className="container-4/5 mt-8 grid grid-cols-5 gap-y-4">
                    <p className="font-medium text-lg">Email</p>
                    <p className="font-medium text-lg">Name</p>
                    <p className="font-medium text-lg">Vehicle</p>
                    <p className="font-medium text-lg">Plate</p>
                    <p className="font-medium text-lg text-center">Rate</p>
                    {
                        riders.map((r, i) => {
                            const percentage = Math.round(r.rating / 5 * 100);
                            const bg = percentage > 50 ? 'bg-green-300' : 'bg-red-300';
                            return (
                                <>
                                    <p>{r.email}</p>
                                    <p>{r.name}</p>
                                    <p>{r.vehicleType}</p>
                                    <p>{r.plate}</p>
                                    <div className="w-full flex">
                                        <div className="w-[80%] h-full bg-gray-200 rounded-full">
                                            <div className={`${bg} h-full rounded-full flex justify-end`} style={{ width: `${percentage}%` }}></div>
                                        </div>
                                        <p className="w-[20%] text-right">{r.rating}</p>
                                    </div>
                                </>
                            )
                        })
                    }
                </div>
            </div>
        </div>
    )
}

export default Home