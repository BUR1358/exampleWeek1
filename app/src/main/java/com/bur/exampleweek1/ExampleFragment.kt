package com.bur.exampleweek1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bur.exampleweek1.databinding.FragmentExampleBinding


class ExampleFragment : Fragment() {
    lateinit var binding: FragmentExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentExampleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }
}