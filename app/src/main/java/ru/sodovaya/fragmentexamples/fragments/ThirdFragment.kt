package ru.sodovaya.fragmentexamples.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.sodovaya.fragmentexamples.data.AnimeViewModel
import ru.sodovaya.fragmentexamples.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    var _binding: FragmentThirdBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentThirdBinding.inflate(layoutInflater)
        val root = binding.root

        val animeModel = ViewModelProvider(requireActivity())[AnimeViewModel::class.java]

        return root
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}