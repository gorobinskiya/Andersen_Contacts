package com.example.contactsapp
import java.io.Serializable

data class Contact(
    val firstName : String,
    val secondName: String,
    val phone : String ): Serializable {
        override fun toString(): String {
            return "$firstName $secondName $phone";
        }
    }
