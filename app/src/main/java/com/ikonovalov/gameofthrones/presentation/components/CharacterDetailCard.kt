package com.ikonovalov.gameofthrones.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.ikonovalov.gameofthrones.presentation.ui.theme.typography

@ExperimentalCoilApi
@Composable
fun CharacterDetailCard(
    imageUrl: String,
    family: String,
    fullName: String,
    title: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 16.dp, top = 40.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colors.background), contentAlignment = Alignment.BottomCenter
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colors.onSurface)
        )

        //content
        CharacterDetailContent(
            imageUrl = imageUrl,
            family = family,
            title = title,
            fullName = fullName
        )

    }
}

@ExperimentalCoilApi
@Composable
fun CharacterDetailContent(
    imageUrl: String,
    family: String,
    fullName: String,
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = "https://thronesapi.com/assets/images/$imageUrl"
        Image(
            painter = rememberImagePainter(data = image),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(240.dp)
                .width(190.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = family,
                style = typography.caption,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = fullName,
                style = typography.subtitle1,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                style = typography.caption,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}