fun main() {
    println(calcComission(payment = 80_000))
    println(calcComission("Мир", 10_000,1_000) )
    println(calcComission("Maestro", 60_000,30_000) )
    println(calcComission("Maestro", 599_000,1_001) )
}


fun calcComission(cardType:String = "VK Pay", paymentsSum:Int = 0, payment:Int) : Int {
    // Возвращаем -1, если исполнить платеж невозможно по причине превышения лимита
    return when (cardType){
        "VK Pay" -> if (isVKLimitReached(paymentsSum, payment))  -1 else 0
        "Visa", "Мир" -> if (isCardLimitReached(paymentsSum, payment)) -1 else
            Math.max(35, (0.75 * payment / 100).toInt())
        else -> if (isCardLimitReached(paymentsSum, payment)) -1 else
            if (paymentsSum + payment <= 75_000) 0 else ((paymentsSum + payment - 75_000) * .6 / 100 + 20).toInt()
    }
}

fun isVKLimitReached(paymentsSum: Int, payment: Int): Boolean {
    return isPaymentsLimitReached(payment, paymentsSum)
}

fun isPaymentsLimitReached(payment: Int, paymentsSum: Int, paymentLimit: Int = 15_000, monthlyPaymentsLimit: Int = 40_000): Boolean {
    return payment > paymentLimit || paymentsSum + payment > monthlyPaymentsLimit
}

fun isCardLimitReached(paymentsSum:Int = 0, payment:Int) : Boolean {
    return isPaymentsLimitReached(payment, paymentsSum, 150_000, 600_000)
}
