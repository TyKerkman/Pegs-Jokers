import React, { useEffect, useState } from 'react'
import '../Styling.css'

export function SideBar({pegs, card, is_split_move}) {
    return (
        <div className='turn-bar'>
            <h1 className='turn-header'>Play a Turn!</h1>
            {pegs.map((peg, index) => (
                <div key={index} className='peg'>
                    Peg {index+1}: {peg.color} {peg.num}
                </div>
            ))}
            <p className='card'>ace</p>
        </div>
    )
}