package com.mainduelo.marcadordetruco.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.mainduelo.marcadordetruco.adapter.HistoricAdapter
import com.mainduelo.marcadordetruco.model.HistoricModel
import com.mainduelo.marcadordetruco.R
import kotlinx.android.synthetic.main.activity_historic.*
import java.util.ArrayList

class HistoricActivity : AppCompatActivity() {

    companion object {
        public val instance = HistoricActivity()
        private val historicModelList: ArrayList<HistoricModel> = ArrayList()
        public var editTextNameTeam1 : CharSequence = "Team 1"
        public var editTextNameTeam2 : CharSequence = "Team 2"
    }

    private var listView: ListView? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)
        editNameTeam()

        listView = findViewById(R.id.listView)
        if(!historicModelList.count().equals(0)){
            val historicAdapter = HistoricAdapter(
                this,
                historicModelList!!
            )
            listView!!.adapter = historicAdapter
        }
    }

    public fun addHistoric(scoreTeam1: CharSequence, victoriesTeam1: CharSequence, scoreTeam2: CharSequence,
                           victoriesTeam2: CharSequence, time: CharSequence){
        val historicModel: HistoricModel = HistoricModel()
        historicModel.scoreTeam1 = "$scoreTeam1\n$victoriesTeam1"
        historicModel.scoreTeam2 = "$scoreTeam2\n$victoriesTeam2"
        historicModel.time = "\n$time"
        historicModelList.add(historicModel)
    }

    public fun editNameTeam(){
        textViewTeam1Name.text = editTextNameTeam1
        textViewTeam2Name.text = editTextNameTeam2
    }

    public fun clearHistoricModelList(){
        historicModelList.clear()
    }
}
