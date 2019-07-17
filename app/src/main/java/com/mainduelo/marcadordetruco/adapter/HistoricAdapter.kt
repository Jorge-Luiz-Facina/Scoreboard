package com.mainduelo.marcadordetruco.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.mainduelo.marcadordetruco.R
import com.mainduelo.marcadordetruco.ViewHolder
import com.mainduelo.marcadordetruco.model.HistoricModel
import java.util.ArrayList

class HistoricAdapter(val context: Context, val HistoricModelArrayList: ArrayList<HistoricModel>) : BaseAdapter() {

    public override fun getViewTypeCount(): Int {
        return getCount()
    }

    public override fun getItemViewType(position: Int): Int {
        return position
    }

    public override fun getCount(): Int {
        return HistoricModelArrayList.size
    }

    public override fun getItem(position: Int): Any {
        return HistoricModelArrayList[position]
    }

    public override fun getItemId(position: Int): Long {
        return 0
    }

    public override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_item, null, true)

            holder.scoreTeam1 = convertView!!.findViewById(R.id.textViewCollunmTeam1) as TextView
            holder.scoreTeam2 = convertView.findViewById(R.id.textViewCollunmTeam2) as TextView
            holder.time = convertView.findViewById(R.id.textViewTime) as TextView

            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        holder.scoreTeam1!!.setText(HistoricModelArrayList[position].scoreTeam1)
        holder.scoreTeam2!!.setText((HistoricModelArrayList[position].scoreTeam2).toString())
        holder.time!!.setText((HistoricModelArrayList[position].time).toString())

        return convertView
    }
}
