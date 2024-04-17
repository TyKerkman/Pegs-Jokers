import React, {useState, useEffect, useRef} from 'react'
import Place from './Place'
import Hole from './Hole'
import '../Styling.css'
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
                        }

                        
                        // Outside Edges
                        // else if (indexI == 0 || indexI == initialBoard.length - 1 || indexJ == 0 || indexJ == row.length - 1) {
                        //     // Determine path color based on the section: top/bottom (brown) or left/right (tan)
                        //     const isHorizontalEdge = (indexI == 0 && indexJ != 0) || (indexI == initialBoard.length - 1 && indexJ != row.length - 1);
                        //     const pathColor = isHorizontalEdge ? brown : tan;
                        
                        //     return <Place piece={item} pathColor={pathColor} position={'path'} />;
                        // }
                        // Top Section End
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == 3) || (indexI == 3 && (indexJ == 4 || indexJ == 5)) ){
                            return <Place pathColor={brown} position={'end'}/>
                        }
                        // Top Section Start
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == 8 || (indexI == 2 && (indexJ == 7 || indexJ == 9)))){        
                            if(indexI == 1 && moved){
                                return <Place pathColor={brown} position={'start'}/>
                            }
                            return <Place piece={{color: 'red'}} pathColor={brown} position={'start'}/>
                        }
                        // Right Section End
                        else if ( (indexI == 3 && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4) || (indexJ == row.length - 4 && (indexI == 4 || indexI == 5) ) )) {
                            return <Place  pathColor={tan} position={'end'}/>
                        }
                        // Right Section Start
                        else if ( (indexI == 8 && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4)) || (indexI == 7 && indexJ == row.length - 3) || (indexI == 9 && indexJ == row.length - 3) ) {
                            return <Place piece={{color: 'fuchsia'}} pathColor={tan} position={'start'}/>
                        }
                        // Bottom Section End
                        else if ( (indexJ == row.length - 4 && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 4 && (indexJ == row.length - 5 || indexJ == row.length - 6)) ) {
                            return <Place  pathColor={brown} position={'end'}/>
                        }
                        // Bottom Section Start
                        else if ( (indexJ == 10 && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 3 && (indexJ == 9 || indexJ == 11)) ){
                            return <Place piece={{color: 'green'}}  pathColor={brown} position={'start'}/>
                        }
                        // Left Section End
                        else if ( (indexI == initialBoard.length - 4 && (indexJ == 1 || indexJ == 2 || indexJ == 3)) || (indexJ == 3 && (indexI == initialBoard.length - 5 || indexI == initialBoard.length - 6)) ) {
                            return <Place  pathColor={tan} position={'end'}/>
                        }
                        // Left Section Start
                        else if ( (indexI == 10 && (indexJ == 1 || indexJ ==2 || indexJ == 3)) || (indexJ == 2 && (indexI == 9 || indexI == 11)) ) {
                            return <Place piece={{color: 'blue'}} pathColor={tan} position={'start'}/>
                        }
                        else{
                            return <Place />
                        }
                    })
                })}
            </div>
        setGrid(newGrid)
    }, [board])

    return (
        <div className='board-container'>
            <button className="button-2" onClick={updateBoard} >Move</button>
            <div className="grid-container">
                {grid}
            </div>
        </div>
    )
}

export default Board
