package com.tynkovski.android.myapplication2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.tynkovski.android.myapplication2.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private val navigationController by lazy { Navigation.findNavController(binding.root) }

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        colorStatusBar()
        colorNavigationBar()
    }

    private fun colorStatusBar() {
        val bg = _binding?.toolbar?.background
        _binding?.statusBarFill?.background = bg
    }

    private fun colorNavigationBar() {
        val bg = _binding?.bottomNav?.background
        _binding?.navigationBarFill?.background = bg
    }
}