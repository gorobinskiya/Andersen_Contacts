package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ContactListFragment.OnItemNameClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            val fragmentContacts = ContactListFragment.newInstance()
            replace(R.id.frameLayout, fragmentContacts, ContactListFragment.TAG)
            this.commit()
        }

    }

    override fun OnItemNameClicked(contact: Contact) {
        supportFragmentManager.beginTransaction().run {
            val fragmentContact = ContactFragment.newInstance(contact)
            replace(R.id.frameLayout, fragmentContact, ContactFragment.TAG)
            addToBackStack(ContactFragment.TAG)
            this.commit()
        }
    }
}