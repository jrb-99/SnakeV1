package joao.snake.elements


fun main() {

    val snk = Snake()
    val list = mutableListOf<Position>()
    val game = Game(snk, list)

    game.start()

}