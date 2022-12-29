package ru.sodovaya.fragmentexamples.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sodovaya.fragmentexamples.MainApp
import ru.sodovaya.fragmentexamples.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    var _binding : FragmentFourthBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentFourthBinding.inflate(layoutInflater)
        val root = binding.root

        return root
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}