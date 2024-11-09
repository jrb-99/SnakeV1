package joao.snake.elements

import pt.isel.canvas.*

// Properties
//const val WIDTH = 20
//const val HEIGHT = 16
//const val CELL_SIZE = 32

/*fun main() {

    onStart {
        val canvas = Canvas(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE, BLACK)
        var snk = Snake(pos = Position(WIDTH/2, HEIGHT/2))

        //Grid
        for (i in 0..WIDTH) {
            for (j in 0..HEIGHT) {
                canvas.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE, WHITE, 1)
            }
        }

        //Draw cell in pos(10,2)
        canvas.drawImage("snake|0,192,64,64", snk.pos.x * CELL_SIZE, snk.pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)

        canvas.onKeyPressed { k ->
            snk.pos = when (k.code) {
                UP_CODE -> snk.pos.up()
                DOWN_CODE -> snk.pos.down()
                LEFT_CODE -> snk.pos.left()
                RIGHT_CODE -> snk.pos.right()
                else -> snk.pos
            }

            draw(canvas, snk.pos)

        }
    }
}

fun draw(canvas: Canvas, pos: Position) {

    canvas.erase()
    //Grid
    for (i in 0..WIDTH) {
        for (j in 0..HEIGHT) {
            canvas.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE, WHITE, 1)
        }
    }
    canvas.drawImage("snake|0,192,64,64", pos.x * CELL_SIZE, pos.y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
}*/