package com.kemalakkus.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.kemalakkus.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null
    private var buttonSubmit: Button? = null
    private var joker: Button? = null
    //private val randomNumbers = (0..3).shuffled().take(2)


    private var bool: Boolean = true
    private var bool2: Boolean = true

    val options = ArrayList<TextView>()

    private lateinit var binding: ActivityQuizQuestionsBinding
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    //private var randomAnswer1: Int = 0
    //private var randomAnswer2: Int = 0

    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        progressBar = binding.progressBar
        tvProgress = binding.tvProgress
        tvQuestion = binding.tvQuestion
        ivImage = binding.ivImage
        tvOptionOne = binding.tvOptionOne
        tvOptionTwo = binding.tvOptionTwo
        tvOptionThree = binding.tvOptionThree
        tvOptionFour = binding.tvOptionFour
        buttonSubmit = binding.btnSubmit
        joker = binding.jokerButton



        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
        //Log.i("Questions Size","${questionList.size}")

        setQuestions()

        binding.tvOptionOne?.setOnClickListener(this)
        binding.tvOptionTwo?.setOnClickListener(this)
        binding.tvOptionThree?.setOnClickListener(this)
        binding.tvOptionFour?.setOnClickListener(this)
        binding.btnSubmit?.setOnClickListener (this)
        binding.jokerButton?.setOnClickListener (this)


    }

    private fun setQuestions(){

        bool = true

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit?.text = "FINISH"
        } else {
            binding.btnSubmit?.text = "SUBMIT"
        }





        binding.progressBar?.progress =
            mCurrentPosition // Setting the current progress in the progressbar using the position of question
        binding.tvProgress?.text =
            "$mCurrentPosition" + "/" + binding.progressBar?.max // Setting up the progress text

        binding.tvQuestion.text = question!!.question
        binding.ivImage.setImageResource(question.image)

        tvOptionOne?.isClickable = true
        tvOptionTwo?.isClickable = true
        tvOptionThree?.isClickable = true
        tvOptionFour?.isClickable = true
        /*joker?.isClickable = true

        joker?.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity, R.drawable.button_border_bg
        )*/


        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

    }

    private fun defaultOptionsView(){

        binding.tvOptionOne?.let {
            options.add(0, it)
        }
        binding.tvOptionTwo?.let {
            options.add(1, it)
        }
        binding.tvOptionThree?.let {
            options.add(2, it)
        }
        binding.tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.tv_option_one -> {

                if (bool) {

                    binding.tvOptionOne?.let {
                        selectedOptionView(it, 1)
                    }
                }
                else Unit

            }

            R.id.tv_option_two -> {
                if (bool) {

                    binding.tvOptionTwo?.let {
                        selectedOptionView(it, 2)
                    }
                }
                else Unit

            }

            R.id.tv_option_three -> {

                if (bool) {

                    binding.tvOptionThree?.let {
                        selectedOptionView(it, 3)
                    }
                }
                else Unit

            }

            R.id.tv_option_four -> {

                if (bool) {

                    binding.tvOptionFour?.let {
                        selectedOptionView(it, 4)
                    }
                }
                else Unit

            }



            R.id.jokerButton ->{
                bool2 = false

                val correctans=mQuestionsList!![mCurrentPosition-1].correctAnswer
                val list= mutableListOf<Int>(1,2,3,4)
                list.remove(correctans)
                val randomNumbers=list.shuffled().take(2)
               /* for(item in bb){
                    options[item].background=ContextCompat.getDrawable(this,R.drawable.joker_option_border_bg)
                }*/






                println(randomNumbers)

                // İki rastgele sayı üretin (0-3 arasında)
                // İki şıkkı gri renkle işaretleyin

                for (number in randomNumbers ) {

                    when (number) {
                        1 -> {
                            binding.tvOptionOne?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg)
                            tvOptionOne?.isClickable = false

                            joker?.isClickable = false
                            joker?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg
                            )


                        }
                        2 -> {
                            tvOptionTwo?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg)
                            tvOptionTwo?.isClickable = false

                            joker?.isClickable = false
                            joker?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg
                            )
                        }
                        3 -> {
                            tvOptionThree?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg)
                            tvOptionThree?.isClickable = false

                            joker?.isClickable = false
                            joker?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg
                            )
                        }
                        4 -> {
                            tvOptionFour?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg)
                            tvOptionFour?.isClickable = false

                            joker?.isClickable = false
                            joker?.background = ContextCompat.getDrawable(
                                this@QuizQuestionsActivity, R.drawable.joker_option_border_bg
                            )
                        }
                    }
                }


                /*

                val question = mQuestionsList?.get(mCurrentPosition - 1)

                question!!.correctAnswer = randomNumbers.random()

                 */



            }

            R.id.btn_submit->{


                bool = false

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestions()
                        }
                        else -> {
                            // TODO (Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)


                    }else{
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        binding.btnSubmit?.text = "FINISH"
                    } else {
                        binding.btnSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }

    }



    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        if (R.id.jokerButton != null){

        }

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                binding.tvOptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                binding.tvOptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                binding.tvOptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                binding.tvOptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}