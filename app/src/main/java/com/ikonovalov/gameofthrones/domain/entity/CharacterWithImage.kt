package com.ikonovalov.gameofthrones.domain.entity

data class CharacterWithImage(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val title: String,
    val family: String,
    val image: String,
    val imageURL: String,
)
