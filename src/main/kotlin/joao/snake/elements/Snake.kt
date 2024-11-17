package joao.snake.elements

const val UP = 0
const val DOWN = 1
const val LEFT = 2
const val RIGHT = 3
const val APPLE = "snake|0,192,64,64"
const val BRICKS = "bricks.png"
const val S_H_UP = "snake|192,0,64,64"
const val S_H_DOWN = "snake|256,64,64,64"
const val S_H_LEFT = "snake|192,64,64,64"
const val S_H_RIGHT = "snake|256,0,64,64"
const val S_T_UP = "snake|192,128,64,64"
const val S_T_DOWN = "snake|256,192,64,64"
const val S_T_LEFT = "snake|192,192,64,64"
const val S_T_RIGHT = "snake|256,128,64,64"

data class Snake(val pos: Position = Position(WIDTH / 2, HEIGHT / 2), val dir: Int = RIGHT) {

    fun moveUp(): Snake {
        if(this.dir != DOWN) {
            println("x: ${pos.x}, y: ${pos.y}")
            if (pos.y <= 0) {
                return Snake(pos.resetYD(), UP)
            }
            return Snake(pos.up(), UP)
        }
        return this
    }

    fun moveDown(): Snake {
        if(this.dir != UP) {
            println("x: ${pos.x}, y: ${pos.y}")
            if (pos.y >= HEIGHT - 1) {
                return Snake(pos.resetYU(), DOWN)
            }
            return Snake(pos.down(), DOWN)
        }
        return this
    }

    fun moveLeft(): Snake {
        if(dir != RIGHT) {
            println("x: ${pos.x}, y: ${pos.y}")
            if (pos.x <= 0) {
                return Snake(pos.resetXL(), LEFT)
            }
            return Snake(pos.left(), LEFT)
        }
        return this
    }

    fun moveRight(): Snake {
        if(dir != LEFT) {
            println("x: ${pos.x}, y: ${pos.y}")
            if (pos.x >= WIDTH - 1) {
                return Snake(pos.resetXR(), RIGHT)
            }
            return Snake(pos.right(), RIGHT)
        }
        return this
    }

    fun nextPos(): Position {
        return when (dir) {
            UP -> pos.up()
            DOWN -> pos.down()
            LEFT -> pos.left()
            RIGHT -> pos.right()
            else -> pos.right()
        }
    }

    fun snakeImgH(d: Int): String {
        when (d) {
            UP -> return S_H_UP
            DOWN -> return S_H_DOWN
            LEFT -> return S_H_LEFT
            RIGHT -> return S_H_RIGHT
        }
        return S_H_RIGHT
    }

    fun snakeImgT(d: Int): String {
        when (d) {
            UP -> return S_T_UP
            DOWN -> return S_T_DOWN
            LEFT -> return S_T_LEFT
            RIGHT -> return S_T_RIGHT
        }
        return S_T_RIGHT
    }


}
