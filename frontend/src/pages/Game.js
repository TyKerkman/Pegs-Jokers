
import React, {useState, useEffect} from 'react'
import {Outlet, Link} from 'react-router-dom'
import Board from '../components/Board'
import NavBar from '../components/NavBar'
import holesData from '../exampleBoard.json';
import '../Styling.css'
import { SideBar } from '../components/SideBar';
import { Hand } from '../components/Hand';
import io from 'socket.io-client';


function Game({user}) {
    const instance = {user}.user;
    const [pegs, setPegs] = useState([])
    const [card, setCard] = useState()
    const [cards, setCards] = useState([])
    const [player, setPlayer] = useState()
    const [newBoard, setBoard] = useState(true)
    const [turn, setTurn] = useState(false);
    const [socket, setSocket] = useState(null);
    const [moveInput, setMoveInput] = useState('');
    const [response, setResponse] = useState('Connected to server')


    useEffect(() => {
        // Connect to the server
        const newSocket = io('http://localhost:3306', { path: '/game/socket.io' });
        setSocket(newSocket);
    
        // Listen for connection event
        newSocket.on('connect', () => {
            console.log('Connected to server');
            setResponse('Connected to server');
        });
    
        // Listen for disconnect event
        newSocket.on('disconnect', () => {
            console.log('Disconnected from server');
            setResponse('Disconnected from server');
        });

        newSocket.on('moveResponse', (response) => {
            console.log('Received move response:', response);
            // Handle the response here, such as updating the UI
            setResponse('Recieved response: ' + response)
        });
    
        // Clean up on unmount
        return () => {
            newSocket.disconnect();
        };
    }, []);

    useEffect(() => {
        if (socket) {
            socket.emit('updateBoard', "UPDATE BOARD");
        }
    }, [newBoard]);

    useEffect(() => {
        setTurn(instance === player)
    }, [instance, player])

    return (
    <div className='game-page' data-testid="game-page">
        <NavBar title = "Pegs & Jokers"/>
        <div className='game'>

            <div className='hand-section'>
                <Hand setCard={setCard} hand={cards}/>
            </div>
        
            <div className='game-body'>
                <Board setCard={setCard} setPegs={setPegs} pegs={pegs} newBoard={newBoard} setBoard={setBoard} setCards={setCards} setPlayer={setPlayer} user={instance} turn={turn}/> 
            </div>
            {turn && (
                <div className='side-bar'>
                    <SideBar pegs={pegs} card={card} setCard={setCard} setPegs={setPegs} setBoard={setBoard} player={player}/>
                </div>
            )}
        </div>
    </div>
    )
}

export default Game
