package com.example.quizapp

object Constants {

    const val USERNAME:String="username"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getQuestions(): ArrayList<Questions>
    {
      val questionsList = ArrayList<Questions>()
        val que1=Questions(1,"What country does this flag belong to?",
        R.drawable.download,"UAE","Jordan","Kuwait","India",3)
        questionsList.add(que1)
        val que2=Questions(2,"What country does this flag belong to?",
            R.drawable.d,"Israel","Jordan","Syria","Oman",4)
        questionsList.add(que2)
        val que3=Questions(3,"What country does this flag belong to?",
            R.drawable.g,"South Korea","Malaysia","Afghanistan","Australia",4)
        questionsList.add(que3)
        val que4=Questions(4,"What country does this flag belong to?",
            R.drawable.a,"India","Mexico","Bangladesh","Sri-Lanka",1)
        questionsList.add(que4)
        val que5=Questions(5,"What country does this flag belong to?",
            R.drawable.b,"Scotland","Qatar","China","Thailand",2)
        questionsList.add(que5)
        val que6=Questions(6,"What country does this flag belong to?",
            R.drawable.q,"Nigeria","Canada","Brazil","Colombia",3)
        questionsList.add(que6)
        val que7=Questions(7,"What country does this flag belong to?",
            R.drawable.c,"Syria","Iraq","Pakistan","India",3)
        questionsList.add(que7)
        val que8=Questions(8,"What country does this flag belong to?",
            R.drawable.e,"Russia","U.S.A","India","China",2)
        questionsList.add(que8)
        val que9=Questions(9,"What country does this flag belong to?",
            R.drawable.i,"Egypt","Japan","Portugal","Ukraine",2)
        questionsList.add(que9)
        val que10=Questions(10,"What country does this flag belong to?",
            R.drawable.n,"New-ZeLand","Kenya","Ireland","Nepal",1)
        questionsList.add(que10)
        val que11=Questions(11,"What country does this flag belong to?",
            R.drawable.w,"UAE","Argentina","Kuwait","India",2)
        questionsList.add(que11)

        return questionsList
    }

}