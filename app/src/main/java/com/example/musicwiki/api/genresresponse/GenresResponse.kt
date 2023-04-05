package com.example.musicwiki.api.genresresponse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("tags")
    @Expose
    var tags: Tags
)