package com.example.composition.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResult


interface OnOptionsClickListener{
    fun onOptionClick(option:Int)
}

@BindingAdapter("required_answers")
fun bindRequiredAnswer(textView: TextView, count: Int) {
    textView.text = textView.context.getString(
        R.string.required_score,
        count.toString()
    )
}

@BindingAdapter("score_answers")
fun bindScoreAnswer(textView: TextView, count: Int) {
    textView.text = textView.context.getString(
        R.string.score_answers,
        count.toString()
    )
}

@BindingAdapter("required_percentage")
fun bindRequiredPercentage(textView: TextView, count: Int) {
    textView.text = textView.context.getString(
        R.string.required_percentage,
        count.toString()
    )
}

@BindingAdapter("score_percentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(
            R.string.score_percentage
        ), getPercentageOfRightAnswer(gameResult)
    )
}

@BindingAdapter("winner")
fun bindWinner(imageView: ImageView, winner: Boolean) {
    imageView.setImageResource(emojiWinner(winner))
}

private fun emojiWinner(winner: Boolean): Int {
    val winnerEmoji = if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
    return winnerEmoji
}

private fun getPercentageOfRightAnswer(gameResult: GameResult): Int {
    return if (gameResult.countOfQuestions == 0) {
        0
    } else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()
    }
}

@BindingAdapter("tvAnswersProgress")
fun bindAnswerProgress(textView: TextView, textEnough: Boolean) {
    textView.setTextColor(getColor(textView.context, textEnough))
}

@BindingAdapter("progressColor")
fun bindProgress(progressBar: ProgressBar, colorProgress: Boolean) {
    progressBar.progressTintList = ColorStateList.valueOf(
        getColor(progressBar.context, colorProgress)
    )
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, count: Int) {
    textView.text = count.toString()
}

private fun getColor(context: Context, enough: Boolean): Int {
    val color = if (enough) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_dark
    }
    val background = ContextCompat.getColor(context, color)
    return background
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView,clickListener:OnOptionsClickListener){
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}