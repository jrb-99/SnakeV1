package joao.snake.elements

//Represents XY pos
data class Position(val x: Int, val y: Int){

    fun up(): Position{
        return Position(x, y-1)
    }

    fun down(): Position{
        return Position(x, y+1)
    }

    fun left(): Position{
        return Position(x-1, y)
    }

    fun right(): Position{
        return Position(x+1, y)
    }

    fun resetXL(): Position{
        return Position(WIDTH - 1, y)//-1
    }

    fun resetXR(): Position{
        return Position(0, y)
    }

    fun resetYU(): Position{
        return Position(x, 0)
    }

    fun resetYD(): Position{
        return  Position(x, HEIGHT -1)//-1
    }

}

