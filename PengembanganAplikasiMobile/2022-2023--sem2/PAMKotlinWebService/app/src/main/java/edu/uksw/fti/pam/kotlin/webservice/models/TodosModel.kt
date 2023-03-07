package edu.uksw.fti.pam.kotlin.webservice.models

import com.google.gson.annotations.SerializedName

data class TodosModel(
    @SerializedName("userId")
    var userId: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("completed")
    var completed: Boolean
)
