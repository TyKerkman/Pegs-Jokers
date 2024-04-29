
import React, {useState, useEffect} from 'react'
import {Outlet, Link} from 'react-router-dom'
import Board from '../components/Board'
import NavBar from '../components/NavBar'
import holesData from '../exampleBoard.json';
import '../Styling.css'
import { SideBar } from '../components/SideBar';
import { Hand } from '../components/Hand';
// import io from 'socket.io-client';


function Game() {
    const [pegs, setPegs] = useState([])
    const [card, setCard] = useState()
    const [newBoard, setBoard] = useState(true)
    const [cards, setCards] = useState([])
    const [player, setPlayer] = useState()
    // const [socket, setSocket] = useState(null);
    // const [moveInput, setMoveInput] = useState('');
    // const [response, setResponse] = useState('Connected to server')

    // useEffect(() => {
    //     // Connect to the server
    //     const newSocket = io('http://localhost:3306', { path: '/game/socket.io' });
    //     setSocket(newSocket);
    
    //     // Listen for connection event
    //     newSocket.on('connect', () => {
    //         console.log('Connected to server');
    //         setResponse('Connected to server');
    //     });
    
    //     // Listen for disconnect event
    //     newSocket.on('disconnect', () => {
    //         console.log('Disconnected from server');
    //         setResponse('Disconnected from server');
    //     });

    //     newSocket.on('moveResponse', (response) => {
    //         console.log('Received move response:', response);
    //         // Handle the response here, such as updating the UI
    //         setResponse('Recieved response: ' + response)
    //     });
    
    //     // Clean up on unmount
    //     return () => {
    //         newSocket.disconnect();
    //     };
    // }, []);
    
    // const sendMove = (moveData) => {
    //     if (socket) {
    //         socket.emit('move', moveData);
    //     }
    // };

    // const handleInputChange = (event) => {
    //     setMoveInput(event.target.value);
    // };

    // const handleSendMove = () => {
    //     sendMove(moveInput);
    //     setMoveInput(''); // Clear the input after sending
    // };

    return (
    <div className='game-page' data-testid="game-page">
        <NavBar title = "Pegs & Jokers"/>
        <div className='game'>

            <div className='hand-section'>
                <Hand setCard={setCard} hand={cards}/>
            </div>
        
            <div className='game-body'>
                <Board setCard={setCard} setPegs={setPegs} pegs={pegs} newBoard={newBoard} setBoard={setBoard} setCards={setCards} setPlayer={setPlayer}/> 
            </div>

            <div className='side-bar'>
                <SideBar pegs={pegs} card={card} setCard={setCard} setPegs={setPegs} setBoard={setBoard} player={player}/>
            </div>
        </div>
    </div>
)
}

export default Game
