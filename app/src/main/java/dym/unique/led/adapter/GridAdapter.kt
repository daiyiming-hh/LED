package dym.unique.led.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dym.unique.led.R
import dym.unique.led.data.DataHolder
import kotlinx.android.synthetic.main.recycler_view_item_grid.view.*

class GridAdapter(val itemClickListener: OnItemClickListener,
                  val itemDeleteClickListener: OnItemClickListener) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    private val mItems = ArrayList<DataHolder>()

    interface OnItemClickListener {
        operator fun invoke(position: Int, id: Int)
    }

    class ViewHolder(itemView: View, val itemClickListener: OnItemClickListener,
                     val itemDeleteClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        fun bindData(position: Int, dataHolder: DataHolder) {
            with(dataHolder) {
                itemView.mTvTitle.text = title
//                itemView.mImgIcon.setImageBitmap(BitmapFactory.decodeFile(iconPath))
                itemView.setOnClickListener { itemClickListener(position, id) }
                itemView.mImgDelete.setOnClickListener { itemDeleteClickListener(position, id) }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(position, mItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recycler_view_item_grid, parent, false), itemClickListener, itemDeleteClickListener)

    override fun getItemCount(): Int = mItems.size

    fun add(dataHolder: DataHolder) {
        mItems.add(dataHolder)
    }

}