package com.ikonovalov.gameofthrones.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.ikonovalov.gameofthrones.presentation.ui.theme.Shapes
import com.ikonovalov.gameofthrones.presentation.ui.theme.typography

@ExperimentalCoilApi
@Composable
fun CharacterCardItem(
    fullName: String,
    title: String,
    imageURL: String,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onCardClick),
        shape = Shapes.large,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onSurface),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            val image = "https://thronesapi.com/assets/images/$imageURL"
            Image(
                painter = rememberImagePainter(data = image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(12.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            TextColumn(fullName = fullName, title = title)
        }
    }
}

@Composable
fun TextColumn(fullName: String, title: String) {
    Column {
        Text(
            text = fullName,
            style = typography.subtitle1,
            color = MaterialTheme.colors.primaryVariant
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = title,
            style = typography.caption,
            color = MaterialTheme.colors.primaryVariant
        )
    }
}