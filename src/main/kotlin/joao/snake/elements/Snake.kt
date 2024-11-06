package joao.snake.elements

data class Snake(var pos: Position, var dir: Int = 3) {

    val UP = 0
    val DOWN = 1
    val LEFT = 2
    val RIGHT = 3
}
