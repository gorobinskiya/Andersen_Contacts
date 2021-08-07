package com.example.contactsapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ContactFragment: Fragment(R.layout.contact_layout) {

    lateinit var  displayMessage: Contact

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMessage = arguments?.getSerializable("message") as Contact

        view.findViewById<TextView>(R.id.textView).text = displayMessage.toString()

        return
    }

    companion object{
        fun newInstance(contact: Contact): ContactFragment{
            val fragmentContact = ContactFragment()
            val bundle = Bundle()
            bundle.putSerializable("message",contact)
            fragmentContact.arguments = bundle
            //fragmentContact.arguments?.putSerializable("message", contact)
            return fragmentContact
        }

        const val TAG = "FRAGMENT_CONTACT_TAG"
    }
}