import React, { useState } from 'react';
import sha256 from 'crypto-js/sha256';
import axios from 'axios';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';

import { signIn, setUserInfo } from '../../redux/actions'

const Enter = () => {
    const [fnError, setFnError] = useState(false);
    const [lnError, setLnError] = useState(false);
    const [ageError, setAgeError] = useState(false);
    const [addressError, setAddressError] = useState(false);
    const [phoneError, setPhoneError] = useState(false);
    const [nifError, setNifError] = useState(false);
    const [emailError, setEmailError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [confirmError, setConfirmError] = useState(false);
    const [loginError, setLoginError] = useState(false);
    const [notFoundError, setNotFoundError] = useState(false);
    const [userCreated, setUserCreated] = useState(false);

    const dispatch = useDispatch();
    const navigate = useNavigate();


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
        setAgeError(false);
        setAddressError(false);
        setPhoneError(false);
        setNifError(false);
        setLoginError(false);
        setNotFoundError(false);
    }

    const registerUser = () => {
        clearErrors();

        if (verifyRegisterFields()) {
            const user = {
                firstName: document.getElementById("registerFirstName").value,
                lastName: document.getElementById("registerLastName").value,
                phone: document.getElementById("registerPhone").value,
                address: document.getElementById("registerAddress").value,
                age: Number.parseInt(document.getElementById("registerAge").value),
                nif: Number.parseInt(document.getElementById("registerNIF").value),
                email: document.getElementById("registerEmail").value,
                password: sha256(document.getElementById("registerPassword").value).toString()
            }
            const options = {
                headers: {
                    'content-type': 'application/json'
                }
            }


            axios.post(`/users/register`, user, options)
                .then(response => {
                    console.log(response);
                    setUserCreated(true);
                })
                .catch(err => {
                    console.log(err);
                    alert("Something went wrong!");
                })
        }

    }

    const loginUser = () => {

        if (document.getElementById("loginEmail").value.length === 0) {
            return;
        }

        if (document.getElementById("loginPassword").value.length === 0) {
            return;
        }

        clearErrors();

        const user = {
            email: document.getElementById("loginEmail").value,
            password: sha256(document.getElementById("loginPassword").value).toString(),
        }

        const options = {
            headers: {
                'content-type': 'application/json'
            }
        }
        axios.post("/users/login", user, options)
            .then(results => {
                if (results.status === 202) {
                    dispatch(signIn());
                    dispatch(setUserInfo(results.data));
                    navigate("/");
                }

            })
            .catch(err => {
                console.log(err)
                if (err.response.status === 403) {
                    setLoginError(true);
                } else if (err.response.status === 404) {
                    setNotFoundError(true);
                }
            })
    }






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
                    {notFoundError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* User not found!</p>}
                    {loginError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Invalid credentials!</p>}
                    <div className="flex justify-around mt-16">
                        <button id="loginBtn" className="bg-primary-shade-1 text-white py-2 self-center rounded-full px-8 active:scale-95" onClick={loginUser}>Login</button>


                    </div>
                </div>
            </div>

            <div className=" mx-auto w-1 bg-primary-shade-6"></div>

            <div className="flex flex-col items-center mr-24">
                <p className="text-4xl font-bold">Still don't have an account?</p>
                <p className="text-4xl font-bold mt-4">Then Sign Up!!</p>
                <div className="flex flex-col mt-16">

                    <div className="flex flex-col gap-2">
                        <label htmlFor="registerFirstName" className="ml-4">First Name</label>
                        <input id="registerFirstName" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="email"></input>
                        {fnError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Please enter a valid first name</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerLastName" className="ml-4">Last Name</label>
                        <input id="registerLastName" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="email"></input>
                        {lnError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Please enter a valid last name</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerAge" className="ml-4">Age</label>
                        <input id="registerAge" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="number" min="18" max="120"></input>
                        {ageError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Age must be over 18</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerEmail " className="ml-4">Email</label>
                        <input id="registerEmail" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="email"></input>
                        {emailError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Please enter a valid email</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerPhone" className="ml-4">Phone</label>
                        <input id="registerPhone" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="tel" pattern="[0-9]{9}"></input>
                        {phoneError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Please enter a valid phone number</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerAddress" className="ml-4">Address</label>
                        <input id="registerAddress" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="text"></input>
                        {addressError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Please enter a valid address</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerNIF" className="ml-4">NIF</label>
                        <input id="registerNIF" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="text"></input>
                        {nifError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Please enter a valid NIF</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerPassword" className="ml-4">Password</label>
                        <input id="registerPassword" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="password"></input>
                        {passwordError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Password must have at least 6 characters</p>}
                    </div>

                    <div className="flex flex-col gap-2 mt-10">
                        <label htmlFor="registerConfirmPassword" className="ml-4">Confirm Password</label>
                        <input id="registerConfirmPassword" className="bg-primary-tint-11 focus:bg-primary-tint-10 py-2 px-3 rounded-full border-[1px] border-primary-tint-9 transition duration-100 ease-linear outline-primary-tint-8" type="password"></input>
                        {confirmError && <p className="text-xs pl-4 py-1 text-primary-tint-6">* Passwords must be the same</p>}
                    </div>

                    
                    <div className="flex justify-around mt-16">
                        <button id="registerBtn" className="bg-primary-shade-1 text-white py-2 self-center rounded-full px-8 active:scale-95" onClick={registerUser}>Register</button>
                    </div>
                    {!userCreated && <p id="userCreatedSuccess" className="text-center py-1 text-green-700 mt-8">User Created Successfully</p>}
                </div>
            </div>
        </div>
    )
}

export default Enter