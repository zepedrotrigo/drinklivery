import React from 'react'
import { Link, NavLink } from 'react-router-dom'
import { useSelector } from 'react-redux'

import Logo from '../Logo'

const NavBar = () => {

    const isLogged = useSelector(state => state.isLogged)

    const active = 'underline underline-offset-2 text-primary text-lg'
    const link = 'hover:underline hover:text-slate-600 underline-offset-2 cursor-pointer text-lg'
    return (
        <div className="pl-[10%] pr-[10%] w-[100%] h-min pb-2 pt-4 flex items-center">
            <div className="w-1/2">
                <div className="w-min">
                <Link to="/">
                    <Logo />
                </Link>

                </div>
            </div>
            <div className="w-1/2 flex justify-between items-center">
                <NavLink to="/" className={({ isActive }) => { return (isActive ? active : link) }}>
                    Home
                </NavLink>
                <NavLink id="winesBtn" to="/wines" className={({ isActive }) => { return (isActive ? active : link) }}>
                    Wines
                </NavLink>
                {!isLogged ? 
                <NavLink id="enterBtn" to="/enter" className="border-2 py-2 px-4 rounded-lg hover:bg-white hover:text-dark">Enter</NavLink>
                :
                <NavLink id="profileBtn" to="/profile" className={({ isActive }) => { return (isActive ? active : link) }}>
                    Your Profile
                </NavLink>}

            </div>
        </div>
    )
}

export default NavBar