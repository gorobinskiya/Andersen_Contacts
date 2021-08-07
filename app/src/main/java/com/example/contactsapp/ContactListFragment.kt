package com.example.contactsapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment: Fragment(R.layout.contact_list_layout){

    private lateinit var  itemNameClickListener: OnItemNameClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        itemNameClickListener = context as OnItemNameClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactList = listOf(
            Contact("Андрей", "Горобинский", "+3806381718"),
            Contact("Юра", "Петров", "+3809675802"),
            Contact("Александр", "Шалыгин", "+38063752102"),
            Contact("Дмитрий", "Кривенко", "+3809672142")
        )

        val contactListView = view.findViewById<RecyclerView>(R.id.contactsRecycleView)
        contactListView.layoutManager = LinearLayoutManager(context);
        val contactListAdapter = ContactListRecyclerViewAdapter(context, contactList)
        val clickListener = object : ContactListRecyclerViewAdapter.ClickListener {
            override fun onClick(contact: Contact) {
                itemNameClickListener.OnItemNameClicked(contact)
            }
        }

        contactListAdapter.setClickListener(clickListener)
        contactListView.adapter = contactListAdapter;

    }

    interface OnItemNameClickListener {
        fun OnItemNameClicked(contact: Contact)
    }

    companion object {
        fun newInstance() = ContactListFragment()

        const val TAG = "FRAGMENTS_CONTACT_TAG"
    }
}