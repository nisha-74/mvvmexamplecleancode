package com.example.todolivedatapractice.repository

import androidx.lifecycle.LiveData
import com.example.todolivedatapractice.model.Blog

class BlogRepository (private  val blogDao: BlogDao) {

    fun getAllData(): LiveData<List<Blog>>{
       return  blogDao.getAllData()
    }
     fun insertBlog(blog: Blog){
         blogDao.insert(blog)
     }
    fun updateBlog(blog: Blog){
        blogDao.update(blog)
    }
    fun delete(id:Int){
        blogDao.delete(id)

    }
}