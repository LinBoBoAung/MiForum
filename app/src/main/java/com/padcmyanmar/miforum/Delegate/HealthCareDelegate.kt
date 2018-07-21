package com.padcmyanmar.miforum.Delegate

import com.padcmyanmar.miforum.Data.HealthCareInfoVO

interface HealthCareDelegate {
    fun onTabHealthCare(healthCare: HealthCareInfoVO?)
}