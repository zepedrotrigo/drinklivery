import React, {useEffect, useState} from 'react'
import {useNavigate, Outlet} from 'react-router-dom'
import axios from 'axios';

// import riders from './sample'

const Riders = () => {
    const [fetched, setFetched] = useState(false);
    const [riders, setRiders] = useState([]);

    useEffect(() =>{
        if(!fetched){
            axios.get("/riders")
            .then(response =>{
                setRiders(response.data);
                setFetched(true);
            })
        }
    })

    const navigate = useNavigate();


  return (
    <div className="container-4/5 mt-16">
            <p className="text-3xl font-medium underline underline-offset-1">These are our Riders.</p>
            <div className="bg-slate-50 py-4 px-8 mt-8 border-2 rounded-lg shadow-md">
                <p className="text-2xl font-medium ml-4 mt-2">Riders list</p>
                <div className="container-4/5 mt-8 flex flex-col">
                    <div className="grid grid-cols-5 gap-y-4 border-b-4 pb-2">
                    <p className="font-medium text-lg pl-2">Email</p>
                    <p className="font-medium text-lg pl-2">Name</p>
                    <p className="font-medium text-lg pl-2">Vehicle</p>
                    <p className="font-medium text-lg pl-2">Plate</p>
                    <p className="font-medium text-lg text-center">Rate</p>

                    </div>
                    {
                        riders.map((r, i) => {
                            const percentage = Math.round(r.rating / 5 * 100);
                            var bg = 'bg-red-500';
                            if((40< percentage && percentage<50 )|| percentage ===40) {bg='bg-red-300';}
                            else if((50< percentage && percentage<70 )|| percentage ===50) {bg='bg-green-300'; }
                            else if((70< percentage && percentage<101 )|| percentage ===70) {bg='bg-green-500';}

                            return (
                                <div key={i} onClick={()=> {navigate(`/rider/${r.id}`)}} className="grid grid-cols-5 pt-4 pb-2 border-b-2 last:border-b-slate-50 hover:border-b-2 hover:border-gray-500 cursor-pointer hover:bg-white hover:translate-x-1 transition duration-100 ease-linear">
                                    <p className="pl-2">{r.email}</p>
                                    <p className="pl-2 capitalize">{`${r.firstName} ${r.lastName}`}</p>
                                    <p className="pl-2">{r.vehicleType}</p>
                                    <p className="pl-2">{r.licensePlate}</p>
                                    <div className="w-full flex">
                                        <div className="w-[80%] h-full bg-gray-200 rounded-full">
                                            <div className={` ${bg} h-full rounded-full flex justify-end`} style={{ width: `${percentage}%` }}></div>
                                        </div>
                                        <p className="w-[20%] text-right">{r.rating}</p>
                                    </div>
                                </div>
                            )
                        })
                    }
                </div>
            </div>
            <Outlet></Outlet>
        </div>
  )
}

export default Riders