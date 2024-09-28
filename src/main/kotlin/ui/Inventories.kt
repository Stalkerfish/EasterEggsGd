class Inventory {
    private val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun removeItem(item: Item) {
        items.remove(item)
    }

    fun getItems(): MutableList<Item> {
        return items
    }
}

object HomeInventory {
    val homeInventory = Inventory()
}

object EarthInventory {
    val earthInventory = Inventory()
}