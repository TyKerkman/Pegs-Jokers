import React, {useState} from 'react'
import {Outlet, Link} from 'react-router-dom'
import Board from '../components/Board'
import '../Styling.css'

function Game() {

    return (
        <div className='game-page'>
            <div className='game-header'>
                <Link className='login-button' to='/'>Home</Link>
            </div>
            <div className='game-body'>
                <Board />
            </div>
        </div>
    )
}

export default Game
