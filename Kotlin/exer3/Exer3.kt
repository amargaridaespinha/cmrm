package cm.exer3

fun main() {
    val bounces = generateSequence(100.0) { it * 0.6 }
        .filter { it >= 1 }
        .take(15)
        .toList()

    println("RESULT:")
    bounces.forEach { println("%.2f".format(it)) }
}