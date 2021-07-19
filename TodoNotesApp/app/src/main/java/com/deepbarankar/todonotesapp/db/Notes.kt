package com.deepbarankar.todonotesapp.db

//DATA CLASS: It Defines the structure of the table we are creating

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//The annotation Entity takes the table name that we are going to define.
@Entity(tableName = "notesData")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "imagePath")
    var imagePath: String = "",

    @ColumnInfo(name = "isTaskCompleted")
    var isTaskCompleted: Boolean = false
)