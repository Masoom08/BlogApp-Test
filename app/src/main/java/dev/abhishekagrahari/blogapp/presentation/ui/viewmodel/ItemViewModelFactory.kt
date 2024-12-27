package dev.abhishekagrahari.blogapp.presentation.ui.viewmodel



import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.abhishekagrahari.blogapp.data.AppModule

class ItemViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(AppModule.provideItemRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
