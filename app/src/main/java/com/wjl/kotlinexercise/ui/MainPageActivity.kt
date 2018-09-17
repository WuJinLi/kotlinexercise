package com.wjl.kotlinexercise.ui

import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.refresh.RefreshActivity
import com.wjl.kotlinexercise.ui.fragment.HomeFragment
import com.wjl.kotlinexercise.ui.fragment.KnowledgeTreeFragment
import com.wjl.kotlinexercise.ui.fragment.NavigationFragment
import com.wjl.kotlinexercise.ui.fragment.ProjectFragment
import com.wjl.kotlinexercise.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.ac_main_page.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  :
 */
class MainPageActivity : BaseActivity() {

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_KNOWLEDGE = 0x02
    private val FRAGMENT_NAVIGATION = 0x03
    private val FRAGMENT_PROJECT = 0x04

    private var mIndex=FRAGMENT_HOME


    private var mHomeFragment: HomeFragment? = null
    private var mKnowledgeTreeFragment: KnowledgeTreeFragment? = null
    private var mNavigationFragment: NavigationFragment? = null
    private var mProjectFragment: ProjectFragment? = null

    override fun attachLayoutRes(): Int = R.layout.ac_main_page

    override fun initData() {
    }

    override fun initViews() {

        bottomnavigationview.run {
            BottomNavigationViewHelper.disableShiftMode(bottomnavigationview)
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }

        showFragment(mIndex)

    }

    override fun initListener() {

    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener when (item.itemId) {
            R.id.action_home -> {
                showFragment(FRAGMENT_HOME)
                true
            }

            R.id.action_knowledge_system -> {
                showFragment(FRAGMENT_KNOWLEDGE)
                true
            }

            R.id.action_navigation -> {
                showFragment(FRAGMENT_NAVIGATION)
                true
            }

            R.id.action_project -> {
                showFragment(FRAGMENT_PROJECT)
                true
            }
            else -> {
                false
            }
        }
    }


    /**
     * 显示导航栏按钮
     */
    private fun showFragment(index: Int) {
        var transaction=supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex=index

        when(index){
            FRAGMENT_HOME->{
                if (mHomeFragment==null){
                    mHomeFragment=HomeFragment.getInstance()
                    transaction.add(R.id.container,mHomeFragment,"home")
                }else{
                    transaction.show(mHomeFragment)
                }
            }

            FRAGMENT_KNOWLEDGE->{
                if (mKnowledgeTreeFragment==null){
                    mKnowledgeTreeFragment= KnowledgeTreeFragment.getInstance()
                    transaction.add(R.id.container,mKnowledgeTreeFragment,"know")
                }else{
                    transaction.show(mKnowledgeTreeFragment)
                }
            }


            FRAGMENT_NAVIGATION->{
                if (mNavigationFragment==null){
                    mNavigationFragment=NavigationFragment.getInstance()
                    transaction.add(R.id.container,mNavigationFragment,"navigation")
                }else{
                    transaction.show(mNavigationFragment)
                }
            }


            FRAGMENT_PROJECT->{
                if (mProjectFragment==null){
                    mProjectFragment= ProjectFragment.getInstance()
                    transaction.add(R.id.container,mProjectFragment,"project")
                }else{
                    transaction.show(mProjectFragment)
                }
            }

        }
        transaction.commit()
    }

    /**
     * 隐藏导航栏按钮
     */
    private fun hideFragments(transaction:FragmentTransaction){
        mHomeFragment?.let { transaction.hide(it)}
        mKnowledgeTreeFragment?.let { transaction.hide(it) }
        mNavigationFragment?.let { transaction.hide(it) }
        mProjectFragment?.let { transaction.hide(it) }
    }


    override fun onDestroy() {
        super.onDestroy()
        mHomeFragment=null
        mKnowledgeTreeFragment=null
        mNavigationFragment=null
        mProjectFragment=null
    }
}