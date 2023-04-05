package com.example.musicwiki.api.topartiestresponse.toptrackresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AttrX(
    @SerializedName("rank")
    @Expose
    var rank: String
)