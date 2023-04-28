package com.example.intent_motivacional

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Phrase(
    val phrase: String,
    val type: PhraseType
) : Parcelable