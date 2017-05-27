package dym.unique.led

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import dym.unique.led.adapter.GridAdapter
import dym.unique.led.adapter.GridAdapter.OnItemClickListener
import dym.unique.led.data.DataHolder
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    companion object {
        private val SPAN_COUNT = 2 // 每行2个 item
    }

    private val mAdapter = GridAdapter(object : OnItemClickListener {
        override fun invoke(position: Int, id: Int) {
            toast("$position is clicked")
        }
    }, object : OnItemClickListener {
        override fun invoke(position: Int, id: Int) {
            toast("$position is deleted")
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRvList.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        mRvList.setHasFixedSize(true)
        mRvList.adapter = mAdapter
        mAdapter.add(DataHolder(0, "代一鸣", ""))
        mAdapter.add(DataHolder(1, "金盾", ""))
    }
}
