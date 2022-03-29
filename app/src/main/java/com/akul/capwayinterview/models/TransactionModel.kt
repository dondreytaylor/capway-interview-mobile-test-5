package com.akul.capwayinterview.models

import android.media.Image
import java.util.Date

data class TransactionModel(
    val vendorName: String,
    val dateTime: Date,
    val icon: Image,
    val amount: String
)