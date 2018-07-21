package com.padcmyanmar.miforum.Events

import com.padcmyanmar.miforum.Data.HealthCareInfoVO

class DataEvent {

    class HealthCareLoadedEvent(val loadHealthEventInfo: List<HealthCareInfoVO>)
    class EmptyDataLoadEvent(val errorMsg: String? = "Empty Body Response")
}