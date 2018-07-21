package com.padcmyanmar.miforum.Data

import com.google.gson.annotations.SerializedName

class HealthCareInfoVO(@SerializedName("id")
                       var healthCareId: Int = 0,
                       @SerializedName("title")
                       var title: String = "",
                       @SerializedName("image")
                       var image: String = "",
                       @SerializedName("author")
                       var author: AuthorVO? = null,
                       @SerializedName("short-description")
                       var shortDescription: String = "",
                       @SerializedName("published-date")
                       var publishedDate: String = "",
                       @SerializedName("complete-url")
                       var completeUrl: String = "",
                       @SerializedName("info-type")
                       var infoType: String = "")





