import React from 'react'

const AddRider = () => {
    const inputs = ["name", "email", "password", "password confirmation", "vehicle type", "plate"]
    return (
        <div className="container-4/5 mt-16 flex-col flex">
            <p className="text-3xl font-medium underline underline-offset-1 text-center">Add a new Rider.</p>

            <div className="flex flex-col bg-slate-50 pt-10 pb-8 px-24 mt-16 rounded-lg items-center w-min self-center shadow-md">
                {
                    inputs.map((input, i) => (
                        <div className="relative my-5">
                            <input placeholder=" " id={input} className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                            <label htmlFor={input} className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">{input}</label>
                        </div>
                    ))
                }
                <button className="rounded-full bg-black text-white py-2 px-4 mt-8 active:scale-95 transform ease-linear">Add Rider</button>
            </div>

        </div>
    )
}

export default AddRider