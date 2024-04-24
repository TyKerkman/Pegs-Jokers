
    import React, {useState, useEffect} from 'react'
    import {Outlet, Link} from 'react-router-dom'
    import Board from '../components/Board'
    import NavBar from '../components/NavBar'
    import holesData from '../exampleBoard.json';
    import '../Styling.css'
    import KnownCard from '../components/KnownCard';
    // import io from 'socket.io-client';


    function Game() {
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
                <div className='board-container'>


                    {/* <div className='leftBar'>
                        <div className='card-container'>
                            <KnownCard card={'2C'} />
                            <KnownCard card={'7H'}/>  
                            <KnownCard card={'JD'}/>                    
                            <KnownCard card={'AS'}/>                    
                            <KnownCard card={'BJ'}/>                    
                        </div>
                        <div className='playerContainer'>
                            <button className="button-2">Move</button>
                            Hypothetical Players Turn or Other Info Btw the button don't work
                        </div>
                    </div> */}

                    
                    <div className='game-body'>
                        <Board />
                    </div>


                    {/* <div className='rightBar'>
                        <div className='rightPlaceholder'>
                            Please keep these placeholders here
                            <input type="text" value={moveInput} onChange={handleInputChange} />
                            <button onClick={handleSendMove}>Send to Socket</button>
                            <p data-testid="response">{response}</p>
                        </div>
                    </div> */}


                </div>
            </div>
        )
    }

    export default Game
