package com.example.githubusers

object DummyContent {

    val ITEMS: MutableList<DummyItem> = ArrayList()
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    data class DummyItem(val id: String, val content: String) {
        override fun toString(): String = content
    }
}