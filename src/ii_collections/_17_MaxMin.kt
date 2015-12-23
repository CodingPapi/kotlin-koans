package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

val Customer.costOfOrders: Double get() {
    return this.orders.flatMap { it.products }.map { it.price }.sum()
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
//    todoCollectionTask()
    // TODO,cannot be reduced ,finger this out later
    //    return this.customers.maxBy { it.orderedProducts.map { it.price }.reduce { product1, product2 -> product1 + product2  } }
//    return this.customers.maxBy { it.costOfOrders }
    return this.customers.maxBy { it.orders.size }
//    return this.customers[0].costOfOrders

}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
//    todoCollectionTask()
    return this.orders.flatMap { it.products }.maxBy { it.price }
}


