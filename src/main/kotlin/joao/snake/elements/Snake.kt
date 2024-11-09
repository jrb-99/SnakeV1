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

data class Snake(var pos: Position = Position(WIDTH / 2, HEIGHT / 2), var dir: Int = RIGHT) {

    fun moveUp(): Position {
        this.dir = UP
        println(this.dir)
        if (pos.y < 0) {
            return pos.resetYD()
        }
        return pos.up()
    }

    fun moveDown(): Position {
        this.dir = DOWN
        println(this.dir)
        if(pos.y > HEIGHT - 1){
            return pos.resetYU()
        }
        return pos.down()
    }

    fun moveLeft(): Position {
        this.dir = LEFT
        println(this.dir)
        if(pos.x < 0){
            return pos.resetXL()
        }
        return pos.left()
    }

    fun moveRight(): Position {
        this.dir = RIGHT
        println(this.dir)
        if(pos.x > WIDTH - 1){
            return pos.resetXR()
            }
        return pos.right()
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
