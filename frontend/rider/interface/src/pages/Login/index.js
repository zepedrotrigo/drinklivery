import React, { useState } from 'react';
import axios from 'axios';
import { useDispatch } from 'react-redux';
import sha256 from 'crypto-js/sha256';


import { signIn, setUserInfo } from '../../redux/actions';

const Login = () => {

  const [notFoundError, setNotFoundError] = useState(false);
  const [loginError, setLoginError] = useState(false);

  const dispatch = useDispatch();

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
    axios.post("/riders/login", user, options)
        .then(results => {
            if (results.status === 202) {
                dispatch(signIn());
                dispatch(setUserInfo(results.data));
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

const clearErrors = () => {
  setLoginError(false);
  setNotFoundError(false);
}

  return (
    <div className="flex flex-col items-center mt-24">
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
                        <button className="bg-primary-shade-1 text-white py-2 self-center rounded-full px-8 active:scale-95" onClick={loginUser}>Login</button>
                    </div>
                </div>
            </div>
  )
}

export default Login