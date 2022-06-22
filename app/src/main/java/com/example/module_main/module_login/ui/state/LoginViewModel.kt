package com.example.module_login.ui.state
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import cn.leancloud.LCUser
import com.example.module_main.MainActivity
import com.example.module_main.R
import com.example.module_main.databinding.FragmentLoginBinding
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var binding: FragmentLoginBinding


    private val _context: Context
    init {
        _context = application.applicationContext

    }

    fun tvRegisterJumpToRegisterPage(view: View){
        view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    //登录按钮点击事件
    class BtnLoginListener(private var _binding: FragmentLoginBinding, private var _activity: Activity){
        fun onClick(p0: View?) {
            _binding.ivlottieLoginLoading.visibility = View.VISIBLE
            _binding.ivlottieLoginLoading.let{
                it.repeatCount = 10
                it.playAnimation()
            }
            val userName = _binding.etUserName.text?.trim().toString()
            val userPassword = _binding.etPassword.text?.trim().toString()
            LCUser.logIn(userName, userPassword).subscribe(object :
                Observer<LCUser?> {
                override fun onSubscribe(disposable: Disposable) {}
                override fun onError(throwable: Throwable) {
                    // 登录失败（可能是密码错误）
                    Toast.makeText(_activity, "登录失败" + throwable.message, Toast.LENGTH_SHORT).show()
                }
                override fun onComplete() {}
                override fun onNext(t: LCUser) {
                    Toast.makeText(_activity, "登录成功", Toast.LENGTH_SHORT).show()
                    // 登录成功
                    val intent = Intent(_activity, MainActivity::class.java)
                    _activity.startActivity(intent)
                    _activity.finish()
                }
            })
        }
    }

    //EditText文本变化监听事件
    class TextWatcherListener(private var _binding: FragmentLoginBinding){

        private lateinit var _etUserNameText: String
        private lateinit var _etPasswordText: String

        fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            _etUserNameText = _binding.etUserName.text?.trim().toString()
            _etPasswordText = _binding.etPassword.text?.trim().toString()

            if(_etUserNameText.isNotEmpty() and _etPasswordText.isNotEmpty()){
                //输入的账号密码不为空, 登录按钮设置为可用, Lottie View设为可见
                _binding.btnLoginJumpToMain.isEnabled = true
            }
        }
    }

}