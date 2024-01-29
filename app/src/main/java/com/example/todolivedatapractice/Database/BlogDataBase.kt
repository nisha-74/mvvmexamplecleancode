package com.example.todolivedatapractice.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolivedatapractice.model.Blog
import com.example.todolivedatapractice.repository.BlogDao
import com.example.todolivedatapractice.viewmodel.BlogViewModel


@Database (entities = [Blog::class], version = 1, exportSchema = false)
abstract  class BlogDataBase: RoomDatabase() {
   abstract fun BlogDao(): BlogDao
   companion object{
        var INSTANCE: BlogDataBase ?= null;
        fun getDataBase(context: Context): BlogDataBase{
            val tempInstance= INSTANCE;
            if(tempInstance!= null){
                return INSTANCE!!;
            }
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                   BlogDataBase::class.java,
                    "Blog"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }

}