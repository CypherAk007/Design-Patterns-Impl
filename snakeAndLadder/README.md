```
## Class Diagram
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
 

## DRY RUN 
┌──────┬──────┬──────┬──────┐
│ 16   │ 15   │ 14   │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 6    │ 5    │
├──────┼──────┼──────┼──────┤
│ AX   │ 2    │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!

FOR SNAKE AND LADDER USUAL BOARD NUMBERS
ARE REPLACED WITH TOP OF LADDER OR TAIL OF
SNAKE

┌──────┬──────┬──────┬──────┐
│ 16   │ 15   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ A    │ 13   │ X    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!

███████╗███╗   ██╗ █████╗ ██╗  ██╗███████╗     █████╗ ███╗   ██╗██████╗     ██╗      █████╗ ██████╗ ██████╗ ███████╗██████╗ 
██╔════╝████╗  ██║██╔══██╗██║ ██╔╝██╔════╝    ██╔══██╗████╗  ██║██╔══██╗    ██║     ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
███████╗██╔██╗ ██║███████║█████╔╝ █████╗      ███████║██╔██╗ ██║██║  ██║    ██║     ███████║██║  ██║██║  ██║█████╗  ██████╔╝
╚════██║██║╚██╗██║██╔══██║██╔═██╗ ██╔══╝      ██╔══██║██║╚██╗██║██║  ██║    ██║     ██╔══██║██║  ██║██║  ██║██╔══╝  ██╔══██╗
███████║██║ ╚████║██║  ██║██║  ██╗███████╗    ██║  ██║██║ ╚████║██████╔╝    ███████╗██║  ██║██████╔╝██████╔╝███████╗██║  ██║
╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝     ╚══════╝╚═╝  ╚═╝╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝
                                                                                                                            
Welcome to the Game!! This is a multiplayer Game where we have an option to have a Bot also play the game
The Board is zig-zag order Every player starts at bottem left and has to reach Top left. The First person to reach is the winner
If any board location has a different number then it is either a Snake or a Ladder!!
┌──────┬──────┬──────┬──────┐
│ 16   │ 15   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ AX   │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 4
Ak's New Board Location is : 5
Oh No!! Player Ak has Arrived at Snake!!
┌──────┬──────┬──────┬──────┐
│ 16   │ 15   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ X    │ A    │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its GPT turn to play, Please Roll the Dice...
GPT's Rolled Dice Value is : 5
GPT's New Board Location is : 6
Bonus Player GPT has Arrived at Ladder!!
┌──────┬──────┬──────┬──────┐
│ 16   │ 15   │ 1    │ X    │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ A    │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 2
Ak's New Board Location is : 4
┌──────┬──────┬──────┬──────┐
│ 16   │ 15   │ 1    │ X    │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ A    │
└──────┴──────┴──────┴──────┘
Its GPT turn to play, Please Roll the Dice...
GPT's Rolled Dice Value is : 2
GPT's New Board Location is : 15
┌──────┬──────┬──────┬──────┐
│ 16   │ X    │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ A    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 5
Ak's New Board Location is : 9
┌──────┬──────┬──────┬──────┐
│ 16   │ X    │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ A    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its GPT turn to play, Please Roll the Dice...
GPT's Rolled Dice Value is : 2
GPT's New Board Location is : 17
Invalid Move!
┌──────┬──────┬──────┬──────┐
│ 16   │ X    │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ A    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 3
Ak's New Board Location is : 12
┌──────┬──────┬──────┬──────┐
│ 16   │ X    │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ A    │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its GPT turn to play, Please Roll the Dice...
GPT's Rolled Dice Value is : 3
GPT's New Board Location is : 18
Invalid Move!
┌──────┬──────┬──────┬──────┐
│ 16   │ X    │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ A    │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 3
Ak's New Board Location is : 15
┌──────┬──────┬──────┬──────┐
│ 16   │ AX   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its GPT turn to play, Please Roll the Dice...
GPT's Rolled Dice Value is : 4
GPT's New Board Location is : 19
Invalid Move!
┌──────┬──────┬──────┬──────┐
│ 16   │ AX   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 4
Ak's New Board Location is : 19
Invalid Move!
┌──────┬──────┬──────┬──────┐
│ 16   │ AX   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its GPT turn to play, Please Roll the Dice...
GPT's Rolled Dice Value is : 3
GPT's New Board Location is : 18
Invalid Move!
┌──────┬──────┬──────┬──────┐
│ 16   │ AX   │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
Its Ak turn to play, Please Roll the Dice...
Please Type 'y' to Roll the Dice!!
y
Ak's Rolled Dice Value is : 1
Ak's New Board Location is : 16
┌──────┬──────┬──────┬──────┐
│ A    │ X    │ 1    │ 13   │
├──────┼──────┼──────┼──────┤
│ 9    │ 10   │ 11   │ 12   │
├──────┼──────┼──────┼──────┤
│ 8    │ 7    │ 13   │ 2    │
├──────┼──────┼──────┼──────┤
│ 1    │ 15   │ 3    │ 4    │
└──────┴──────┴──────┴──────┘
The winner is:- Ak

Process finished with exit code 0

```