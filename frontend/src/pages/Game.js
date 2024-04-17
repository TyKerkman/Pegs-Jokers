import React, {useState} from 'react'
import {Outlet, Link} from 'react-router-dom'
import Board from '../components/Board'
import NavBar from '../components/NavBar'
import Board2 from '../components/Board2'
import '../Styling.css'

function Game() {

    return (
        <div className='game-page'>
            <NavBar title = "Pegs & Jokers"/>
            <div className='game-container'>

                <div className='game-body'>
                    {/* <Board /> */}
                <Board />
                </div>
                <div className='game-sidebar'>

                </div>
            </div>
        </div>
    )
}

export default Game
