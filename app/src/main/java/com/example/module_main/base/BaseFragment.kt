package com.example.module_main.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM: ViewModel, DB: ViewDataBinding>: BaseVmDbFragment<VM, DB>(){

    /**
     * 当前Fragment绑定的视图布局
     */
    abstract override fun layoutId(): Int


    /**
     * Fragment执行onViewCreated后触发,可以初始化如容器转换的设置,如果没有容器转换或fragment的进出动画要设置可以不初始化这个方法内容
     * 在initBinding方法前调用
     */
    abstract override fun initBeforeBinding(savedInstanceState: Bundle?)

    /*
    * 初始化绑定事件
    * */
    abstract override fun initBinding(savedInstanceState: Bundle?)

    /*
    * 初始化除了绑定操作外用户想自己定义的内容
    * 在initBinding方法后调用
    * */
    abstract override fun initAfterBinding(savedInstanceState: Bundle?)
}
