package com.wjl.kotlinexercise.openeye.bean

import java.io.Serializable

/**
 * author: WuJinLi
 * time  : 2018/10/15
 * desc  :
 */
data class CategroyBean(val count: Int, var total: Int, var nextPageUrl: Any?, var isAdExist: Boolean = false, var itemList: List<ItemListBean>) : Serializable {

    /**
     * itemList : [{"type":"briefCard","data":{"dataType":"BriefCard","id":14,"icon":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","iconType":"square","title":"#广告","subTitle":null,"description":"为广告人的精彩创意点赞","actionUrl":"eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A","adTrack":null,"follow":{"itemType":"category","itemId":14,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":36,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","iconType":"square","title":"#生活","subTitle":null,"description":"匠心、健康、生活感悟","actionUrl":"eyepetizer://category/36/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"follow":{"itemType":"category","itemId":36,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":10,"icon":"http://img.kaiyanapp.com/482c741c06644f5566c7218096dbaf26.jpeg","iconType":"square","title":"#动画","subTitle":null,"description":"有趣的人永远不缺童心","actionUrl":"eyepetizer://category/10/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"follow":{"itemType":"category","itemId":10,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":28,"icon":"http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg","iconType":"square","title":"#搞笑","subTitle":null,"description":"哈哈哈哈哈哈哈哈","actionUrl":"eyepetizer://category/28/?title=%E6%90%9E%E7%AC%91","adTrack":null,"follow":{"itemType":"category","itemId":28,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":4,"icon":"http://img.kaiyanapp.com/5817f1bfdce61130204a24268160b619.jpeg","iconType":"square","title":"#开胃","subTitle":null,"description":"眼球和味蕾，一个都不放过","actionUrl":"eyepetizer://category/4/?title=%E5%BC%80%E8%83%83","adTrack":null,"follow":{"itemType":"category","itemId":4,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":2,"icon":"http://img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg","iconType":"square","title":"#创意","subTitle":null,"description":"技术与审美结合，探索视觉的无限可能","actionUrl":"eyepetizer://category/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"follow":{"itemType":"category","itemId":2,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":18,"icon":"http://img.kaiyanapp.com/c746d56db089909b1cdd933fa7c98ef8.jpeg","iconType":"square","title":"#运动","subTitle":null,"description":"冲浪、滑板、跑酷、骑行，生命停不下来","actionUrl":"eyepetizer://category/18/?title=%E8%BF%90%E5%8A%A8","adTrack":null,"follow":{"itemType":"category","itemId":18,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":20,"icon":"http://img.kaiyanapp.com/9279c17b4da5ba5e7e4f21afb5bb0a74.jpeg","iconType":"square","title":"#音乐","subTitle":null,"description":"汇聚全球最新、最优质的音乐视频","actionUrl":"eyepetizer://category/20/?title=%E9%9F%B3%E4%B9%90","adTrack":null,"follow":{"itemType":"category","itemId":20,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":26,"icon":"http://img.kaiyanapp.com/ac6971c1b9fc942c7547d25fc6c60ad2.jpeg","iconType":"square","title":"#萌宠","subTitle":null,"description":"来自汪星、喵星、蠢萌星的你","actionUrl":"eyepetizer://category/26/?title=%E8%90%8C%E5%AE%A0","adTrack":null,"follow":{"itemType":"category","itemId":26,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":12,"icon":"http://img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg","iconType":"square","title":"#剧情","subTitle":null,"description":"用一个好故事，描绘生活的不可思议","actionUrl":"eyepetizer://category/12/?title=%E5%89%A7%E6%83%85","adTrack":null,"follow":{"itemType":"category","itemId":12,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":32,"icon":"http://img.kaiyanapp.com/0117b9108c7cff43700db8af5e24f2bf.jpeg","iconType":"square","title":"#科技","subTitle":null,"description":"每天获得新知识","actionUrl":"eyepetizer://category/32/?title=%E7%A7%91%E6%8A%80","adTrack":null,"follow":{"itemType":"category","itemId":32,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":6,"icon":"http://img.kaiyanapp.com/75bc791c5f6cc239d6056e0a52d077fd.jpeg?imageMogr2/quality/60/format/jpg","iconType":"square","title":"#旅行","subTitle":null,"description":"发现世界的奇妙和辽阔","actionUrl":"eyepetizer://category/6/?title=%E6%97%85%E8%A1%8C","adTrack":null,"follow":{"itemType":"category","itemId":6,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":8,"icon":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","iconType":"square","title":"#影视","subTitle":null,"description":"电影、剧集、戏剧抢先看","actionUrl":"eyepetizer://category/8/?title=%E5%BD%B1%E8%A7%86","adTrack":null,"follow":{"itemType":"category","itemId":8,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":22,"icon":"http://img.kaiyanapp.com/a2fc6d32ac0b4f2842fb3d545d06f09b.jpeg","iconType":"square","title":"#记录","subTitle":null,"description":"告诉他们为什么与众不同","actionUrl":"eyepetizer://category/22/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"follow":{"itemType":"category","itemId":22,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":30,"icon":"http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg","iconType":"square","title":"#游戏","subTitle":null,"description":"欢迎来到惊险刺激的新世界","actionUrl":"eyepetizer://category/30/?title=%E6%B8%B8%E6%88%8F","adTrack":null,"follow":{"itemType":"category","itemId":30,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":38,"icon":"http://img.kaiyanapp.com/9f4c1559d54d4274e5463fba4262b284.jpeg","iconType":"square","title":"#综艺","subTitle":null,"description":"全球网红在表演什么","actionUrl":"eyepetizer://category/38/?title=%E7%BB%BC%E8%89%BA","adTrack":null,"follow":{"itemType":"category","itemId":38,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":24,"icon":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","iconType":"square","title":"#时尚","subTitle":null,"description":"优雅地行走在潮流尖端","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","adTrack":null,"follow":{"itemType":"category","itemId":24,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1},{"type":"briefCard","data":{"dataType":"BriefCard","id":34,"icon":"http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg","iconType":"square","title":"#集锦","subTitle":null,"description":"最好的部分 + 有化学反应的混剪","actionUrl":"eyepetizer://category/34/?title=%E9%9B%86%E9%94%A6","adTrack":null,"follow":{"itemType":"category","itemId":34,"followed":false},"ifPgc":false},"tag":null,"id":0,"adIndex":-1}]
     * count : 18
     * total : 0
     * nextPageUrl : null
     * adExist : false
     */


