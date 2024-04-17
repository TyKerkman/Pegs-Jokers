import React from 'react';
import Hole from './Hole'; 

const BoardSegment = ({background_color, hole }) => {
    // const segmentStyle = {
    //     background: background_color,
    //     display: 'flex',
    //     flexDirection: orientation === "vertical" ? 'column' : 'row',
    //     justifyContent: 'center',
    //     alignItems: 'center',
    //     width: orientation === "vertical" ? '40px' : '720px',
    //     height: orientation === "vertical" ? '720px' : '40px'
    // };

    const holeWrapperStyle = {
        background: background_color,
        width: '40px',
        height: '40px',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    };

    const player_colors = ['red', 'fuscia', 'green', 'blue']

    return (
        <div style={holeWrapperStyle}>
            <Hole piece={hole.peg} color={player_colors[hole.numPlayer]}/>
        </div>
    );
};

export default BoardSpot;
