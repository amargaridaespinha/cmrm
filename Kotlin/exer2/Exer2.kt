package cm.exer2

fun main() {

    while (true) {

        println("Choose an operation:")
        println("1 - Add (+)")
        println("2 - Subtract (-)")
        println("3 - Multiply (*)")
        println("4 - Divide (/)")
        println("5 - Boolean AND (&&)")
        println("6 - Boolean OR (||)")
        println("7 - Boolean NOT (!)")
        println("8 - Left shift (shl)")
        println("9 - Right shift (shr)")
        println("0 - Exit")
        print("Enter your choice: ")

        val op = try {
            readLine()!!.toInt()
        } catch (e: Exception) {
            println("Invalid option.")
            continue
        }

        if (op == 0) {
            println("Exiting...")
            break
        }

        when (op) {

            1 -> {
                val a = try {
                    print("Enter first number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val b = try {
                    print("Enter second number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val result = a + b
                println("Result: $result (decimal), ${result.toString(16)} (hex)")
            }

            2 -> {
                val a = try {
                    print("Enter first number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val b = try {
                    print("Enter second number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val result = a - b
                println("Result: $result (decimal), ${result.toString(16)} (hex)")
            }

            3 -> {
                val a = try {
                    print("Enter first number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val b = try {
                    print("Enter second number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val result = a * b
                println("Result: $result (decimal), ${result.toString(16)} (hex)")
            }

            4 -> {
                val a = try {
                    print("Enter numerator: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val b = try {
                    print("Enter denominator: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                if (b == 0) {
                    println("Error: Can't divide by zero.")
                } else {
                    val result = a / b
                    println("Result: $result (decimal), ${result.toString(16)} (hex)")
                }
            }

            5 -> {
                print("Enter first boolean (true/false): ")
                val a = readLine()!!.toBoolean()
                print("Enter second boolean (true/false): ")
                val b = readLine()!!.toBoolean()
                val result = a && b
                println("Result: $result")
            }

            6 -> {
                print("Enter first boolean (true/false): ")
                val a = readLine()!!.toBoolean()
                print("Enter second boolean (true/false): ")
                val b = readLine()!!.toBoolean()
                val result = a || b
                println("Result: $result")
            }

            7 -> {
                print("Enter boolean (true/false): ")
                val a = readLine()!!.toBoolean()
                val result = !a
                println("Result: $result")
            }

            8 -> {
                val a = try {
                    print("Enter number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val n = try {
                    print("Enter shift amount: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val result = a shl n
                println("Result: $result (decimal), ${result.toString(16)} (hex)")
            }

            9 -> {
                val a = try {
                    print("Enter number: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val n = try {
                    print("Enter shift amount: ")
                    readLine()!!.toInt()
                } catch (e: Exception) {
                    println("Invalid number.")
                    continue
                }

                val result = a shr n
                println("Result: $result (decimal), ${result.toString(16)} (hex)")
            }

            else -> println("Invalid option. Try again.")
        }
    }
}