package com.appstocktech.dummy.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val username : String , val age : Int) : Parcelable