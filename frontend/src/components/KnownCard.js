import React from 'react'
import deckData from './deck'

function KnownCard( { card }) {
    const image = deckData[card];
    return (
        <div className='known-card'>
            <img src={image}/>
            {/* {card} */}
        </div>
    )
}

export default KnownCard
