import React, {useState, useEffect, useRef} from 'react'
import Place from './Place'
import Hole from './Hole'
import '../Styling.css'
import KnownCard from './KnownCard';
import data from '../exampleBoard.json'
import { initializeAnalytics } from 'firebase/analytics'

function Board({numPlayers=4}) {

    let initialPiece = {
        color: 'red'
    };

    let num = 19;
    const gridContainer =  {
        display: 'grid',
        gridTemplateColumns: `repeat(${num}, auto)`,

    }
    
    let initialBoard = []
    for(let i = 0; i < num; i++){
        let temp = []
        for(let j = 0; j < num; j++){
            temp.push(null)
        }
        initialBoard.push(temp)
    }

    const brown = '#61483e';
    const tan = '#dfb289';

    const [board, setBoard] = useState(initialBoard)
    const [grid, setGrid] = useState()
    const [moved, setMoved] = useState(false)

    const start_locations = [
        // TOP
        [
            [3, 8], [2, 7], [2, 8], [2, 9], [1, 8]
        ], 
        // RIGHT
        [
            [8, 15], [7, 16], [8, 16], [9, 16], [8, 17]
        ], 
        // BOTTOM
        [
            [15, 10], [16, 9], [16, 10], [16, 11], [17, 10]
        ], 
        // LEFT
        [
            [10, 3], [9, 2], [10, 2], [11, 2], [10, 1]
        ]
    ]

    const heaven_locations = [
        // TOP
        [
            [1, 3], [2, 3], [3, 3], [3, 4], [3, 5]
        ], 
        // RIGHT
        [
            [3, 17], [3, 16], [3, 15], [4, 15], [5, 15]
        ], 
        // BOTTOM
        [
            [17, 15], [16, 15], [15, 15], [15, 14], [15, 13]
        ], 
        // LEFT
        [
            [15, 1], [15, 2], [15, 3], [14, 3], [13, 3]
        ]
    ]

    const updateBoard = () => {
        if (!moved){
            let newBoard = [...initialBoard]
            newBoard[0][8] = initialPiece
    
            setMoved(true)
            setBoard(newBoard);
        } else {
            let newBoard = [...initialBoard]
            newBoard[1][8] = initialPiece
    
            setMoved(false)
            setBoard(newBoard);
        }
    }

    function checkSection(indexI, indexJ) {
        const pathColors = [brown, tan];
        const location = [heaven_locations, start_locations]
        let starts = [[], [], [], []]
        let heavens = [[], [], [], []]

        // NEED SOMETHING FOR STARTS, CANT USE HEAVENS FOR BOTH
        data.heavens.forEach(heaven => {
            heaven.forEach(peg => {
                heavens[peg.numPlayer].push(peg.peg)
                starts[peg.numPlayer].push(peg.peg)
            })
        });

        const section = [heavens, starts]
        for (let i = 0; i < 4; i++) {
            for (let j = 0; j < 2; j++){
                if ( location[j][i].some(coords => coords.every((val, index) => val === [indexI, indexJ][index])) ){
                    if(section[j][i][location[j][i].findIndex(coords => coords.every((val, index) => val === [indexI, indexJ][index]))]){
                        return <Place piece={section[j][i][location[j][i].findIndex(coords => coords.every((val, index) => val === [indexI, indexJ][index]))]} pathColor={pathColors[i % 2]} position={'end'}/>
                    }else {
                        return <Place pathColor={pathColors[i % 2]} position={'end'}/>
                    }
                }
            }
        }
    
        return <Place />;
    }

    useEffect(()=>{
        let newGrid =<div style={gridContainer}>
            {
                board.map((row, indexI)=>{
                    //Top Row Holes
                    return row.map((item, indexJ)=>{
                        //Num Player 0's
                        if (indexI == 0 && indexJ > 0){
                            const pathColor = brown;
                            const peg = data.loop[indexJ - 1].peg
                            return <Place piece={peg} pathColor={pathColor} position={'path'} />;
                        }

                        else if (indexI > 0 && indexJ == row.length - 1){
                            const pathColor = tan;
                            const peg = data.loop[18 + indexI - 1].peg
                            return <Place piece={peg} pathColor={pathColor} position={'path'} />;
                        }

                        else if (indexI == initialBoard.length - 1 && indexJ < row.length - 1){
                            const pathColor = brown;
                            const peg = data.loop[36 + (row.length - 1 - indexJ - 1)].peg
                            return <Place piece={peg} pathColor={pathColor} position={'path'} />;
                        }

                        else if (indexI < initialBoard.length - 1 && indexJ == 0){
                            const pathColor = tan;
                            const peg = data.loop[52 + (initialBoard.length - 1 - (indexI - 1))].peg
                            return <Place piece={peg} pathColor={pathColor} position={'path'} />;
                        }else{
                            return checkSection(indexI, indexJ)
                        }
                    })
                })}
            </div>
        setGrid(newGrid)
    }, [board])

    return (
        <div className='board-container'>
            <div className='user-hand'>
                <div className='card-container'>
                    <KnownCard card={'3'} />
                    <KnownCard />  
                    <KnownCard />                    
                    <KnownCard />                    
                    <KnownCard />                    
                  
                </div>
            </div>
            <div className="grid-container">
                {grid}
            </div>
        </div>
    )
}

export default Board
