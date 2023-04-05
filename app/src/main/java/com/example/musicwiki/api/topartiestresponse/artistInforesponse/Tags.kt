package com.example.musicwiki.api.topartiestresponse.artistInforesponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Tags(
    @SerializedName("tag")
    @Expose
    var tag: List<Tag>
)