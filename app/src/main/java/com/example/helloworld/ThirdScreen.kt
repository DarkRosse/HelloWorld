package com.example.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.helloworld.databinding.ThirdScreenBinding

class ThirdScreen : Fragment() {

    private lateinit var binding: ThirdScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ThirdScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbarThirdScreen)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onCheckedTools(view: View) {
        if (view is CheckBox) {
            val checkBox: CheckBox = binding.checkBox
            if (checkBox.isChecked) {
                binding.checkTextTwo.visibility = View.VISIBLE
                binding.checkTextThree.visibility = View.VISIBLE
                binding.checkBox2.visibility = View.VISIBLE
                binding.checkBox3.visibility = View.VISIBLE
            } else {
                binding.checkTextTwo.visibility = View.INVISIBLE
                binding.checkTextThree.visibility = View.INVISIBLE
                binding.checkBox2.visibility = View.INVISIBLE
                binding.checkBox3.visibility = View.INVISIBLE
            }
        }
    }

    private fun onCheckedRadio(view: View) {
        if (view is CheckBox) {
            val checkBox: CheckBox = binding.checkBox2
            if (checkBox.isChecked) {
                binding.radioText.visibility = View.VISIBLE
                binding.radioGroup.visibility = View.VISIBLE
            } else {
                binding.radioText.visibility = View.INVISIBLE
                binding.radioGroup.visibility = View.INVISIBLE
            }
        }
    }

    private fun onCheckedSlider(view: View) {
        if (view is CheckBox) {
            val checkBox: CheckBox = binding.checkBox3
            if (checkBox.isChecked) {
                binding.sliderText.visibility = View.VISIBLE
                binding.seekBar.visibility = View.VISIBLE
            } else {
                binding.sliderText.visibility = View.INVISIBLE
                binding.seekBar.visibility = View.INVISIBLE
            }
        }
    }
}
