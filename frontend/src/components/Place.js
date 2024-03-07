import React, { useEffect, useState } from 'react';

function Place({ position = null, piece = null, pathColor=null}) {
    const [color, setColor] = useState({
        background: 'black',
        height: '7.5px',
        width: '7.5px',
        borderRadius: '50%',
        display: 'inline-block'
    }); // Initialize color state with an empty string
    const [background, setBackground] = useState('')
    useEffect(() => {
        // Check if the position is 'path' and the piece is null to set the color to black
        if (position === 'path' && piece === null) {
            setBackground(pathColor)
            setColor({
                background: 'black',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        } 
        else if (position == 'start') { // If there is a piece, set the color to the piece's color
            setBackground(pathColor)
            setColor({
                background: 'black',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        }
        else if (position == 'end') { // If there is a piece, set the color to the piece's color
            setBackground(pathColor)
            setColor({
                background: 'black',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        }
        else if (piece !== null) { // If there is a piece, set the color to the piece's color
            setBackground(pathColor)
            setColor({
                background: piece.color,
                height: '12px',
                width: '12px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        } else { // Reset color if neither condition is met
            setBackground('green')
            setColor({
                background: 'green',
                height: '7.5px',
                width: '7.5px',
                borderRadius: '50%',
                display: 'inline-block'
            });
        }
    }, [position, piece]); // Watch for changes in position and piece props

    return (
        <div style={{
            background: background,
            height: '30px',
            width: '30px',
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center'
        }}>
        <div
            style={color}
        ></div>
        </div>
    );
}

export default Place;