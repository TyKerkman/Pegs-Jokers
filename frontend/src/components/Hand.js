import React, { useState, useEffect } from 'react'

export function Hand({setCard}){
    const [inputValue, setInputValue] = useState('');

    function handleInputChange(event) {
        setInputValue(event.target.value);
    }

    function handleConfirm() {
        setCard({ "value": inputValue });
        setInputValue('');
    }

    return (
        <div className="hand">
            <input 
                type="text" 
                value={inputValue} 
                onChange={handleInputChange} 
                placeholder="Type something..."
            />
            <button onClick={handleConfirm}>Confirm</button>
        </div>
    );
}