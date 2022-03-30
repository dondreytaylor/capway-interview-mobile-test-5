package com.akul.capwayinterview.models

import java.time.LocalDateTime

data class Transaction(
    val vendorName: String,
    val dateTime: LocalDateTime,
    val icon: Int,
    val amount: String,
    val pending: Boolean
)
