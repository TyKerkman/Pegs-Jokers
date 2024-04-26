import React, { useEffect, useState } from 'react'
import '../Styling.css'
import { Turn } from './Turn'

export function SideBar({pegs, card, is_split_move, setPegs, setCard}) {

    return (
        <div className='turn-bar'>
            <h1 className='turn-header'>Play a Turn!</h1>
            {pegs.map((peg, index) => (
                <div key={index} className='peg'>
                    Peg {index+1}: {peg.color} {peg.num}
                </div>
            ))}
            <p className='card'>VALUE</p>
            <div onClick={handleConfirmTurn} className='confirm-turn'>Confirm Turn</div>
        </div>
    )

    function handleConfirmTurn(){
        const turn = !pegs[1] ? {
            "card": {
              "value": card.value
            },
            "p": {
              "color": pegs[0].color,
              "num": pegs[0].num
            },
            "gameID": 1
          } : !is_split_move ?
          {
            "card": {
                "value": card.value
            },
            "p": {
                "color": pegs[0].color,
                "num": pegs[0].num
            },
            "p2": {
                "color": pegs[1].color,
                "num": pegs[1].num
              },
            "gameID": 1
          } :
          {
            "card": {
                "value": card.value
            },
            "p": {
                "color": pegs[0].color,
                "num": pegs[0].num
            },
            "p2": {
                "color": pegs[1].color,
                "num": pegs[1].num
              },
            "gameID": 1,
            "spaces": 5
          };
        
        console.log(turn);
        Turn(turn);
        
        setCard();
        setPegs([]);
    };
}