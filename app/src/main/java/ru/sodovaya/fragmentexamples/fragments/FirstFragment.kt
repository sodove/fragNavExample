package ru.sodovaya.fragmentexamples.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.sodovaya.fragmentexamples.data.ExampleVM
import ru.sodovaya.fragmentexamples.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    var _binding: FragmentFirstBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater)

        val viewModel = ViewModelProvider(requireActivity())[ExampleVM::class.java]
        viewModel.observable.observe(viewLifecycleOwner) { randomNumber ->
            if (randomNumber != null)
                binding.textView.text = randomNumber.toString()
        }

        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}