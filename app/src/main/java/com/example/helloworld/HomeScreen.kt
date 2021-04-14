package com.example.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.helloworld.databinding.HomeFragmentBinding

class HomeScreen : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstNavigationButton.setOnClickListener { findNavController().navigate(R.id.action_homeScreen_to_firstScreen2) }
        binding.secondNavigationButton.setOnClickListener { findNavController().navigate(R.id.action_homeScreen_to_secondScreen2) }
        binding.thirdNavigationButton.setOnClickListener { findNavController().navigate(R.id.action_homeScreen_to_thirdScreen) }
    }
}