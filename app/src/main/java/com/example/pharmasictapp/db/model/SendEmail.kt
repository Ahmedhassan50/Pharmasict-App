package com.example.pharmasictapp.db.model

import com.google.gson.annotations.SerializedName

data class SendEmail(
    @SerializedName("personalizations") var personalizations : List<Personalizations>,
    @SerializedName("from") var from : From,
    @SerializedName("subject") var subject : String,
    @SerializedName("content") var content : List<Content>
)

data class Personalizations (

    @SerializedName("to") var to : List<To>

)
data class To (

    @SerializedName("email") var email : String

)
data class From (

    @SerializedName("email") var email : String

)
data class Content (

    @SerializedName("type") var type : String,
    @SerializedName("value") var value : String

)