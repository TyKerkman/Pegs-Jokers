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

    const [board, setBoard] = useState(initialBoard)
    const [grid, setGrid] = useState()
    const [moved, setMoved] = useState(false)

    const updateBoard = () => {
        let newBoard = [...initialBoard]
        newBoard[0][9] = initialPiece

        setMoved(true)
        setBoard(newBoard);
    }

    useEffect(()=>{
        let newGrid =<div style={gridContainer}>
            {
                board.map((row, indexI)=>{
                    return row.map((item, indexJ)=>{
                        // Top Section Path
                        if(indexI == 0 && indexJ != row.length - 1){
                                return <Place piece={item} pathColor={'brown'} position={'path'}/>
                        }
                        // Right Section Path
                        else if(indexJ == row.length - 1 && indexI != initialBoard.length - 1){
                            return <Place piece={item} pathColor={'tan'} position={'path'}/>
                        }
                        // Bottom Section Path
                        else if(indexI == initialBoard.length - 1 && indexJ != 0){
                            return <Place piece={item} pathColor={'brown'} position={'path'}/>
                        }
                        // Left Section Path
                        else if(indexJ == 0 && indexI != 0){
                            return <Place piece={item} pathColor={'tan'} position={'path'}/>
                        }
                        // Top Section End
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == 2) || (indexI == 3 && (indexJ == 3 || indexJ == 4)) ){
                            return <Place pathColor={'brown'} position={'end'}/>
                        }
                        // Top Section Start
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == Math.floor(row.length/2)) || (indexI == 2 && (indexJ == Math.floor(row.length/2) - 1 || indexJ == Math.floor(row.length/2) + 1))){
                            
                            if(indexI == 1 && moved){
                                return <Place pathColor={'brown'} position={'start'}/>
                            }
                            return <Place piece={{color: 'red'}} pathColor={'brown'} position={'start'}/>
                        }
                        // Right Section End
                        else if ( (indexI == 2 && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4) || (indexJ == row.length - 4 && (indexI == 3 || indexI == 4) ) )) {
                            return <Place  pathColor={'tan'} position={'end'}/>
                        }
                        // Right Section Start
                        else if ( (indexI == Math.floor(initialBoard.length/2) && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4)) || (indexI == Math.floor(initialBoard.length/2) - 1 && indexJ == row.length - 3) || (indexI == Math.floor(initialBoard.length/2) + 1 && indexJ == row.length - 3) ) {
                            return <Place piece={{color: 'blue'}} pathColor={'tan'} position={'start'}/>
                        }
                        // Bottom Section End
                        else if ( (indexJ == row.length - 3 && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 4 && (indexJ == row.length - 4 || indexJ == row.length - 5)) ) {
                            return <Place  pathColor={'brown'} position={'end'}/>
                        }
                        // Bottom Section Start
                        else if ( (indexJ == Math.floor(row.length / 2) && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 3 && (indexJ == Math.floor(row.length / 2) - 1 || indexJ == Math.floor(row.length / 2) + 1)) ){
                            return <Place piece={{color: 'red'}}  pathColor={'brown'} position={'start'}/>
                        }
                        // Left Section End
                        else if ( (indexI == initialBoard.length - 3 && (indexJ == 1 || indexJ == 2 || indexJ == 3)) || (indexJ == 3 && (indexI == initialBoard.length - 4 || indexI == initialBoard.length - 5)) ) {
                            return <Place  pathColor={'tan'} position={'end'}/>
                        }
                        // Left Section Start
                        else if ( (indexI == Math.floor(initialBoard.length/2) && (indexJ == 1 || indexJ ==2 || indexJ == 3)) || (indexJ == 2 && (indexI == Math.floor(initialBoard.length/2)-1 || indexI == Math.floor(initialBoard.length/2) + 1)) ) {
                            return <Place piece={{color: 'blue'}} pathColor={'tan'} position={'start'}/>
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
