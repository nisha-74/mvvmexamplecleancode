package com.example.todolivedatapractice.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.todolivedatapractice.R
import com.example.todolivedatapractice.databinding.FragmentHomeFragmentBinding
import com.example.todolivedatapractice.view.adpter.BlogAdpter
import com.example.todolivedatapractice.viewmodel.BlogViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

  private  lateinit var dataBinding: FragmentHomeFragmentBinding
    val viewModel: BlogViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= FragmentHomeFragmentBinding.inflate(layoutInflater, container, false)

        dataBinding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addFragment)
        }

        viewModel.getAllData().observe(viewLifecycleOwner , {
            blokList ->
              dataBinding.recylarview.layoutManager= GridLayoutManager(requireContext(), 2)
            dataBinding.recylarview.adapter=  BlogAdpter(requireContext(), blokList)



        })

        return  dataBinding.root
    }

}