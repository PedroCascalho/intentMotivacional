package com.example.intent_motivacional

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent_motivacional.databinding.ActivityDetalheFraseBinding

class DetalheFrase : AppCompatActivity() {

    private lateinit var bind: ActivityDetalheFraseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetalheFraseBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val pType = intent.getIntExtra("PHRASE_TYPE", 1)

        val pEnumType = PhraseType.values().first { it.ordinal == pType }

        val selectedPhrase = PhraseRepository().getPhrase(pEnumType)

        bind.txtFrase.text = selectedPhrase.phrase

        bind.imgPhraseIcon.setImageResource(getIconType(selectedPhrase.type))

        bind.btnClose.setOnClickListener {
            Intent().apply {
                putExtra("PHRASE_ITEM", selectedPhrase)
                setResult(RESULT_OK, this)
            }
            this.finish()
        }

    }

    private fun getIconType(type: PhraseType) =
        when (type) {
            PhraseType.ALL -> R.drawable.ic_all
            PhraseType.HAPPY -> R.drawable.ic_emoji
            PhraseType.SUNNY -> R.drawable.ic_sunny
        }
}

