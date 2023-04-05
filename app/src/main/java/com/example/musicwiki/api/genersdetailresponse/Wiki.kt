package com.example.musicwiki.api.genersdetailresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wiki(
    @SerializedName("content")
    @Expose
    var content: String,
    @SerializedName("summary")
    @Expose
    var summary: String
)