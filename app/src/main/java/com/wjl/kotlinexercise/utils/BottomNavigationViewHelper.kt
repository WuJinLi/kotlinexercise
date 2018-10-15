package com.wjl.kotlinexercise.utils

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 解决使用BottomNavigationView item大于三个出item的隐藏的问题
 */
class BottomNavigationViewHelper {

    companion object {
        @SuppressLint("RestrictedApi")
        fun disableShiftMode(view: BottomNavigationView) {
            var menuView: BottomNavigationMenuView = view.getChildAt(0) as BottomNavigationMenuView
            try {
                var shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
                shiftingMode.isAccessible = true
                shiftingMode.setBoolean(menuView, false)
                shiftingMode.isAccessible = false
                var i = 0
                do {
                    var item: BottomNavigationItemView = menuView.getChildAt(i) as BottomNavigationItemView
//                    item.setShiftingMode(false)
                    item.setChecked(item.itemData.isChecked)
                    i++
                } while (i < menuView.childCount)
            } catch (e: NoSuchFieldException) {
                Log.e("BNVHelper", "Unable to get shift mode field", e);
            } catch (e: IllegalAccessException) {
                Log.e("BNVHelper", "Unable to change value of shift mode", e);
            }
        }
    }
}