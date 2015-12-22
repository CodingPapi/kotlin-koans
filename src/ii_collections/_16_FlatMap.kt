package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toCharList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products ordered by customer
//    todoCollectionTask()
    return this.orders.flatMap { it.products.subList(0, it.products.size) }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
//    todoCollectionTask()
    return this.customers.flatMap { it.orderedProducts }.toSet()
}
