package joao.snake.elements

import pt.isel.canvas.*

const val WIDTH = 20
const val HEIGHT = 16
const val CELL_SIZE = 32

data class Game(val snake: Snake, val wall: List<Position>) {

    fun advance(): Game {
        for(w in wall){
            if(snake.nextPos() == w){
                return Game(snake, wall)
            }
        }
        val snk = moveSnake()
        return Game(snk, wall)
    }

    fun moveSnake(): Snake{

        val snk = when (snake.dir) {
            UP -> snake.moveUp()
            DOWN -> snake.moveDown()
            LEFT -> snake.moveLeft()
            RIGHT -> snake.moveRight()
            else -> snake.moveRight()
        }
        return snk

    }

    fun genWall(canvas: Canvas, list: List<Position>): List<Position> {

        var newList = list
        canvas.onTimeProgress(5000){

            println("Wall")

            val new_w = Position((0..WIDTH).random(), (0..HEIGHT).random())

            newList += new_w
            println("${new_w}, ${newList.size}")

        }
        return newList

    }




}





