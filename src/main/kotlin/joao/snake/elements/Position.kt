package joao.snake.elements

//Represents XY pos
data class Position(val x: Int, val y: Int)

fun Position.up(): Position{
    return Position(x, y-1)
}

fun Position.down(): Position{
    return Position(x, y+1)
}

fun Position.left(): Position{
    return Position(x-1, y)
}

fun Position.right(): Position{
    return Position(x+1, y)
}