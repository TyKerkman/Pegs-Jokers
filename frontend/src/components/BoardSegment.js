import React from 'react';
import Hole from './Hole'; 

const BoardSpot = ({ orientation = "vertical", background_color }) => {

    const holeWrapperStyle = {
        width: '40px',
        height: '40px',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    };

    return (
        <div style={holeWrapperStyle}>
        </div>
    );
};

export default BoardSpot;
