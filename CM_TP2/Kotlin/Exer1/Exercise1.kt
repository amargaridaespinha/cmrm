package org.example.cm2.Exer1

sealed class Event {
    data class Login(val username: String, val timestamp: Long) : Event()
    data class Purchase(val username: String, val amount: Double, val timestamp: Long) : Event()
    data class Logout(val username: String, val timestamp: Long) : Event()
}

fun List<Event>.filterByUser(username: String): List<Event> {
    return this.filter { event ->
        when (event) {
            is Event.Login -> event.username == username
            is Event.Purchase -> event.username == username
            is Event.Logout -> event.username == username
        }
    }
}

fun List<Event>.totalSpent(username: String): Double {
    return this
        .filterIsInstance<Event.Purchase>()
        .filter { it.username == username }
        .sumOf { it.amount }
}

fun processEvents(events: List<Event>, handler: (Event) -> Unit) {
    events.forEach { event ->
        handler(event)
    }
}

fun main() {
    val events = listOf(
        Event.Login("alice", 1000),
        Event.Purchase("alice", 49.99, 1100),
        Event.Purchase("bob", 19.99, 1200),
        Event.Login("bob", 1050),
        Event.Purchase("alice", 15.00, 1300),
        Event.Logout("alice", 1400),
        Event.Logout("bob", 1500)
    )

    processEvents(events) { event ->
        when (event) {
            is Event.Login -> println("[LOGIN] ${event.username} logged in at t=${event.timestamp}")
            is Event.Purchase -> println("[PURCHASE] ${event.username} spent $${event.amount} at t=${event.timestamp}")
            is Event.Logout -> println("[LOGOUT] ${event.username} logged out at t=${event.timestamp}")
        }
    }

    println("Total spent by alice: $%.2f".format(events.totalSpent("alice")))
    println("Total spent by bob: $%.2f".format(events.totalSpent("bob")))

    println("Events for alice:")
    events.filterByUser("alice").forEach { event ->
        println(event)
    }
}