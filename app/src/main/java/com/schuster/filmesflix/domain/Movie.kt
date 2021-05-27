package com.schuster.filmesflix.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(

    @SerializedName("id") val id: Int,
    @SerializedName("titulo") val titulo: String,
    @SerializedName("imagem") val imagem: String?,
    @SerializedName("descricao") val descricao: String?,
    @SerializedName("data_lancamento") val dataLancamento: String?

): Parcelable
