import React from 'react'
import {Outlet, Link} from 'react-router-dom'

function Profile() {
    return (
        <>
            <h1>Profile</h1>
            <Link to='/'>Home</Link>
        </>
    )
}

export default Profile
