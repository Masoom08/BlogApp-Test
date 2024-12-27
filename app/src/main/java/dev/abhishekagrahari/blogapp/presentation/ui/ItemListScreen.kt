package dev.abhishekagrahari.blogapp.presentation.ui



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import dev.abhishekagrahari.blogapp.data.local.Item
import dev.abhishekagrahari.blogapp.presentation.ui.viewmodel.ItemViewModel



@Composable
fun ItemListScreen(viewModel: ItemViewModel) {
    val items by viewModel.items.collectAsState(initial = emptyList())
    var itemName by remember { mutableStateOf(TextFieldValue("")) }
    var itemPrice by remember { mutableStateOf(TextFieldValue("")) }
    var showError by remember { mutableStateOf(false) }

    // Function to handle adding the item
    val onAddItemClicked = {
        if (itemName.text.isNotEmpty() && itemPrice.text.isNotEmpty()) {
            val price = itemPrice.text.toDoubleOrNull()
            if (price != null) {
                viewModel.addItem(itemName.text, price)
                itemName = TextFieldValue("") // Reset name field
                itemPrice = TextFieldValue("") // Reset price field
                showError = false // Reset error flag
            } else {
                // Show an error if the price is not a valid number
                showError = true
            }
        } else {
            // Show an error if any field is empty
            showError = true
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // List of items
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items.size) { index ->
                val item = items[index]
                Text(text = "${item.name} - $${item.price}")
            }
        }

        // Fields for input
        Column(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = itemName,
                onValueChange = { itemName = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField ->
                    if (itemName.text.isEmpty()) Text("Enter item name") else innerTextField()
                }
            )
            BasicTextField(
                value = itemPrice,
                onValueChange = { itemPrice = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField ->
                    if (itemPrice.text.isEmpty()) Text("Enter item price") else innerTextField()
                }
            )

            // Show an error message if input is invalid
            if (showError) {
                Text(
                    text = "Please enter valid data for both fields.",
                    color = androidx.compose.ui.graphics.Color.Red,
                    modifier = Modifier.padding(8.dp)
                )
            }

            // Add button
            Button(onClick = onAddItemClicked) {
                Text(text = "Add Item")
            }
        }
    }
}
