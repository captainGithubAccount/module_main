package com.example.module_login.ui.page

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.module_login.ui.state.LoginViewModel
import com.example.module_login.ui.state.LoginViewModelFactory
import com.example.module_main.R
import com.example.module_main.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var _activity: AppCompatActivity

    lateinit var binding: FragmentLoginBinding
    private val _loginViewModel: LoginViewModel by viewModels{
        LoginViewModelFactory(activity?.application!!)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding?.let {
            it.ivlottieLoginLoading?.visibility = View.GONE
            it.btnLoginJumpToMain.isEnabled = false

            it.lifecycleOwner = this.requireActivity()
            it.loginViewModel = _loginViewModel
            it.loginTextListener = LoginViewModel.TextWatcherListener(it)
            it.loginBtnListener = LoginViewModel.BtnLoginListener(it, requireActivity())


        }
        return binding.root

    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //支持导航到AddFragment碎片时, 回退键头出现
//        val navController = findNavController()
//        NavigationUI.setupActionBarWithNavController(activity as AppCompatActivity, navController)
    }


}