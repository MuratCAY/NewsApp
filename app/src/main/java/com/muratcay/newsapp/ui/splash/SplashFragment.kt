package com.muratcay.newsapp.ui.splash

import com.muratcay.newsapp.R
import com.muratcay.newsapp.databinding.FragmentSplashBinding
import com.muratcay.newsapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun getFragmentView() = R.layout.fragment_splash
}