    class ItemListBean(var type: String, var data: DataBean, var tag: Any, var id: Int = 0, var adIndex: Int = 0) : Serializable {
        /**
         * type : briefCard
         * data : {"dataType":"BriefCard","id":14,"icon":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","iconType":"square","title":"#广告","subTitle":null,"description":"为广告人的精彩创意点赞","actionUrl":"eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A","adTrack":null,"follow":{"itemType":"category","itemId":14,"followed":false},"ifPgc":false}
         * tag : null
         * id : 0
         * adIndex : -1
         */


        class DataBean(var dataType: String, var id: Int = 0, var icon: String, var iconType: String, var title: String, var subTitle: Any, var description: String, var actionUrl: String, var adTrack: Any, var follow: FollowBean, var isIfPgc: Boolean = false) : Serializable {
            /**
             * dataType : BriefCard
             * id : 14
             * icon : http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg
             * iconType : square
             * title : #广告
             * subTitle : null
             * description : 为广告人的精彩创意点赞
             * actionUrl : eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A
             * adTrack : null
             * follow : {"itemType":"category","itemId":14,"followed":false}
             * ifPgc : false
             */


            class FollowBean(var itemType: String, var itemId: Int = 0, var isFollowed: Boolean = false) : Serializable {
                /**
                 * itemType : category
                 * itemId : 14
                 * followed : false
                 */

            }
        }
    }
}
