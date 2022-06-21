import React from 'react'
import { Link, NavLink } from 'react-router-dom'

const NavBar = () => {

    const active = 'underline underline-offset-2 text-gray-700 mr-16'
    const link = 'hover:underline hover:text-slate-600 underline-offset-2 cursor-pointer mr-16'

    return (
        <div className="bg-white shadow h-16 pl-8 flex items-center">
            <div className="w-2/5">
                <Link to="/">
                    <p className="text-2xl font-semibold cursor-pointer cursor">Management</p>
                </Link>
            </div>
                <NavLink to="/" className={({ isActive }) => { return (isActive ? active : link) }}>
                    Riders List
                </NavLink>
                <NavLink to="/add-rider" className={({ isActive }) => { return (isActive ? active : link) }}>
                    Add Rider
                </NavLink>
        </div>
    )
}

export default NavBar