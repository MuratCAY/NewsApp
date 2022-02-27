package com.muratcay.newsapp.ui.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.muratcay.newsapp.R
import com.muratcay.newsapp.databinding.FragmentSplashBinding
import com.muratcay.newsapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigatedToHome()
    }

    private fun navigatedToHome() {
        binding.appCompatButton.setOnClickListener {
            val action = SplashFragmentDirections.actionSplashFragmentToNewsFragment()
            findNavController().navigate(action)
        }
    }

    override fun getFragmentView() = R.layout.fragment_splash
}