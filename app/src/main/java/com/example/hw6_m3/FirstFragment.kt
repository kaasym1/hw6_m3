package com.example.hw6_m3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw6_m3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var counter = 0
    private var btnPlus = ""
    private var btnMinus = ""
    private var btnSend = ""

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnPlus.setOnClickListener {
            updateCounter(1)
        }
        binding.btnMinus.setOnClickListener {
            updateCounter(-1)
        }
        binding.btnSend.setOnClickListener {
            sendCounter()
        }
    }

    private fun updateCounter(delta: Int) {
        val currentCounter = binding.tvCounter.text.toString().toIntOrNull() ?: 0
        binding.tvCounter.text = (currentCounter + delta).toString()
    }

    private fun sendCounter() {
        val counterValue = binding.tvCounter.text.toString().toIntOrNull() ?: 0
        val bundle = Bundle().apply {
            putInt("box", counterValue)
        }
        val secondFragment = SecondFragment().apply {
            arguments = bundle
        }
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, secondFragment)
            .addToBackStack(null)
            .commit()
    }
}

