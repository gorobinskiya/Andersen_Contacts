package com.example.contactsapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.random.Random.Default.nextInt

class ContactListFragment : Fragment(R.layout.contact_list_layout) {

    private lateinit var itemNameClickListener: OnItemNameClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        itemNameClickListener = context as OnItemNameClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactList = mutableListOf<Contact>().apply {
            repeat(150) {
                add(
                    Contact(
                        "${UUID.randomUUID()}",
                        "${UUID.randomUUID()}",
                        "${UUID.randomUUID()}",
                        (0..80).random()
                    )
                )
            }
        }

        val contactListView = view.findViewById<RecyclerView>(R.id.contactsRecycleView)
        contactListView.layoutManager = LinearLayoutManager(context);
        val contactListAdapter = ContactListRecyclerViewAdapter(
            contactList,
            { itemNameClickListener.OnItemNameClicked(it) })

        contactListView.adapter = contactListAdapter
    }

    interface OnItemNameClickListener {
        fun OnItemNameClicked(contact: Contact)
    }

    companion object {
        fun newInstance() = ContactListFragment()

        const val TAG = "FRAGMENTS_CONTACT_TAG"
    }
}