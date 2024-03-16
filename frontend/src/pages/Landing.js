import React from 'react'
import {Outlet, Link, useNavigate} from 'react-router-dom'
import "../Styling.css"
import { auth } from '../firebase';
import { getAuth, onAuthStateChanged } from "firebase/auth";


function Landing() {
    var user = auth.currentUser;
    console.log(user)



    return (
        <div className="landing-page">
            <h1>Pegs and Jokers</h1>
            {
                user == null ? <Link to='/login'>Login</Link> : <Link to='/home'>Login</Link>
            }
            <Link to='/signup'>Sign Up</Link>
        </div>
    )
}

export default Landing
