package com.example.helloworld

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.helloworld.databinding.SecondScreenBinding

class SecondScreen : Fragment() {

    private var _binding: SecondScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = SecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as? MainActivity
        activity?.setSupportActionBar(binding.toolbar2)
        activity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)

        binding.button5.setOnClickListener {
            hideMyKeyboard(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        val activity = activity as? MainActivity
        activity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(false)
        super.onDestroyView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = activity as? MainActivity
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else
            -> super.onOptionsItemSelected(item)
        }
    }

    private fun hideMyKeyboard(view: View) {
        val hideMe = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideMe.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
