package joao.snake.elements

import pt.isel.canvas.*

fun main() {

    val iniSnk = Snake()
    var iniList = mutableListOf<Position>(Position(5, 5), Position(5, 6), Position(5, 7))
    var iniGame = Game(iniSnk, iniList)
    val canvas = Canvas(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE, BLACK)


    onStart {

        drawGrid(canvas, WIDTH, HEIGHT, CELL_SIZE)
        drawGame(canvas, iniGame)

        //Draw cell in pos(10,2)
        canvas.drawImage(
            S_H_RIGHT,
            WIDTH / 2 * CELL_SIZE,
            HEIGHT / 2 * CELL_SIZE,
            CELL_SIZE,
            CELL_SIZE
        )

        //val newList = iniGame.genWall(canvas, iniList)
        //val newList = iniGame.genWall(canvas, iniList)

        canvas.onKeyPressed { k ->
            val newSnk = when {
                k.code == UP_CODE && iniGame.snake.dir != DOWN -> Snake(iniGame.snake.pos, UP)
                k.code == DOWN_CODE && iniGame.snake.dir != UP -> Snake(iniGame.snake.pos, DOWN)
                k.code == LEFT_CODE && iniGame.snake.dir != RIGHT -> Snake(iniGame.snake.pos, LEFT)
                k.code == RIGHT_CODE && iniGame.snake.dir != LEFT -> Snake(iniGame.snake.pos, RIGHT)
                else -> iniGame.snake
            }
            iniGame = Game(newSnk, iniGame.wall)

        }//onKeyPressed

            canvas.onTimeProgress(250) {
                iniGame = iniGame.advance()
                //println(newList)
                drawGame(canvas, iniGame)



        }//onTimeProgress 250

        canvas.onTimeProgress(5000) {
            val new_w = Position((0..WIDTH).random(), (0..HEIGHT).random())
            iniList.add(new_w)
            println("${new_w}, ${iniList.size}")
        }//onTimeProgress 5000

    }//onStart

}//fun main()




    fun drawGame(canvas: Canvas, game: Game) {

        canvas.erase()

        drawGrid(canvas, WIDTH, HEIGHT, CELL_SIZE)
        drawSnake(canvas, game.snake)
        drawWall(canvas, game.wall)

    }


    fun drawGrid(canvas: Canvas, w: Int, h: Int, cs: Int) {

        //Grid
        for (i in 0..w) {
            for (j in 0..h) {
                canvas.drawRect(i * cs, j * cs, cs, cs, WHITE, 1)
            }
        }

    }

fun drawSnake(canvas: Canvas, snk: Snake) {

    drawSnakeH(canvas, snk, snk.dir)
    drawSnakeT(canvas, snk, snk.dir)
}

fun drawSnakeH(canvas: Canvas, snk: Snake, d: Int) {

    canvas.drawImage(snk.snakeImgH(d), snk.pos.x * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)

}

fun drawSnakeT(canvas: Canvas, snk: Snake, d: Int) {

    when (d) {
        UP -> canvas.drawImage(snk.snakeImgT(d), snk.pos.x * CELL_SIZE, (snk.pos.y + 1) * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        DOWN -> canvas.drawImage(snk.snakeImgT(d), snk.pos.x * CELL_SIZE, (snk.pos.y - 1) * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        LEFT -> canvas.drawImage(snk.snakeImgT(d), (snk.pos.x + 1) * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        RIGHT -> canvas.drawImage(snk.snakeImgT(d), (snk.pos.x - 1) * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        else -> canvas.drawImage(snk.snakeImgT(d), (snk.pos.x - 1) * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
    }
}

fun drawSnakeT2(canvas: Canvas, snk: Snake, d: Int) {

    when {
        snk.dir == UP -> canvas.drawImage(snk.snakeImgT(d), snk.pos.x * CELL_SIZE, (snk.pos.y + 1) * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == UP && snk.pos.y == HEIGHT - 1 -> canvas.drawImage(snk.snakeImgT(d), snk.pos.x * CELL_SIZE, 0 * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == DOWN -> canvas.drawImage(snk.snakeImgT(d), snk.pos.x * CELL_SIZE, (snk.pos.y - 1) * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == DOWN && snk.pos.y == 0 -> canvas.drawImage(snk.snakeImgT(d), snk.pos.x * CELL_SIZE, HEIGHT - 1 * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == LEFT -> canvas.drawImage(snk.snakeImgT(d), (snk.pos.x + 1) * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == LEFT && snk.pos.x == WIDTH - 1 -> canvas.drawImage(snk.snakeImgT(d), 0 * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == RIGHT -> canvas.drawImage(snk.snakeImgT(d), (snk.pos.x - 1) * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        snk.dir == RIGHT && snk.pos.x == 0 -> canvas.drawImage(snk.snakeImgT(d), WIDTH - 1 * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        else -> canvas.drawImage(snk.snakeImgT(d), (snk.pos.x - 1) * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
    }
}

fun drawWall(canvas: Canvas, wall: List<Position>) {

    for (w in wall) {
        canvas.drawImage(BRICKS, w.x * CELL_SIZE, w.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
    }

}