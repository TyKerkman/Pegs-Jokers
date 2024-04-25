import React, { useEffect, useState } from 'react'

export function Turn(turn) {

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

  postTurn(turn);

  return null; 
}