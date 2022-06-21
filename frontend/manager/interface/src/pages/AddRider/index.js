import React, { useState } from 'react';
import axios from 'axios';
import sha256 from 'crypto-js/sha256';

const AddRider = () => {
    const [fnError, setFnError] = useState(false);
    const [lnError, setLnError] = useState(false);
    const [ageError, setAgeError] = useState(false);
    const [addressError, setAddressError] = useState(false);
    const [phoneError, setPhoneError] = useState(false);
    const [nifError, setNifError] = useState(false);
    const [plateError, setPlateError] = useState(false);
    const [vehicleTypeError, setVehicleTypeError] = useState(false);
    const [emailError, setEmailError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [confirmError, setConfirmError] = useState(false);


    const verifyRegisterFields = () => {
        const alfa = /[a-zA-Z]/;


        if (document.getElementById("registerFirstName").value.length === 0) {
            setFnError(true);
            return false;
        }

        if (document.getElementById("registerLastName").value.length === 0) {
            setLnError(true);
            return false;
        }

        if (Number.parseInt(document.getElementById("registerAge").value) < 18) {
            setAgeError(true);
            return false;
        }

        if (document.getElementById("registerAddress").value.length === 0) {
            setAddressError(true);
            return false;
        }

        if (document.getElementById("registerVehicleType").value.length === 0) {
            setVehicleTypeError(true);
            return false;
        }

        if (document.getElementById("registerPlate").value.length !== 8) {
            setPlateError(true);
            return false;
        }

        if (document.getElementById("registerNIF").value.length !== 9 || alfa.test(document.getElementById("registerNIF").value)) {
            setNifError(true);
            return false;
        }

        if (document.getElementById("registerPhone").value.length < 9 || alfa.test(document.getElementById("registerPhone").value)) {
            setPhoneError(true);
            return false;
        }


        if (!(document.getElementById("registerEmail").value.split("@")[0].length > 1 && document.getElementById("registerEmail").value.split("@")[1].length > 1
            && document.getElementById("registerEmail").value.split("@")[1].includes("."))) {
            setEmailError(true);
            return false;
        }
        if (document.getElementById("registerPassword").value.length < 6) {
            setPasswordError(true);
            return false;
        }
        if (document.getElementById("registerPassword").value !== document.getElementById("registerConfirmPassword").value) {
            setConfirmError(true);
            return false;
        }
        return true;
    }

    const clearErrors = () => {
        setFnError(false);
        setLnError(false);
        setEmailError(false);
        setPasswordError(false);
        setConfirmError(false);
        setVehicleTypeError(false);
        setPlateError(false);
        setAgeError(false);
        setAddressError(false);
        setPhoneError(false);
        setNifError(false);
    }

    const registerUser = () => {
        clearErrors();

        if (verifyRegisterFields()) {
            const user = {
                firstName: document.getElementById("registerFirstName").value,
                lastName: document.getElementById("registerLastName").value,
                phone: document.getElementById("registerPhone").value,
                address: document.getElementById("registerAddress").value,
                vehicleType: document.getElementById("registerVehicleType").value,
                licensePlate: document.getElementById("registerPlate").value,
                age: Number.parseInt(document.getElementById("registerAge").value),
                nif: Number.parseInt(document.getElementById("registerNIF").value),
                email: document.getElementById("registerEmail").value,
                password: sha256(document.getElementById("registerPassword").value).toString(),
            }
            console.log(user, document.getElementById("registerPassword").value);

            const options = {
                headers: {
                    'content-type': 'application/json'
                }
            }


            axios.post(`/riders/register`, user, options)
                .then(response => {
                    console.log(response);
                })
                .catch(err => {
                    console.log(err)
                })
        }
    }


    return (
        <div className="container-4/5 mt-16 flex-col flex">
            <p className="text-3xl font-medium underline underline-offset-1 text-center">Add a new Rider.</p>

            <div className="flex flex-col bg-slate-50 pt-10 pb-8 px-24 mt-16 rounded-lg items-center w-min self-center shadow-md">

                <div className="relative mt-5" >
                    <input placeholder=" " id={"registerFirstName"} type={"text"} className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor={"registerFirstName"} className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">First Name</label>
                </div>
                {fnError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}

                <div className="relative mt-10" >
                    <input placeholder=" " id="registerLastName" type="text" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerLastName" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Last Name</label>
                </div>
                {lnError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerAge" type="number" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerAge" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Age</label>
                </div>
                {ageError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerEmail" type="email" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerEmail" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Email</label>
                </div>
                {emailError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerPhone" type="tel" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerPhone" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Phone</label>
                </div>
                {phoneError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerNIF" type="text" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerNIF" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">NIF</label>
                </div>
                {nifError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerAddress" type="text" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerAddress" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Address</label>
                </div>
                {addressError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerVehicleType" type="text" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerVehicleType" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Vehicle Type</label>
                </div>
                {vehicleTypeError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerPlate" type="text" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerPlate" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Plate</label>
                </div>
                {plateError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerPassword" type="password" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerPassword" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Password</label>
                </div>
                {passwordError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}


                <div className="relative mt-10" >
                    <input placeholder=" " id="registerConfirmPassword" type="password" className=" rounded-full py-2 px-4 bg-gray-200 peer focus:outline-none shadow-sm"></input>
                    <label htmlFor="registerConfirmPassword" className="capitalize absolute left-0 top-0 peer-placeholder-shown:translate-y-2 peer-placeholder-shown:translate-x-5 peer-placeholder-shown:scale-100 peer-focus:translate-x-1 peer-focus:-translate-y-6 translate-x-1 -translate-y-6 scale-90 transform duration-[150ms] peer-focus:scale-90 ease-linear">Confirm Password</label>
                </div>
                {confirmError && <p className=" text-xs self-start ml-4 mt-1 text-red-700">* Please enter a valid first name!</p>}

                <button className="rounded-full bg-black text-white py-2 px-4 mt-8 active:scale-95 transform ease-linear" onClick={registerUser}>Add Rider</button>
            </div>

        </div>
    )
}

export default AddRider