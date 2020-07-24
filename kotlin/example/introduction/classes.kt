class Customer

class Contact(val id: Int, var email: String, val customer: Customer)

fun main() {
    val customer_1 = Customer()

    val contact = Contact(1, "mary@gmail.com", customer_1)

    println(contact.id)
    contact.email = "jane@gmail.com"
    println(contact.email)
}
