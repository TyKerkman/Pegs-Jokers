import React from 'react';
import '../Styling.css'

const Hole = ({ piece, color }) => {
    const style = piece ? {
        background: color,
        height: '15px',
        width: '15px',
        borderRadius: '50%',
        display: 'inline-block'
    } : {
        background: 'black',
        height: '10px',
        width: '10px',
        borderRadius: '50%',
        display: 'inline-block'
    };

    return <div style={style}></div>;
};

export default Hole;