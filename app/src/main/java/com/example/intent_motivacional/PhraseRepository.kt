package com.example.intent_motivacional

import kotlin.random.Random

class PhraseRepository {

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", PhraseType.HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", PhraseType.HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", PhraseType.HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", PhraseType.HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", PhraseType.HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", PhraseType.HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", PhraseType.SUNNY),
        Phrase("Você perde todas as chances que você não aproveita.", PhraseType.SUNNY),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", PhraseType.SUNNY),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", PhraseType.SUNNY),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", PhraseType.SUNNY),
        Phrase("Se você acredita, faz toda a diferença.", PhraseType.SUNNY),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", PhraseType.SUNNY)
    )

    fun getPhrase(type:PhraseType):Phrase{
        val filtered = listPhrases.filter { it.type == type || type == PhraseType.ALL }

        val indexRandon = Random.nextInt(filtered.size)

        return filtered[indexRandon]
    }

}