package dev.abhishekagrahari.blogapp.presentation.ui.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.abhishekagrahari.blogapp.data.local.Item
import dev.abhishekagrahari.blogapp.data.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    val items: Flow<List<Item>> = repository.items

    fun addItem(name: String, price: Double) {
        viewModelScope.launch {
            repository.addItem(Item(name = name, price = price))
        }
    }
}
