import React, { useState, useEffect } from 'react'

export function Hand(setCard){

    return (
        <div className="hand">

            <div onClick={handleCard("ACE")} className="ACE">ACE</div>
        </div>
    )

    function handleCard(value){
        setCard({"value": value})
    }
}