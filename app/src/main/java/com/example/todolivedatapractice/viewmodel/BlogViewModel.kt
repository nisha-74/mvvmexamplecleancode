package com.example.todolivedatapractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todolivedatapractice.Database.BlogDataBase
import com.example.todolivedatapractice.model.Blog
import com.example.todolivedatapractice.repository.BlogRepository

class BlogViewModel(application: Application): AndroidViewModel(application){

     private val repository: BlogRepository

    init {
       val  dao = BlogDataBase.getDataBase(application).BlogDao()
        repository= BlogRepository(dao);
  }


   fun insertData(blog: Blog){
       repository.insertBlog(blog)
   }
    fun  upDateData(blog: Blog){
        repository.updateBlog(blog)
    }
    fun  deleteData(id:Int){
        repository.delete(id)
    }
    fun getAllData() : LiveData<List<Blog>> = repository.getAllData()
}