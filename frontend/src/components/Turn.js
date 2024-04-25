import React, { useEffect, useState } from 'react'

export function Turn(piece) {

  console.log(piece);

  const postTurn = async (turn) => {
    try {
      const url = 'http://localhost:8080/play/turn';

      const request = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(turn)
      };

      const res = await fetch(url, request);
      const jsonRes = await res.json();
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const turn = {
    "card": {
      "value": "ACE"
    },
    "p": {
      "color": piece.color,
      "num": piece.num
    },
    "gameID": 1
  };

  postTurn(turn);

  // useEffect(() => {
    
  // },[peg, peg2, card, is_split_move]);

  return null; 
}