package com.example.retrofitdemo.dataclass

import com.example.retrofitdemo.Result

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    var results: List<Result>,
    val totalCount: Int,
    val totalPages: Int,

    )