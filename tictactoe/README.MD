## Class Diagram - Tic Tac Toe

```
class Game {

  attributes:
    board: Board
    players: List<Player>
    moves: List<Move>
    winner: Player
    status: GameStatus
    nextPlayerMoveIndex: int 
    winningStrategies: List<WinningStrategy>

  methods:
    getBoard() : Board
    getPlayers() : List<Player>
    getMoves() : List<Move>
    getWinner() : Player 
    getState() : GameState
    display() : void 
    makeMove() : void 
    checkWinner(board: Board,lastMove: Move): boolean
    isValidMove(move: Move): boolean
}

class Player {

  attributes:
    symbol: Symbol
    name: String
    id: long
    playerType: PlayerType 

  methods:
    // @Getters and @Setters for above Attributes 
    makeMove(board: Board) : Move
}

class Board {

  attributes:
    size: int 
    board: List<List<Cell>>

  methods:
  // @Getters and @Setters for above Attributes 
    display() : void 
    initializing(size:int) : List<List<Cell>>
}

class Cell {

  attributes:
    row : int 
    col : int 
    cellState: CellState 
    player : Player 

  methods:
    // @Getters and @Setters for above Attributes 
}

class Move {

  attributes:
    player: Player
    cell: Cell

  methods:
    getCell() : cell 
    getPlayer(): Player
    setPlayer(player:Player): void
}

class BOT extends Player{

    attributes:
        level: BotDifficultyLevel
        botPlayingStrategy: BotPlayingStrategy 
    
    methods: 
    // @Getters and @Setters for above Attributes 
        makeMove(board: Board): Move
}

class Symbol{
    attributes:
        character : char 
    methods: 
    // @Getters and @Setters for above Attributes 
}


enum PlayerType {
    HUMAN,
    BOT
}


enum cellStatus {
    FILLED,
    EMPTY,
    BLOCKED
}

enum gameStatus {
    IN-PROGRESS,
    DRAW,
    WIN,
    PAUSE
}

enum BotDifficultyLevel {
    EASY,
    MEDIUM,
    HARD
}


Design patterns

1. Builder Pattern Game object creation and all the validations will be added before
building game object
2. Strategy Pattern for winning strategy(Row, Column, Diagonal) based on user input
3. Strategy Pattern for BotPlayingStrategy (Easy, Medium, Hard) based on user input```