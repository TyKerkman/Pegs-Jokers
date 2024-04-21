import React from 'react'
import {Outlet, Link, useNavigate} from 'react-router-dom'
import "../Styling.css"
import { auth } from '../firebase';
import { getAuth, onAuthStateChanged } from "firebase/auth";


function Reset() {

    return (
        <div className='reset-page'>
            <div className='reset-text'>
                Password Reset Request Sent!
            </div>
            <p style={{ color: 'white' }}>
                Check Your Email For Confirmation
            </p>
            <Link className="button-2" to="/login">Login</Link>
        </div>
    )
}

export default Reset
