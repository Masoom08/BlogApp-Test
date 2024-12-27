package dev.abhishekagrahari.blogapp.data.repository



import dev.abhishekagrahari.blogapp.data.local.Item
import dev.abhishekagrahari.blogapp.data.local.ItemDao
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val dao: ItemDao) {
    val items: Flow<List<Item>> = dao.getAllItems()
    suspend fun addItem(item: Item) = dao.insertItem(item)
}
