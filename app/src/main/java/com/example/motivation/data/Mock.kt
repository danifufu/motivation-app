package com.example.motivation.data

import com.example.motivation.infra.MotivationConst
import kotlin.random.Random

class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all_inclusive = MotivationConst.FILTER.ALL_INCLUSIVE
    private val happy = MotivationConst.FILTER.HAPPY
    private val sunny = MotivationConst.FILTER.SUNNY

    // lista de frases do app
    private val mListPhrase = listOf<Phrase>(
        Phrase("\"A vida é o que fazemos dela, sempre foi, e sempre será\". (Moisés)", sunny),
        Phrase("\"Os desafios são o que tornam a vida interessante e superá-los é o que dá sentido à vida\". (Joshua J. Marinho)", sunny),
        Phrase("\"Você pode ficar desapontado se falhar, mas você está condenado se não tentar\". (Beverly Sills)", sunny),
        Phrase("\"Faça o que você puder, onde você estiver, com o que você tem\". (Teddy Roosevelt)", happy),
        Phrase("\"Nunca é tarde demais para ser o que você poderia ter sido\". (George Eliot)", happy),
        Phrase("\"Para ter sucesso, o seu desejo de sucesso deve ser maior do que o seu medo do fracasso\". (Bill Cosby)", sunny),
        Phrase("\"Cada qual sabe amar a seu modo; o modo, pouco importa; o essencial é que saiba amar\". (Machado de Assis)", happy),
        Phrase("\"Seja a mudança que você quer ver no mundo\". (Mahatma Gandhi)", sunny),
        Phrase("\"Lembre-se que não conseguir o que você quer é algumas vezes um lance de sorte\". (Dalai Lama)", sunny),
        Phrase("\"Não sei aonde vou, mas já estou no caminho\". (Carl Sandburg)", sunny),
        Phrase("\"Amarei a luz, pois ela me mostra o caminho, mas suportarei as trevas porque ela me mostra as estrelas\". (Og Mandino)", happy),
        Phrase("\"O verdadeiro heroísmo consiste em persistir por mais um momento, quando tudo parece perdido\". (W. F. Grenfel)", sunny),
        Phrase("\"Se você acredita, faz toda a diferença\". (Autor desconhecido)", happy),
        Phrase("\"A melhor maneira de prever o futuro é inventá-lo\". (Autor desconhecido)", happy),
        Phrase("\"Fracasso é o condimento que dá sabor ao sucesso\". (Autor desconhecido)", sunny),
        Phrase("\"Se você acredita, faz toda a diferença\". (Autor desconhecido)", happy),
        Phrase("\"Não sabendo que era impossível, foi lá e fez\". (Autor desconhecido)", happy),
        Phrase("\"Quando está mais escuro é quando vemos mais estrelas\". (Autor desconhecido)", happy)
    )

    fun getPhrase(value: Int): String {
        // filtra a lista de frases se baseando na categoria
        val filtered = mListPhrase.filter { it.categoryId == value || value == all_inclusive}
        // retorna uma String random da lista de frases
        return filtered[Random.nextInt(filtered.size)].description
    }

}