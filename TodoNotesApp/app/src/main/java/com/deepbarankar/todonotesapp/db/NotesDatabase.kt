package com.deepbarankar.todonotesapp.db

//Create a instance of the database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database takes the entities that we created and we need to pass a version of the entity
//This is how we add the tables to create a database in Room
@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        //this is equivalent to public static
        lateinit var INSTANCE: NotesDatabase

        //lateinit is a variable that the developer is sure that it will not be null but is not initialized right away. Hence, it's late initialization.
        fun getInstance(context: Context): NotesDatabase {
            synchronized(NotesDatabase::class) {
                //Anything inside the synchronized block can be accessed by a single thread at a time.
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "my-notes.db"
                )
                    .allowMainThreadQueries()
                    .build()
                /*
                As a better practice it is recommended to run the queries in the background thread for a easy execution of the app.
                 */
            }
            return INSTANCE
        }
    }
}