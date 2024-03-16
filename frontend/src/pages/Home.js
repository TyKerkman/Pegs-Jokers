import React, {useEffect} from 'react'
import {Outlet, Link, useNavigate} from 'react-router-dom'
import '../Styling.css';
import { onAuthStateChanged, signOut} from "firebase/auth";
import { auth } from '../firebase';

function Home() {
    const navigate = useNavigate();
 
    const handleLogout = () => {               
        signOut(auth).then(() => {
        // Sign-out successful.
            navigate("/");
            console.log("Signed out successfully")
        }).catch((error) => {
        // An error happened.
        });
    }

    useEffect(()=>{
        onAuthStateChanged(auth, (user) => {
            if (user) {
              // User is signed in, see docs for a list of available properties
              // https://firebase.google.com/docs/reference/js/firebase.User
              const uid = user.uid;
              // ...
              console.log("uid", uid)
            } else {
              // User is signed out
              // ...
              console.log("user is logged out")
            }
          });
         
    }, [])

    return (
        <div className='home-page'>     
            <h1>Pegs and Jokers</h1>
            <Link to='/'>Landing</Link>
            <button onClick={handleLogout}>
                Logout
            </button>
        </div>
    )
}

export default Home
