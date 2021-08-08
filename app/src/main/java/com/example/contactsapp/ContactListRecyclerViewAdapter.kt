package com.example.contactsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class ContactListRecyclerViewAdapter(var data: List<Contact>, val onClick: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactListRecyclerViewAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val contactRowView =
            LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout, parent, false)
        return ContactViewHolder(contactRowView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactName = getContactName(data[position])
        holder.contactNameTextView.text = contactName
        holder.itemView.setOnClickListener { onClick(data[position]) }
        Glide.with(holder.itemView.context).load(data[position].imageUrl).into(holder.avatarImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun getContactName(contact: Contact): String {
        return contact.firstName + " " + contact.secondName + " " + contact.phone
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactNameTextView: TextView = itemView.findViewById(R.id.contactNameView)
        val avatarImage: ImageView = itemView.findViewById(R.id.avatar_image)
    }

}