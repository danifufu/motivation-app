package com.example.motivation.infra

class MotivationConst private constructor() { // utilizado para que nao seja possivel instanciar a classe

    // criando constantes para evitar possiveis erros de digitacao da KEY (shared preferences)
    object KEY {
        const val USER_NAME = "USER_NAME"
    }

    // definindo um valor para cada um dos itens (filtros) da top bar
    object  FILTER {
        const val ALL_INCLUSIVE = 1
        const val HAPPY = 2
        const val SUNNY = 3
    }

}