import java.lang.Math.random
import java.util.Random
import kotlin.system.measureTimeMillis
import kotlin.math.ceil


fun main() {
    if (runAll()) {
        raceAll(10, 10)
    }
}

fun runAll(): Boolean {
    val n = 1000
    val dice7 = Dice()
    var totalFails = 0
    var tempTotal = 0
    for (i in 1..n) tempTotal += dice1(10, 10)
    if (tempTotal / n !in 50..60) { println("dice1 failed"); totalFails += 1 }
    tempTotal = 0
    for (i in 1..n) tempTotal += dice2(10, 10)
    if (tempTotal / n !in 50..60) { println("dice2 failed"); totalFails += 1 }
    tempTotal = 0
    for (i in 1..n) tempTotal += dice3(10, 10)
    if (tempTotal / n !in 50..60) { println("dice3 failed"); totalFails += 1 }
    tempTotal = 0
    for (i in 1..n) tempTotal += dice4(10, 10)
    if (tempTotal / n !in 50..60) { println("dice4 failed"); totalFails += 1 }
    tempTotal = 0
    for (i in 1..n) tempTotal += dice5(10, 10)
    if (tempTotal / n !in 50..60) { println("dice5 failed"); totalFails += 1 }
    tempTotal = 0
    for (i in 1..n) tempTotal += dice6(10, 10)
    if (tempTotal / n !in 50..60) { println("dice6 failed"); totalFails += 1 }
    tempTotal = 0
    for (i in 1..n) tempTotal += dice7(10, 10)
    if (tempTotal / n !in 50..60) { println("dice7 failed"); totalFails += 1 }
    return totalFails < 1
}

fun raceAll(num_rolls: Int, num_sides: Int) {
    val n = 1000000
    val dice7 = Dice()
    println("\nOne Million ${num_rolls}d$num_sides Rolls:")
    println("dice1 :: ${measureTimeMillis { for (i in 1..n) dice1(num_rolls, num_sides) }} ms")
    println("dice2 :: ${measureTimeMillis { for (i in 1..n) dice2(num_rolls, num_sides) }} ms")
    println("dice3 :: ${measureTimeMillis { for (i in 1..n) dice3(num_rolls, num_sides) }} ms")
    println("dice4 :: ${measureTimeMillis { for (i in 1..n) dice4(num_rolls, num_sides) }} ms")
    println("dice5 :: ${measureTimeMillis { for (i in 1..n) dice5(num_rolls, num_sides) }} ms")
    println("dice6 :: ${measureTimeMillis { for (i in 1..n) dice6(num_rolls, num_sides) }} ms")
    println("dice7 :: ${measureTimeMillis { for (i in 1..n) dice7(num_rolls, num_sides) }} ms")
}

private val rand = Random()

fun dice1(rolls: Int, sides: Int): Int {
    var total = rolls
    for (i in 1..rolls) total += rand.nextInt(sides)
    return total
}

fun randNumber(num: Int) = rand.nextInt(num) + 1

fun dice2(rolls: Int, sides: Int): Int {
    var total = 0
    for (i in 1..rolls) total += randNumber(sides)
    return total
}

fun dice3(rolls: Int, sides: Int): Int {
    var total = 0
    for (i in 1..rolls) total += ceil(random() * sides).toInt()
    return total
}

fun dice4(rolls: Int, sides: Int): Int {
    return (1..rolls).map { ceil(random() * sides).toInt() }.sum()
}

fun dice5(rolls: Int, sides: Int): Int {
    return (1..rolls).map { rand.nextInt(sides) }.sum() + rolls
}

fun dice6(rolls: Int, sides: Int): Int {
    return (1..rolls).map { rand.nextInt(sides) }.reduce { x, y -> x + y } + rolls
}

class Dice {
    private val random = Random()
    operator fun invoke(sides: Int): Int {
        return random.nextInt(sides) + 1
    }
    operator fun invoke(rolls: Int, sides: Int): Int {
        var total = rolls
        for (i in 1..rolls) total += random.nextInt(sides)
        return total
    }
}
