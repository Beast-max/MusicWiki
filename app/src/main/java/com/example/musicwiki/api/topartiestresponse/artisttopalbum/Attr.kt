package com.example.musicwiki.api.topartiestresponse.artisttopalbum


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Attr(
    @SerializedName("artist")
    @Expose
    var artist: String,
    @SerializedName("page")
    @Expose
    var page: String,
    @SerializedName("perPage")
    @Expose
    var perPage: String,
    @SerializedName("total")
    @Expose
    var total: String,
    @SerializedName("totalPages")
    @Expose
    var totalPages: String
)