package com.example.todolivedatapractice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Blog")
data class Blog(
    @PrimaryKey(autoGenerate = true)
    var id:Int?= null,
    var name: String,
    var title: String,
    var description: String
)
