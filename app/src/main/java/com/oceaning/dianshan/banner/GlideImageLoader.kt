package com.oceaning.dianshan.banner

import android.content.Context
import android.widget.ImageView
import com.kotlin.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 * Created by ankeranker on 2018/10/4.
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
        GlideUtils.loadImage(context,path.toString(),imageView)
    }
}