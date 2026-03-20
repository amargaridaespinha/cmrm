package cm.exer1

fun main() {

    // a) int array
    val squaresA = IntArray(50)

    for (i in 0 until 50) {

        val number = i + 1
        val square = number * number

        squaresA[i] = square
    }

    println("a) IntArray:")
    println(squaresA.joinToString())

    // b) range and map
    val numbers = 1..50
    val squaresB = numbers.map { number -> number * number }

    println("\nb) Range and map:")
    println(squaresB.joinToString())

    // c) array with constructor
    val squaresC = Array(50) { i ->
        val number = i + 1
        val square = number * number
        square
    }

    println("\nc) Array with constructor:")
    println(squaresC.joinToString())

}