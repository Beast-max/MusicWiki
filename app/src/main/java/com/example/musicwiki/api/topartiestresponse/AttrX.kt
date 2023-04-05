package com.example.musicwiki.api.topartiestresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AttrX(
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