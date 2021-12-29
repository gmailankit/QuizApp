package com.example.quizapp


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*


private var mCurrentPosition:Int=1
private  var mQuestionsList:ArrayList<Questions>?=null
private var mSelectedOptionPosition:Int=0
private var mCorrectAnswers:Int=0
private var mUserName:String?=null
class Quiz : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
       mQuestionsList=Constants.getQuestions()
        mUserName=intent.getStringExtra(Constants.USERNAME)


 setQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

    }
    private fun setQuestions()
    {

        defaultOptionsView()

        val questions= mQuestionsList!![mCurrentPosition-1]
        progressBar.progress = mCurrentPosition
        tv_question.text=questions!!.question
        tv_progress.text= "$mCurrentPosition" + "/" +progressBar.max
        iv_image.setImageResource(questions.image)
        tv_option_one.text=questions.optionOne
        tv_option_four.text=questions.optionFour

        if (mCurrentPosition== mQuestionsList!!.size)
        {
            btn_submit.text="FINISH"
        }else
        {
            btn_submit.text="SUBMIT"
        }
    }
    private fun defaultOptionsView()
    {
        val options=ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?)
    {
       when(v?.id)
       {
           R.id.tv_option_one ->
           {
               selectedOptionView(tv_option_one, selectedOptionNum = 1)
           }
           R.id.tv_option_two ->
           {
               selectedOptionView(tv_option_two, selectedOptionNum = 2)
           }
           R.id.tv_option_three ->
           {
               selectedOptionView(tv_option_three, selectedOptionNum = 3)
           }
           R.id.tv_option_four ->
           {
               selectedOptionView(tv_option_four, selectedOptionNum = 4)
           }
           R.id.btn_submit ->{
               if (mSelectedOptionPosition==0)
               {
                   mCurrentPosition++
               }
               when
               {
                mCurrentPosition <= mQuestionsList!!.size->
                {
                    setQuestions()
                }else->
               {
                   val intent=Intent(this,ResultActivity::class.java)
                   intent.putExtra(Constants.USERNAME, mUserName)
                   intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                   intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                   startActivity(intent)
               }
               }
           } else->{
           val questions= mQuestionsList?.get(mCurrentPosition-1)
           if (questions!!.correctAnswer!= mSelectedOptionPosition)
           {
               answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
           }
           else
           {
               mCorrectAnswers++
           }
           answerView(questions.correctAnswer,R.drawable.correct_option_border_bg)
           if (mCurrentPosition== mQuestionsList!!.size)
           {
               btn_submit.text="FINISH"
           }
           else
           {
               btn_submit.text="GO TO NEXT QUESTION"
           }
           mSelectedOptionPosition=0
       }

       }
    }
    private fun answerView(answer:Int,drawableView:Int)
    {
        when(answer)
        {

            1->{tv_option_one.background=ContextCompat.getDrawable(this,drawableView)}
            2->{tv_option_two.background=ContextCompat.getDrawable(this,drawableView)}
            3->{tv_option_three.background=ContextCompat.getDrawable(this,drawableView)}
            4->{tv_option_four.background=ContextCompat.getDrawable(this,drawableView)}
        }

    }

    private fun selectedOptionView( tv:TextView,selectedOptionNum:Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
}