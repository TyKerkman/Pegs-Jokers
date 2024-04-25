import React, { useEffect, useState } from 'react'

export function SideBar({pegs, card, is_split_move}) {
    return (
        <div className='turn-bar'>
            {pegs.map((peg, index) => (
                <div key={index} className='peg' style={{ backgroundColor: peg.color }}>
                    {peg.num}
                </div>
            ))}
        </div>
    )
}