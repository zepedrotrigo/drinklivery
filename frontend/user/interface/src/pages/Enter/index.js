import React from 'react'

const Enter = () => {
    return (
        <div className="container-4/5 mt-16 mb-8 flex relative">
            <div className="flex flex-col items-center ml-24">
                <p className="text-4xl font-bold">Do you have an account?</p>
                <p className="text-4xl font-bold mt-4">Sign In!</p>
                <div className="flex flex-col mt-16">
                    <div className="flex flex-col gap-2">
                        <label htmlFor="loginEmail" className="ml-4">Email</label>
                        <input id="loginEmail" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="email"></input>
                    </div>
                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="loginPassword" className="ml-4">Password</label>
                        <input id="loginPassword" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="password"></input>
                    </div>
                    <div className="flex justify-around mt-16">
                        <button className="bg-primary-shade-1 text-white py-2 self-center rounded-full px-8">Login</button>


                    </div>
                </div>
            </div>

            <div className=" mx-auto w-1 bg-primary-shade-6"></div>

            <div className="flex flex-col items-center mr-24">
                <p className="text-4xl font-bold">Still don't have an account?</p>
                <p className="text-4xl font-bold mt-4">Then Sign Up!!</p>
                <div className="flex flex-col mt-16">
                <div className="flex flex-col gap-2">
                        <label htmlFor="registerName" className="ml-4">Name</label>
                        <input id="registerName" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="email"></input>
                    </div>
                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerEmail " className="ml-4">Email</label>
                        <input id="registerEmail" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="email"></input>
                    </div>
                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerPassword" className="ml-4">Password</label>
                        <input id="registerPassword" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="password"></input>
                    </div>
                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerConfirmPassword" className="ml-4">Confirm Password</label>
                        <input id="registerConfirmPassword" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="password"></input>
                    </div>
                    <div className="flex justify-around mt-16">
                        <button className="bg-primary-shade-1 text-white py-2 self-center rounded-full px-8">Register</button>


                    </div>
                </div>
            </div>
        </div>
    )
}

export default Enter