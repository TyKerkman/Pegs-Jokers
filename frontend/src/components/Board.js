import React, {useState, useEffect, useRef} from 'react'
import Place from './Place'
import Piece from './Piece'
import '../App.css'

function Board({numPlayers=4}) {
    let initialPiece = {
        color: 'red'
    };



 const gridContainer =  {
    display: 'grid',
    gridTemplateColumns: 'auto auto auto auto auto auto',
    }
    let num = 6;
    let initialBoard = []
    for(let i = 0; i < num; i++){
        let temp = []
        for(let j = 0; j < num; j++){
            temp.push(null)
        }
        initialBoard.push(temp)
    }

    console.log(initialBoard)
    // initialBoard = [
    //     [null, initialPiece, null, null, null],
    //     [null, null, null, null, null],
    //     [null, null, null, null, null],
    //     [null, null, null, null, null],
    //     [null, null, null, null, null],
    // ];

    initialBoard[0][1] = initialPiece

    const [board, setBoard] = useState(initialBoard)
    const [grid, setGrid] = useState(
        <div className="grid-container">
            {
                board.map((row, indexI)=>{
                    return row.map((item, indexJ)=>{
                        if(indexI == 0 || indexI == initialBoard.length - 1 || indexJ == 0 || indexJ == row.length - 1){
                            let color = ['brown', 'brown', 'tan', 'tan']
                            let colorIndex = 3
                            if(indexI == 0 && indexJ != row.length - 1){
                                colorIndex = 0
                            }else if(indexI == initialBoard.length - 1 && indexJ != 0){
                                colorIndex = 1
                            }else if(indexJ == 0){
                                colorIndex = 2
                            }
                            if(item != null){
                                return <div className="grid-item"><Place piece={item} pathColor={color[colorIndex]} position={'path'}/></div>
                            }else{
                                return <div className="grid-item"><Place  pathColor={color[colorIndex]} position={'path'}/></div>
                            }
                        }else{
                            return <div className="grid-item"><Place /></div>
                        }
                    })
                })}
            </div>
    )

    const updateBoard = () => {
        let newBoard = [...initialBoard]
        newBoard[0][1] = null
        newBoard[0][2] = initialPiece
        newBoard[5][4] = {color: 'orange'}
        newBoard[3][0] = {color: 'blue'}
        newBoard[2][5] = {color: 'teal'}

    
        setBoard(newBoard);
    }

    useEffect(()=>{
        let newGrid =<div style={gridContainer}>
            {
                board.map((row, indexI)=>{
                    return row.map((item, indexJ)=>{
                        if(indexI == 0 || indexI == initialBoard.length - 1 || indexJ == 0 || indexJ == row.length - 1){
                            let color = ['brown', 'brown', 'tan', 'tan']
                            let colorIndex = 3
                            if(indexI == 0 && indexJ != row.length - 1){
                                colorIndex = 0
                            }else if(indexI == initialBoard.length - 1 && indexJ != 0){
                                colorIndex = 1
                            }else if(indexJ == 0){
                                colorIndex = 2
                            }
                            if(item != null){
                                return <div className="grid-item"><Place piece={item} pathColor={color[colorIndex]} position={'path'}/></div>
                            }else{
                                return <div className="grid-item"><Place  pathColor={color[colorIndex]} position={'path'}/></div>
                            }
                        }else{
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
