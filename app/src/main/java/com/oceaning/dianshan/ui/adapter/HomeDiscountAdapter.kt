package com.oceaning.dianshan.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.widget.TextView
import com.kotlin.base.utils.GlideUtils
import com.oceaning.dianshan.R
import com.oceanwing.eufylife.adapter.BaseRecyclerAdapter
import com.oceanwing.eufylife.adapter.viewholder.BaseViewHolder

/**
 * Created by ankeranker on 2018/10/4.
 */
class HomeDiscountAdapter(context: Context,data:MutableList<String>,layoutID:Int) :BaseRecyclerAdapter<String>(context,data,layoutID) {
    override fun convert(holder: BaseViewHolder, t: String, position: Int) {
        GlideUtils.loadImage(mContext,t,holder.getView(R.id.mGoodsIconIv))
        holder.setText<TextView>(R.id.mDiscountBeforeTv,"$1000")
        holder.setText<TextView>(R.id.mDiscountAfterTv,"$100")
        holder.getView<TextView>(R.id.mDiscountBeforeTv).paint.flags= Paint.STRIKE_THRU_TEXT_FLAG
        holder.getView<TextView>(R.id.mDiscountBeforeTv).paint.isAntiAlias=true

    }
}