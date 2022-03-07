package com.example.module_login.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.module_login.ui.state.RegisterViewModel
import com.example.module_login.ui.state.RegisterViewModelFactory
import com.example.module_main.R
import com.example.module_main.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var _binding: FragmentRegisterBinding
    private val _registerViewModel: RegisterViewModel by viewModels {
        RegisterViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        _binding.let {
            it.lifecycleOwner = this.requireActivity()
            it.registerViewModel = _registerViewModel


            it.btnRegisterListener = RegisterViewModel.BtnRegisterListener(it, requireActivity())
            it.etChangedListener = RegisterViewModel.EtChangedListener(it, requireActivity())
            it.ivlottieRegisterLoading.visibility = View.GONE
            it.btnRegisterJumpToMain.isEnabled = false
        }

        return _binding.root
    }
}