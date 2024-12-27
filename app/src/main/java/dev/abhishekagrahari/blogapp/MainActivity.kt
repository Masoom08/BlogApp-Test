package dev.abhishekagrahari.blogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.abhishekagrahari.blogapp.presentation.ui.ItemListScreen
import dev.abhishekagrahari.blogapp.presentation.ui.viewmodel.ItemViewModel
import dev.abhishekagrahari.blogapp.presentation.ui.viewmodel.ItemViewModelFactory
import dev.abhishekagrahari.blogapp.ui.theme.BlogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogAppTheme {
                val viewModel = ViewModelProvider(
                    this,
                    ItemViewModelFactory(applicationContext)
                ).get(ItemViewModel::class.java)
            }
                ItemListScreen(viewModel())
            }
        }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlogAppTheme {
        Greeting("Android")
    }
}