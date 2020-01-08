package com.example.dictionary.db.model

class Translation {

    var wordsOne: String? = null
    var wordTwo: String? = null
    var wordThree: String? = null
    var wordFour: String? = null

    constructor() {}

    constructor(wordsOne: String, wordTwo: String, wordThree: String, wordFour: String) {
        this.wordsOne = wordsOne
        this.wordTwo = wordTwo
        this.wordThree = wordThree
        this.wordFour = wordFour
    }
}
