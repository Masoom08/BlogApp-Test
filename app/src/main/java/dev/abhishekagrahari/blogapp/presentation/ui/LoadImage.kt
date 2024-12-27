package dev.abhishekagrahari.blogapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter

@Composable
fun LoadImage(url: String) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "Loaded Image"
    )
}
