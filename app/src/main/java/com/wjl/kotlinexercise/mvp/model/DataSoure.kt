package com.wjl.kotlinexercise.mvp.model

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  :
 */


data class HttpResult<T>(val data: T,
                         val errorCode: Int,
                         val errorMsg: String)

data class BannerList(val data: List<Banner>)
data class Banner(val desc: String,
                  val id: Int,
                  val imagePath: String,
                  val isVisible: Int,
                  val order: Int,
                  val title: String,
                  val type: Int,
                  val url: String)


/**
 * 文章数据返回实体类
 */
data class ArticleResponse(val datas: List<Article>,
                           val offset: Int,
                           val over: Boolean,
                           val pageCount: Int,
                           val size: Int,
                           val total: Int)

//文章
data class Article(
        val apkLink: String,
        val author: String,
        val chapterId: Int,
        val chapterName: String,
        var collect: Boolean,
        val courseId: Int,
        val desc: String,
        val envelopePic: String,
        val fresh: Boolean,
        val id: Int,
        val link: String,
        val niceDate: String,
        val origin: String,
        val projectLink: String,
        val publishTime: Long,
        val superChapterId: Int,
        val superChapterName: String,
        val tags: MutableList<Tag>,
        val title: String,
        val type: Int,
        val userId: Int,
        val visible: Int,
        val zan: Int
)

/**
 * 文章tag
 */
data class Tag(val name: String,
               val url: String)