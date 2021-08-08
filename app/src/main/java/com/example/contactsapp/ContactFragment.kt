package com.example.contactsapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ContactFragment : Fragment(R.layout.contact_layout) {

    lateinit var displayMessage: Contact

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMessage = arguments?.getSerializable("message") as Contact

        view.findViewById<TextView>(R.id.textView).text = displayMessage.toString()

        Glide.with(requireContext()).load(displayMessage.imageUrl)
            .into(view.findViewById<ImageView>(R.id.imageView))
    }

    companion object {
        fun newInstance(contact: Contact) = ContactFragment().apply {
            arguments = Bundle().apply {
                putSerializable("message", contact)
            }
        }

        const val TAG = "FRAGMENT_CONTACT_TAG"
    }
}