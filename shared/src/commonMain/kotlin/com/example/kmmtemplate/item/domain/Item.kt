package com.example.kmmtemplate.item.domain

data class Item(
    val id: String,
    val description: String,
    val param: Int,
    val optionalParam: Int? = null
)
