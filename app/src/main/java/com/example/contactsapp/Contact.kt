package com.example.contactsapp

import java.io.Serializable

data class Contact(
    val firstName: String,
    val secondName: String,
    val phone: String,
    val age: Int
) : Serializable {
    override fun toString(): String {
        return "$firstName $secondName $phone";
    }

    val imageUrl = "https://picsum.photos/200?random=${(0..150).random()}"
}
