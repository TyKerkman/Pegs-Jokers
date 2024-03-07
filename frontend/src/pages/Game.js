import React, {useState} from 'react'
import {Outlet, Link} from 'react-router-dom'
import Piece from '../components/Piece'
import Board from '../components/Board'

function Game() {



    return (
        <div style={{display: 'flex', flexDirection: 'column',justifyContent: 'center', alignItems: 'center'}}>
            <h1>Game</h1>
            <Link to='/'>Home</Link>
                <div style={{background: 'green', height: '500px'}}>
                    <Board />
                </div>
            

        </div>
    )
}

export default Game
