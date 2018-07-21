package com.padcmyanmar.miforum.Network

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.miforum.Data.HealthCareInfoVO

class GetHealthResponse {
    @SerializedName("code")
    private var code: Int = 0

    @SerializedName("message")
    private var message: String? = ""

    @SerializedName("healthcare-info")
    private var healthCareInfoList: List<HealthCareInfoVO>? = null

    fun getCode(): Int? {
        return code
    }

    fun getMessagge(): String? {
        return message
    }

    fun getHealthCareInfoList(): List<HealthCareInfoVO>? {
        if (healthCareInfoList == null) {
            healthCareInfoList = ArrayList()

        }

        return healthCareInfoList!!

    }

    fun isResponseOK(): Boolean {
        return code == 200 && healthCareInfoList != null
    }
}