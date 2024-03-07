import React, {useState, useEffect, useRef} from 'react'
import Place from './Place'
import Piece from './Piece'
import '../App.css'

function Board({numPlayers=4}) {
    let initialPiece = {
        color: 'red'
    };


let num = 15;
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

    console.log(initialBoard)

    initialBoard[0][1] = initialPiece

    const [board, setBoard] = useState(initialBoard)
    const [grid, setGrid] = useState(
        <></>
    )

    const updateBoard = () => {
        let newBoard = [...initialBoard]
        newBoard[0][1] = null
        newBoard[0][2] = initialPiece
        newBoard[3][0] = {color: 'blue'}

    
        setBoard(newBoard);
    }

    useEffect(()=>{
        let newGrid =<div style={gridContainer}>
            {
                board.map((row, indexI)=>{
                    return row.map((item, indexJ)=>{
                        // Top Section Path
                        if(indexI == 0 && indexJ != row.length - 1){
                            if(item != null){
                                return <div className="grid-item"><Place piece={item} pathColor={'brown'} position={'path'}/></div>
                            }else{
                                return <div className="grid-item"><Place  pathColor={'brown'} position={'path'}/></div>
                            }
                        }
                        // Right Section Path
                        else if(indexJ == row.length - 1 && indexI != initialBoard.length - 1){
                            if(item != null){
                                return <div className="grid-item"><Place piece={item} pathColor={'tan'} position={'path'}/></div>
                            }else{
                                return <div className="grid-item"><Place  pathColor={'tan'} position={'path'}/></div>
                            }
                        }
                        // Bottom Section Path
                        else if(indexI == initialBoard.length - 1 && indexJ != 0){
                            if(item != null){
                                return <div className="grid-item"><Place piece={item} pathColor={'brown'} position={'path'}/></div>
                            }else{
                                return <div className="grid-item"><Place  pathColor={'brown'} position={'path'}/></div>
                            }
                        }
                        // Left Section Path
                        else if(indexJ == 0 && indexI != 0){
                            if(item != null){
                                return <div className="grid-item"><Place piece={item} pathColor={'tan'} position={'path'}/></div>
                            }else{
                                return <div className="grid-item"><Place  pathColor={'tan'} position={'path'}/></div>
                            }
                        }
                        // Top Section End
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == 2) || (indexI == 3 && (indexJ == 3 || indexJ == 4)) ){
                            return <div className="grid-item"><Place  pathColor={'brown'} position={'end'}/></div>
                        }
                        // Top Section Start
                        else if( ((indexI == 1 || indexI == 2 || indexI == 3) && indexJ == Math.floor(row.length/2)) || (indexI == 2 && (indexJ == Math.floor(row.length/2) - 1 || indexJ == Math.floor(row.length/2) + 1))){
                            return <div className="grid-item"><Place  pathColor={'brown'} position={'start'}/></div>
                        }
                        // Right Section End
                        else if ( (indexI == 2 && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4) || (indexJ == row.length - 4 && (indexI == 3 || indexI == 4) ) )) {
                            return <div className="grid-item"><Place  pathColor={'tan'} position={'end'}/></div>
                        }
                        // Right Section Start
                        else if ( (indexI == Math.floor(initialBoard.length/2) && (indexJ == row.length - 2 || indexJ == row.length - 3 || indexJ == row.length - 4)) || (indexI == Math.floor(initialBoard.length/2) - 1 && indexJ == row.length - 3) || (indexI == Math.floor(initialBoard.length/2) + 1 && indexJ == row.length - 3) ) {
                            return <div className="grid-item"><Place  pathColor={'tan'} position={'start'}/></div>
                        }
                        // Bottom Section End
                        else if ( (indexJ == row.length - 3 && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 4 && (indexJ == row.length - 4 || indexJ == row.length - 5)) ) {
                            return <div className="grid-item"><Place  pathColor={'brown'} position={'end'}/></div>
                        }
                        // Bottom Section Start
                        else if ( (indexJ == Math.floor(row.length / 2) && (indexI == initialBoard.length - 2 || indexI == initialBoard.length - 3 || indexI == initialBoard.length - 4)) || (indexI == initialBoard.length - 3 && (indexJ == Math.floor(row.length / 2) - 1 || indexJ == Math.floor(row.length / 2) + 1)) ){
                            return <div className="grid-item"><Place  pathColor={'brown'} position={'start'}/></div>
                        }
                        // Left Section End
                        else if ( (indexI == initialBoard.length - 3 && (indexJ == 1 || indexJ == 2 || indexJ == 3)) || (indexJ == 3 && (indexI == initialBoard.length - 4 || indexI == initialBoard.length - 5)) ) {
                            return <div className="grid-item"><Place  pathColor={'tan'} position={'end'}/></div>
                        }
                        // Left Section Start
                        else if ( (indexI == Math.floor(initialBoard.length/2) && (indexJ == 1 || indexJ ==2 || indexJ == 3)) || (indexJ == 2 && (indexI == Math.floor(initialBoard.length/2)-1 || indexI == Math.floor(initialBoard.length/2) + 1)) ) {
                            return <div className="grid-item"><Place  pathColor={'tan'} position={'end'}/></div>
                        }
                        else{
                            return <div className="grid-item"><Place /></div>
                        }
                    
                    
                    })
                })}
            </div>
        setGrid(newGrid)
    }, [board])

    return (
        <div style={{display:'flex', flexDirection: 'column'}}>
            <button onClick={updateBoard}>Move</button>
            <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '500px', width: '500px'}}>
                {grid}
            </div>
        </div>
    )
}

export default Board
