package com.kemalakkus.quizapp

object Constants {

    // TODO  Create a constant variables which we required in the result screen
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_bulbasaur,
            "Bulbasaur", "Pikachu",
            "Psyduck", "Snorlax", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_meowth,
            "Squirtle", "Mew",
            "Meowth", "Charmander", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_charmander,
            "Jigglypuff", "Meowth",
            "Bulbasaur", "Charmander", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_mew,
            "Pikachu", "Mew",
            "Meowth", "Mewtwo", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_mewtwo,
            "Psyduck", "Snorlax",
            "Mewtwo", "Squirtle", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_jigglypuff,
            "Jigglypuff", "Pikachu",
            "Bulbasaur", "Charmander", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_pikachu,
            "Mew", "Psyduck",
            "Pikachu", "Snorlax", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_psyduck,
            "Charmander", "Pikachu",
            "Squirtle", "Psyduck", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_snorlax,
            "Meowth", "Snorlax",
            "Mew", "Bulbasaur", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What is the name of the pokemon in the photo?",
            R.drawable.ic_pokemon_squirtle,
            "Squirtle", "Charmander",
            "Psyduck", "Pikachu", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}