package com.example.todolivedatapractice.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.todolivedatapractice.R
import com.example.todolivedatapractice.databinding.FragmentAddBinding
import com.example.todolivedatapractice.model.Blog
import com.example.todolivedatapractice.viewmodel.BlogViewModel

class addFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    val viewModel: BlogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        binding.saveBtn.setOnClickListener {
            insertData(it)
        }
        return binding.root

    }

    private fun insertData(it: View?) {

        val name= binding.name.text.toString()
        val title= binding.title.text.toString()
        val subTitle= binding.description.text.toString()

        val data= Blog(
            null,
            name= name,
            title= title,
            description =  subTitle

        )
        Log.d("Data", data.toString());

        viewModel.insertData(data)
    }
}