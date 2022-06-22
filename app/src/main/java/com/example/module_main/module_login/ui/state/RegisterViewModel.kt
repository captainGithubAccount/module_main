package com.example.module_login.ui.state

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import cn.leancloud.LCUser
import com.example.module_main.MainActivity

import com.example.module_main.R
import com.example.module_main.databinding.FragmentRegisterBinding
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class RegisterViewModel: ViewModel() {
    fun ivBackToLogin(view: View){
        view.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

    //注册按钮文本内容监听事件
    class EtChangedListener(private var _binding: FragmentRegisterBinding, private var _activity: Activity){

        private lateinit var _etUserNameText: String
        private lateinit var _etPasswordText: String
        private lateinit var _etConfirmPasswordText: String
        fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            _etUserNameText = _binding.etUserName.text.toString().trim()
            _etPasswordText = _binding.etPassword.text.toString().trim()
            _etConfirmPasswordText = _binding.etConfirmPassword.text.toString().trim()

            if(_etUserNameText.isNotEmpty() and _etPasswordText.isNotEmpty() and _etConfirmPasswordText.isNotEmpty() ){

                if(_etConfirmPasswordText.length == _etPasswordText.length){
                    if(_etPasswordText == _etConfirmPasswordText ){
                        //输入的账号密码不为空, 登录按钮设置为可用, Lottie View设为可见
                        _binding.btnRegisterJumpToMain.isEnabled = true
                    }else{
                        Toast.makeText(_activity, "密码不一致", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    //注册按钮点击事件
    class BtnRegisterListener(private var _binding: FragmentRegisterBinding, private var _activity: Activity){
        fun onClick(p0: View?) {
            _binding.ivlottieRegisterLoading.visibility = View.VISIBLE
            _binding.ivlottieRegisterLoading.let{
                it.repeatCount = 10
                it.playAnimation()
            }
            var userName = _binding.etUserName.text?.toString()?.trim()
            var userPassword = _binding.etPassword.text?.toString()?.trim()
            // 创建实例
            val user = LCUser()
            user.apply{
                username = userName
                password = userPassword
                signUpInBackground().subscribe(object : Observer<LCUser?> {
                    override fun onNext(user: LCUser) {
                        // 注册成功
                        Toast.makeText(_activity, "注册成功" + user.getObjectId(), Toast.LENGTH_SHORT)
                        LCUser.logIn(userName, userPassword).subscribe(object : Observer<LCUser?> {
                            override fun onSubscribe(disposable: Disposable) {}
                            override fun onError(throwable: Throwable) {
                                // 登录失败（可能是密码错误）
                                Toast.makeText(_activity, "登录失败" + throwable.message , Toast.LENGTH_SHORT).show()
                            }
                            override fun onComplete() {}
                            override fun onNext(t: LCUser) {
                                Toast.makeText(_activity, "登录成功" + t.objectId , Toast.LENGTH_SHORT).show()
                                // 登录成功
                                val intent = Intent(_activity, MainActivity::class.java)
                                _activity.startActivity(intent)
                                _activity.finish()
                            }
                        })
                    }
                    override fun onError(e: Throwable) {
                        Toast.makeText(_activity, "注册失败" + e.message, Toast.LENGTH_SHORT).show()
                    }
                    override fun onSubscribe(d: Disposable) {}
                    override fun onComplete() {}
                })
            }
        }
    }
}