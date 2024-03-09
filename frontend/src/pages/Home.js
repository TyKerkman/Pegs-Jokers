import React from 'react'
import {Outlet, Link} from 'react-router-dom'
import '../Styling.css';

function Home() {
    return (
        <div className='home-page'> 
            <h1>Pegs and Jokers</h1>
            <Link to='/profile'>Profile</Link>
            <Link to='/game'>Game</Link>
            <Outlet />
        </div>
    )
}

export default Home
