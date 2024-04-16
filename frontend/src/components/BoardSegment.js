import React from 'react';
import Hole from './Hole'; 

const BoardSegment = ({ orientation = "vertical", background_color }) => {
    const segmentStyle = {
        background: background_color,
        display: 'flex',
        flexDirection: orientation === "vertical" ? 'column' : 'row',
        justifyContent: 'center',
        alignItems: 'center',
        width: orientation === "vertical" ? '40px' : '720px',
        height: orientation === "vertical" ? '720px' : '40px'
    };

    const holeWrapperStyle = {
        width: '40px',
        height: '40px',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    };

    return (
        <div style={segmentStyle}>
            {Array.from({ length: 18 }).map((_, index) => (
                <div key={index} style={holeWrapperStyle}>
                    <Hole />
                </div>
            ))}
        </div>
    );
};

export default BoardSegment;
