import React, {useState, useEffect, useRef} from 'react'
import Place from './Place'
import '../Styling.css'

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
            newBoard[0][7] = initialPiece
    
            setMoved(true)
            setBoard(newBoard);
        } else {
            let newBoard = [...initialBoard]
            newBoard[1][7] = initialPiece
    
            setMoved(false)
            setBoard(newBoard);
        }
    }

    useEffect(()=>{
        let newGrid =<div style={gridContainer}>
            {
                board.map((row, indexI)=>{
                    return row.map((item, indexJ)=>{
                        if (indexI == 0 || indexI == initialBoard.length - 1 || indexJ == 0 || indexJ == row.length - 1) {
                            // Determine path color based on the section: top/bottom (brown) or left/right (tan)
                            const isHorizontalEdge = (indexI == 0 && indexJ != row.length - 1) || (indexI == initialBoard.length - 1 && indexJ != 0);
                            const pathColor = isHorizontalEdge ? brown : tan;
                        
                            return <Place piece={item} pathColor={pathColor} position={'path'} />;
                        }
                        // Top Section End
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == 2) || (indexI == 3 && (indexJ == 3 || indexJ == 4)) ){
                            return <Place pathColor={brown} position={'end'}/>
                        }
                        // Top Section Start
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == 7 || (indexI == 2 && (indexJ == 6 || indexJ == 8)))){        
                            if(indexI == 1 && moved){
                                return <Place pathColor={brown} position={'start'}/>
                            }
                            return <Place piece={{color: 'red'}} pathColor={brown} position={'start'}/>
                        }
                        // Right Section End
                        else if ( (indexI == 2 && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4) || (indexJ == row.length - 4 && (indexI == 3 || indexI == 4) ) )) {
                            return <Place  pathColor={tan} position={'end'}/>
                        }
                        // Right Section Start
                        else if ( (indexI == 7 && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4)) || (indexI == 6 && indexJ == row.length - 3) || (indexI == 8 && indexJ == row.length - 3) ) {
                            return <Place piece={{color: 'fuchsia'}} pathColor={tan} position={'start'}/>
                        }
                        // Bottom Section End
                        else if ( (indexJ == row.length - 3 && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 4 && (indexJ == row.length - 4 || indexJ == row.length - 5)) ) {
                            return <Place  pathColor={brown} position={'end'}/>
                        }
                        // Bottom Section Start
                        else if ( (indexJ == 11 && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 3 && (indexJ == 10 || indexJ == 12)) ){
                            return <Place piece={{color: 'green'}}  pathColor={brown} position={'start'}/>
                        }
                        // Left Section End
                        else if ( (indexI == initialBoard.length - 3 && (indexJ == 1 || indexJ == 2 || indexJ == 3)) || (indexJ == 3 && (indexI == initialBoard.length - 4 || indexI == initialBoard.length - 5)) ) {
                            return <Place  pathColor={tan} position={'end'}/>
                        }
                        // Left Section Start
                        else if ( (indexI == 11 && (indexJ == 1 || indexJ ==2 || indexJ == 3)) || (indexJ == 2 && (indexI == 10 || indexI == 12)) ) {
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
