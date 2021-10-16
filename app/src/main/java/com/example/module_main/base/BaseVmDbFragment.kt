package com.example.module_main.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

//自动注入viewmodel和databinding
abstract class BaseVmDbFragment<VM: ViewModel, DB: ViewDataBinding>: BaseVmFragment<VM>(){
    private var _binding: DB? = null
    val mBinding: DB get() = _binding!!




    //注意这里重写方法会直接覆盖BaseVmFragment，因此不用担心BaseVmFragme里onCreateView方法下实现的方法有影响
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //通过这种方式解决解决Android jetpack导航组件Navigation返回Fragment重走onCreateView方法刷新视图的问题

            _binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
            mBinding.lifecycleOwner = this
            lastView = mBinding.root

        return lastView
    }

    override fun onDestroy() {
        super.onDestroy()
        onFragmentDestroy()
        _binding = null
    }

    //- - - 注意以下两个方法除非是特殊需要否则直接覆盖后不执行操作即可!!!之所以把方法暴露出来是为了防止有特殊需求 ^.^

    /*
    * 在fragment销毁时执行的方法，其实就是onDestroy()罢了，只不过我们想要原来的onDestory()方法执行_binding = null操作而已
    * */
    abstract fun onFragmentDestroy()

    /*
    * 在fragment 贴附时执行的方法，其实就是onAttach()罢了，只不过我们想要原来的onAttach方法获取上下文对象罢了
    * */
    abstract override fun onFragmentAttach()

}