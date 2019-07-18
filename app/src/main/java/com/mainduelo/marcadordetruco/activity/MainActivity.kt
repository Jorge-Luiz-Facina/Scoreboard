package com.mainduelo.marcadordetruco.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.app.AlertDialog
import android.content.Intent
import android.widget.TextView
import com.mainduelo.marcadordetruco.animation.AnimationCard
import com.mainduelo.marcadordetruco.R
import com.mainduelo.marcadordetruco.TimeTable

class MainActivity : AppCompatActivity() {

    private var countDownTimer: CountDownTimer? = null
    private var time: Int = 0
    private var timeMilli: Long = Long.MAX_VALUE

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeButtonsOnActionTeam1()
        initializeButtonsOnActionTeam2()
        stopwatch()
    }

    private fun stopwatch() {
        if (countDownTimer != null) {
            countDownTimer?.cancel()
        }
        countDownTimer = object: CountDownTimer(timeMilli, 1000) {
            override fun onFinish() {
            }
            override fun onTick(millisUntilFinished: Long) {
                textViewTime.text = TimeTable.instance.formatHHMMSS(++time)
                AnimationCard.instance.rotate(time, imageViewCard)
            }
        }
        countDownTimer?.start()
    }

    private fun  initializeButtonsOnActionTeam1(){
        buttonTeam1Minus1.setOnClickListener{
            setTextViewScoreTeam(-1,  textViewScoreTeam1)
            addHistoric()
        }
        buttonTeam1More1.setOnClickListener{
            setTextViewScoreTeam(1,  textViewScoreTeam1)
            addHistoric()
        }
        buttonTeam1More3.setOnClickListener{
            setTextViewScoreTeam(3,  textViewScoreTeam1)
            addHistoric()
        }
        buttonTeam1More6.setOnClickListener{
            setTextViewScoreTeam(6,  textViewScoreTeam1)
            addHistoric()
        }
        buttonTeam1More9.setOnClickListener{
            setTextViewScoreTeam(9,  textViewScoreTeam1)
            addHistoric()
        }
        buttonTeam1More12.setOnClickListener{
            setTextViewScoreTeam(12,  textViewScoreTeam1)
            addHistoric()
        }
    }

    private fun  initializeButtonsOnActionTeam2(){
        buttonTeam2Minus1.setOnClickListener{
            setTextViewScoreTeam(-1,  textViewScoreTeam2)
            addHistoric()
        }
        buttonTeam2More1.setOnClickListener{
            setTextViewScoreTeam(1,  textViewScoreTeam2)
            addHistoric()
        }
        buttonTeam2More3.setOnClickListener{
            setTextViewScoreTeam(3,  textViewScoreTeam2)
            addHistoric()
        }
        buttonTeam2More6.setOnClickListener{
            setTextViewScoreTeam(6,  textViewScoreTeam2)
            addHistoric()
        }
        buttonTeam2More9.setOnClickListener{
            setTextViewScoreTeam(9,  textViewScoreTeam2)
            addHistoric()
        }
        buttonTeam2More12.setOnClickListener{
            setTextViewScoreTeam(12,  textViewScoreTeam2)
            addHistoric()
        }
    }

    private fun setTextViewScoreTeam(number : Int, scoreTeam: TextView){
        var score = (scoreTeam.text.toString().toInt() + number)

        if(score < 0)
            score = 0
        else if(score > 11)
            nextRound(scoreTeam, getTextViewVictoryTeam(scoreTeam))

        scoreTeam.setText(score.toString())
    }

    private fun getTextViewVictoryTeam(scoreTeam: TextView) : TextView{
        if(scoreTeam.equals(textViewScoreTeam1))
            return  textViewVictoryTeam1
        else
           return textViewVictoryTeam2
    }

    private fun nextRound(scoreTeam: TextView, victoryTeam: TextView){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Next round")
        alertDialog.setPositiveButton("OK", { dialog, which ->
            clearTextViewScoreTeam()
            victoryTeam.setText((victoryTeam.text.toString().toInt() + 1).toString())
        })
        alertDialog.setNegativeButton("Cancel", { dialog, which ->
            scoreTeam.setText("11")
        })
		alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun addHistoric(){
        HistoricActivity.instance.addHistoric(textViewScoreTeam1.text, textViewVictoryTeam1.text, textViewScoreTeam2.text, textViewVictoryTeam2.text, textViewTime.text )
    }

    public override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    public override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.itemHistoric) {
            HistoricActivity.editTextNameTeam1 = editTextTeam1.text
            HistoricActivity.editTextNameTeam2 = editTextTeam2.text
            startActivity(Intent(this, HistoricActivity::class.java))
        }else if(id == R.id.itemRestart){
            HistoricActivity.instance.clearHistoricModelList()
            clearTextViewScoreTeam()
            clearTextVictoryTeam()
            time = 0
        }
        return super.onOptionsItemSelected(item)
    }

    private fun clearTextViewScoreTeam(){
        textViewScoreTeam1.setText("0")
        textViewScoreTeam2.setText("0")
    }

    private fun clearTextVictoryTeam(){
        textViewVictoryTeam1.setText("0")
        textViewVictoryTeam2.setText("0")
    }
}
