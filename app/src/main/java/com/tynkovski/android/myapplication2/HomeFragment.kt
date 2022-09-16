package com.tynkovski.android.myapplication2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.tynkovski.android.myapplication2.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val navigationController by lazy { findNavController(binding.root) }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        colorStatusBar()
        colorNavigationBar()

        binding.buttonGoSettings.setOnClickListener {
            navigationController.navigate(R.id.navHome_to_navSettings)
        }
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