package com.growthook.growthooklaboratory.data.service

import com.growthook.growthooklaboratory.data.model.request.ExampleRequest
import com.growthook.growthooklaboratory.data.model.response.ExampleResponse

interface ExampleService {
    // 예시 API
//    @POST("api/example")
    suspend fun postExample(
        request: ExampleRequest,
    ): ExampleResponse
}
