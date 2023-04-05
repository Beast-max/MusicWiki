package com.example.musicwiki.api.genersdetailresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("reach")
    @Expose
    var reach: Int,
    @SerializedName("total")
    @Expose
    var total: Int,
    @SerializedName("wiki")
    @Expose
    var wiki: Wiki
)