package com.example.retrofitdemo

data class Result(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>,
    var id: String,
    var name: String,
    var link: String,
    var bio: String,
    var descriptions: String,
    var quoteCount: Int,
    var slug: String)
//data class Result1(
//    var id: String,
//    var name: String,
//    var link: String,
//    var bio: String,
//    var descriptions: String,
//    var quoteCount: Int,
//    var slug: String,
//    var dateAdded: String,
//    var dateModified: String
//)