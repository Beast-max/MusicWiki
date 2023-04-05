package com.example.musicwiki.api.trackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("page")
    @Expose
    var page: String,
    @SerializedName("perPage")
    @Expose
    var perPage: String,
    @SerializedName("tag")
    @Expose
    var tag: String,
    @SerializedName("total")
    @Expose
    var total: String,
    @SerializedName("totalPages")
    @Expose
    var totalPages: String
)