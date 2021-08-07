package com.example.contactsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ContactListRecyclerViewAdapter(context: Context?, data: List<Contact>) : RecyclerView.Adapter<ContactListRecyclerViewAdapter.ViewHolder>() {
    private val contacts: List<Contact>
    private val inflater: LayoutInflater
    private var clickListener: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val contactRowView = inflater.inflate(R.layout.contact_item_layout, parent, false)
        return ViewHolder(contactRowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contactName = getContactName(contacts[position])
        holder.contactNameTextView.text = contactName
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun setClickListener(listener: ClickListener) {
        clickListener = listener
    }

    private fun getContactName(contact: Contact): String {
        return contact.firstName + " " + contact.secondName
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val contactNameTextView: TextView
        override fun onClick(view: View) {
            clickListener!!.onClick(contacts[adapterPosition])
        }

        init {
            contactNameTextView = itemView.findViewById(R.id.contactNameView)
            itemView.setOnClickListener(this)
        }
    }

    interface ClickListener {
        fun onClick(contact: Contact)
    }

    init {
        Objects.requireNonNull(data)
        inflater = LayoutInflater.from(context)
        contacts = data
    }
}