import React from 'react'
import {Outlet, Link} from 'react-router-dom'
import '../Styling.css'

function Profile() {
    return (
        <div className="profile-page">
            <h1>Profile</h1>
            <Link to='/'>Home</Link>
        </div>
    )
}

export default Profile
