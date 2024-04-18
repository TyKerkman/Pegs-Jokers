import React from 'react'
import {Outlet, Link} from 'react-router-dom'
import '../Styling.css'

function Profile() {
    return (
        <div className="profile-page">
            <h1 className='text-white'>Profile</h1>
            <Link className="button-2" to='/home'>Home</Link>
        </div>
    )
}

export default Profile
