package ru.sodovaya.fragmentexamples.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import ru.sodovaya.fragmentexamples.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    var _binding: FragmentSecondBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        val root = binding.root

        val webview = binding.webView
        webview.settings.javaScriptEnabled = true

        if(WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(webview.settings, WebSettingsCompat.FORCE_DARK_ON);
        }

        webview.loadUrl("https://clmty.ru/")


        return root
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}