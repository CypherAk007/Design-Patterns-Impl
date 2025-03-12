```
##Class Diagram
class Game {

  attributes:
    board: Board
    players: List<Player>
    moves: List<Move>
    winner: Player
    gameState: GameState
    winningStrategies: List<WinningStrategy>
    snakes: List<Obstacles>
    ladders: List<Obstacles>
    nextPlayerMoveIndex: int 

  methods:
    // @Getters and @Setters for above Attributes 
    display() : void 
    makeMove() : void 
    checkWinner(board: Board,finalMove: Move): boolean
    isValidMove(currentPlayer:Player,move: Move): boolean
    checkForObstacle(move:Move)

}

class Player {

  attributes:
    symbol: Symbol
    name: String
    id: long
    playerType: PlayerType 
    cell:Cell

  methods:
    // @Getters and @Setters for above Attributes 
    makeMove(board: Board) : Move
    rollTheDice():int
}

class Board {

  attributes:
    size: int 
    board: List<List<Cell>>
    snakes:List<Obstacles>
    ladders:List<Obstacles>
    players:List<Player>

  methods:
  // @Getters and @Setters for above Attributes 
    display() : void 
    initializeBoard(size:int) : List<List<Cell>>
    initializePlayers(players:List<Player>):void
    updateWithSnakes(obstacles:List<Obstacles>):void
    updateWithLadders(obstacles:List<Obstacles>):void
    findRowAndColGivenCellNumber(boardNo:int):int[]
}

class Cell {

  attributes:
    row : int 
    col : int 
    obstacleValue : int 
    cellNo : int 
    cellState: CellState 
    player : Set<Player>

  methods:
    // @Getters and @Setters for above Attributes 
    initializeValue(row:int,col:int):initializeBoard
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

class Obstacles{
    attributes:
        head:int 
        tail:int
    methods: 
    // @Getters and @Setters for above Attributes 
}

enum PlayerType {
    HUMAN,
    BOT
}


enum CellState {
    SNAKE,
    LADDER,
    EMPTY,
    FILLED
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
2. Strategy Pattern for winning strategy(LastBoxWinningStrategy) based on user input and Implemented using Interfaces
3. Strategy Pattern for BotPlayingStrategy (Easy, Medium, Hard) based on user input and Implemented using Interfaces
4. The whole game is built on MVC Architecture. And Client Contract is GameController.
 
```