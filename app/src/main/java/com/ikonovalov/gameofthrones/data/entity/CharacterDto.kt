package com.ikonovalov.gameofthrones.data.entity

data class CharacterDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val title: String,
    val family: String,
    val image: String,
    val imageURL: String?,
)