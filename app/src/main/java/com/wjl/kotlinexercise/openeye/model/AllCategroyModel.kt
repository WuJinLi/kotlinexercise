package com.wjl.kotlinexercise.openeye.model

/**
 * @author: wujinli
 * @date:2018/10/16
 * @desc:
 */
class AllCategroyModel {

    var count: Int = 0
    var total: Int = 0
    var nextPageUrl: Any? = null
    var isAdExist: Boolean = false
    var itemList: List<ItemListBean>? = null

    class ItemListBean {

        var type: String? = null
        var data: DataBean? = null
        var tag: Any? = null
        var id: Int = 0
        var adIndex: Int = 0

        class DataBean {

            var dataType: String? = null
            var id: Int = 0
            var title: String? = null
            var image: String? = null
            var actionUrl: String? = null
            var isShade: Boolean = false
            var adTrack: Any? = null
        }
    }
}
