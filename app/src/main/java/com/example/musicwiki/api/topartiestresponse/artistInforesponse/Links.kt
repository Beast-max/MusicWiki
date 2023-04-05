package com.example.musicwiki.api.topartiestresponse.artistInforesponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Links(
    @SerializedName("link")
    @Expose
    var link: Link
)