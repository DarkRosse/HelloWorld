package com.example.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.helloworld.databinding.ThirdScreenBinding

class ThirdScreen : Fragment() {

    private var _binding: ThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as? MainActivity
        activity?.setSupportActionBar(binding.toolbar3)
        activity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)

        binding.checkBox.setOnClickListener {
            onCheckedTools(it)
        }
        binding.checkBox2.setOnClickListener {
            onCheckedRadio(it)
        }
        binding.checkBox3.setOnClickListener {
            onCheckedSlider(it)
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

    private fun onCheckedTools(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.checkBox -> {
                    if (checked) {
                        binding.textView9.visibility = View.VISIBLE
                        binding.textView10.visibility = View.VISIBLE
                        binding.checkBox2.visibility = View.VISIBLE
                        binding.checkBox3.visibility = View.VISIBLE
                    } else {
                        binding.textView9.visibility = View.INVISIBLE
                        binding.textView10.visibility = View.INVISIBLE
                        binding.checkBox2.visibility = View.INVISIBLE
                        binding.checkBox3.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }

    private fun onCheckedRadio(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.checkBox2 -> {
                    if (checked) {
                        binding.textView4.visibility = View.VISIBLE
                        binding.radioGroup.visibility = View.VISIBLE
                    } else {
                        binding.textView4.visibility = View.INVISIBLE
                        binding.radioGroup.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }

    private fun onCheckedSlider(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.checkBox3 -> {
                    if (checked) {
                        binding.textView7.visibility = View.VISIBLE
                        binding.radioGroup2.visibility = View.VISIBLE
                    } else {
                        binding.textView7.visibility = View.INVISIBLE
                        binding.radioGroup2.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }
}
