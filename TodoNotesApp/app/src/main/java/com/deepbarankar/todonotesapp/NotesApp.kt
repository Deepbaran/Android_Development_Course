package com.deepbarankar.todonotesapp

//Helps is using the instance of the database created in the NotesDatabase

import android.app.Application
import com.deepbarankar.todonotesapp.db.NotesDatabase

class NotesApp: Application() {
    //NotesApp is extending the Application class. This means that the lifecycle of the NotesApp class ends with the application
    override fun onCreate() {
        super.onCreate()
    }
    fun getNotesDb(): NotesDatabase {
        return NotesDatabase.getInstance(this)
    }
}