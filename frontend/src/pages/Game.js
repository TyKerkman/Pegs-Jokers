import React, {useState} from 'react'
import {Outlet, Link} from 'react-router-dom'
import Board from '../components/Board'
import NavBar from '../components/NavBar'
import holesData from '../exampleBoard.json';
import '../Styling.css'
import KnownCard from '../components/KnownCard';


function Game() {

    return (
        <div className='game-page'>
        <NavBar title = "Pegs & Jokers"/>
            <div className='board-container'>
                <div className='leftBar'>
                    <div className='card-container'>
                        <KnownCard card={'2C'} />
                        <KnownCard card={'7H'}/>  
                        <KnownCard card={'JD'}/>                    
                        <KnownCard card={'AS'}/>                    
                        <KnownCard card={'BJ'}/>                    
                    </div>
                    <div className='playerContainer'>
                        <button className="button-2">Move</button>
                        Hypothetical Players Turn or Other Info Btw the button don't work
                    </div>
                </div>
                <div className='game-body'>
                    {/* <Board /> */}
                    <Board />
                </div>
                <div className='rightBar'>
                    <div className='rightPlaceholder'>
                        Please keep these placeholders here
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Game
