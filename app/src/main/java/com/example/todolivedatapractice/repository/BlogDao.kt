package com.example.todolivedatapractice.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolivedatapractice.model.Blog

@Dao
interface BlogDao {


    @Query(" SELECT * FROM Blog")
    fun getAllData(): LiveData<List<Blog>>

//   @Query(" SELECT * FROM Blog WHERE id= id")
//    fun delete(id:Int)
    @Query("SELECT * FROM Blog WHERE id = :id")
    fun delete(id: Int): Blog
    @Insert
    fun insert(blog: Blog)

    @Update
    fun update(blog: Blog)
}
