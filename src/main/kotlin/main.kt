fun main() {
<<<<<<< HEAD
    println(calcComission(payment = 80000))
=======
    println(calcComission(payment = 80_000))
>>>>>>> 24b2724 (Initial commit)
    println(calcComission("Мир", 10_000,1_000) )
    println(calcComission("Maestro", 60_000,30_000) )
}


fun calcComission(cardType:String = "VK Pay", paymentsSum:Int = 0, payment:Int) : Int {
    return when (cardType){
        "VK Pay" -> 0
        "Visa", "Мир" -> Math.max(35, (0.75 * payment / 100).toInt())
        else -> if (paymentsSum + payment <= 75_000) 0 else ((paymentsSum + payment - 75_000) * .6 / 100 + 20).toInt()
    }
}