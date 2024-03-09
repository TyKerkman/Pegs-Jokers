import React, { useEffect, useState } from 'react';

function Place({ position = null, piece = null, pathColor=null}) {

    const [hole, setHole] = useState(); // Initialize color state with an empty string
    const [background, setBackground] = useState(pathColor == null ? 'green' : pathColor)

    useEffect(() => {
        // Check if the position is 'path' and the piece is null to set the color to black
        if (position === 'path' && piece === null) {
            setHole({
                background: 'black',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        } 
        else if (position == 'start') { // If there is a piece, set the color to the piece's color
            setHole({
                background: 'black',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        }
        else if (position == 'end') { // If there is a piece, set the color to the piece's color
            setHole({
                background: 'black',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        }
        else if (piece !== null) { // If there is a piece, set the color to the piece's color
            setHole({
                background: piece.color,
                height: '12px',
                width: '12px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        } else { // Reset color if neither condition is met
            setHole({
                background: 'green',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        }
    }, [piece]); // Watch for changes in position and piece props

    return (
        <div className="grid-item">
            <div style={{background: background}} className='place-outline'>
                <div style={hole}></div>
            </div>
        </div>
    );
}

export default Place;