package com.example.intent_motivacional

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent_motivacional.databinding.ActivityMainBinding
import java.util.concurrent.Phaser

class MainActivity : AppCompatActivity() {

    private lateinit var databindng: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databindng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(databindng.root)

        databindng.btnOpenNewActivity.setOnClickListener {
            val intent = Intent(this, DetalheFrase::class.java)
            intent.putExtra("PHRASE_TYPE", PhraseType.ALL.ordinal)
            //startActivity(intent)
            register.launch(intent)
        }

    }

    val register = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { data ->
                val phraseReturn = data.getParcelableExtra<Phrase>("PHRASE_ITEM")
                databindng.txtLastPhrase.text = phraseReturn?.phrase
            }
        }
    }
}