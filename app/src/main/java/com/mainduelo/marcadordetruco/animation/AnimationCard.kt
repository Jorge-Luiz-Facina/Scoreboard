package com.mainduelo.marcadordetruco.animation

import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.Animation
import android.widget.ImageView
import com.mainduelo.marcadordetruco.R
import java.util.*

class AnimationCard {

    private val random : Random = Random()
    private var nextCard : Boolean = false
    private val rotate = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)

    private val cards = intArrayOf(
        R.drawable.cardclubsa,
        R.drawable.cardclubs2,
        R.drawable.cardclubs3,
        R.drawable.cardclubs4,
        R.drawable.cardclubs5,
        R.drawable.cardclubs6,
        R.drawable.cardclubs7,
        R.drawable.cardclubs8,
        R.drawable.cardclubs9,
        R.drawable.cardclubs10,
        R.drawable.cardclubsj,
        R.drawable.cardclubsk,
        R.drawable.cardclubsq,
        R.drawable.carddiamondsa,
        R.drawable.carddiamonds2,
        R.drawable.carddiamonds3,
        R.drawable.carddiamonds4,
        R.drawable.carddiamonds5,
        R.drawable.carddiamonds6,
        R.drawable.carddiamonds7,
        R.drawable.carddiamonds8,
        R.drawable.carddiamonds9,
        R.drawable.carddiamonds10,
        R.drawable.carddiamondsj,
        R.drawable.carddiamondsk,
        R.drawable.carddiamondsq,
        R.drawable.cardheartsa,
        R.drawable.cardhearts2,
        R.drawable.cardhearts3,
        R.drawable.cardhearts4,
        R.drawable.cardhearts5,
        R.drawable.cardhearts6,
        R.drawable.cardhearts7,
        R.drawable.cardhearts8,
        R.drawable.cardhearts9,
        R.drawable.cardhearts10,
        R.drawable.cardheartsj,
        R.drawable.cardheartsk,
        R.drawable.cardheartsq,
        R.drawable.cardspadesa,
        R.drawable.cardspades2,
        R.drawable.cardspades3,
        R.drawable.cardspades4,
        R.drawable.cardspades5,
        R.drawable.cardspades6,
        R.drawable.cardspades7,
        R.drawable.cardspades8,
        R.drawable.cardspades9,
        R.drawable.cardspades10,
        R.drawable.cardspadesj,
        R.drawable.cardspadesk,
        R.drawable.cardspadesq,
        R.drawable.cardjoker
    )

    companion object {
        public val instance = AnimationCard()
    }

    public fun rotate(time : Int, imageViewCard : ImageView) {
        rotate.duration = 1500
        rotate.interpolator = LinearInterpolator()
        if(time % 15 == 0){
            imageViewCard.setImageResource(R.drawable.cardback_blue5)
            imageViewCard.startAnimation(rotate)
            nextCard = true
        }
        if(imageViewCard.animation == null && nextCard){
            imageViewCard.setImageResource(cards[random.nextInt(cards.size)])
            nextCard = false
        }
    }
}