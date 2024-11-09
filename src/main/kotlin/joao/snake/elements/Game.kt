package joao.snake.elements

import pt.isel.canvas.*

const val WIDTH = 20
const val HEIGHT = 16
const val CELL_SIZE = 32

data class Game(val snake: Snake, val wall: List<Position>) {

    fun start() {

        onStart {

            val canvas = Canvas(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE, BLACK)

            drawGrid(canvas, WIDTH, HEIGHT, CELL_SIZE)

            //Draw cell in pos(10,2)
            canvas.drawImage(
                APPLE,
                snake.pos.x * CELL_SIZE,
                snake.pos.y * CELL_SIZE,
                CELL_SIZE,
                CELL_SIZE
            )

            canvas.onTimeProgress(250) {
                drawGame(canvas, snake)

            }


        }
    }

    fun drawGame(canvas: Canvas, snk: Snake) {

        canvas.erase()
        move(canvas, snake)
        drawGrid(canvas, WIDTH, HEIGHT, CELL_SIZE)
        drawSnake(canvas, snk)

        //println(snk.snakeImg(snk.dir))

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

        val d = snk.dir

        drawSnakeH(canvas, snk, d)
        drawSnakeT(canvas, snk, d)

        println("x: ${snk.pos.x}, y: ${snk.pos.y}")

    }

    fun drawSnakeH(canvas: Canvas, snk: Snake, d: Int) {

        when {
            snk.pos.x > WIDTH - 1 -> canvas.drawImage(snk.snakeImgH(d),0 * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
            snk.pos.x < 0 -> canvas.drawImage(snk.snakeImgH(d),WIDTH - 1 * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
            snk.pos.y > HEIGHT - 1 -> canvas.drawImage(snk.snakeImgH(d),snk.pos.x * CELL_SIZE, 0 * CELL_SIZE, CELL_SIZE, CELL_SIZE)
            snk.pos.y < 0 -> canvas.drawImage(snk.snakeImgH(d),snk.pos.x * CELL_SIZE, HEIGHT - 1 * CELL_SIZE, CELL_SIZE, CELL_SIZE)
        }

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

    fun move(canvas: Canvas, snk: Snake) {

        canvas.onKeyPressed { k ->
            if (k.code == UP_CODE && snk.dir != DOWN) snk.dir = UP
            if (k.code == DOWN_CODE && snk.dir != UP) snk.dir = DOWN
            if (k.code == LEFT_CODE && snk.dir != RIGHT) snk.dir = LEFT
            if (k.code == RIGHT_CODE && snk.dir != LEFT) snk.dir = RIGHT
        }

        snk.pos = when (snk.dir) {
            0 -> snk.moveUp()
            1 -> snk.moveDown()
            2 -> snk.moveLeft()
            3 -> snk.moveRight()
            else -> snk.moveRight()
        }
    }

}





