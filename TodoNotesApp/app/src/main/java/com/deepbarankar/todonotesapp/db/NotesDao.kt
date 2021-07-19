package com.deepbarankar.todonotesapp.db

//It has functions for CRUD operations that a activity can perform

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

//Data Access Objects - DAOs : Helps is accessing the data
//DAO helps to work with data. It is an interface that helps us communicate from the view to the database
@Dao
interface NotesDao{

    @Query("SELECT * FROM notesData")
    fun getAll(): List<Notes>

    @Insert(onConflict = REPLACE)
    fun insert(notes: Notes)

    @Update
    fun update(notes: Notes)

    @Delete
    fun delete(notes: Notes)
}