package com.growthook.growthooklaboratory.data.datasource.local

import com.growthook.growthooklaboratory.data.model.request.ExampleRequest
import com.growthook.growthooklaboratory.data.model.response.ExampleResponse
import com.growthook.growthooklaboratory.data.service.ExampleService

class ExampleLocalDataSource(
    private val exampleService: ExampleService,
) {
    suspend fun postExample(exampleRequestDto: ExampleRequest): ExampleResponse =
        exampleService.postExample(exampleRequestDto)
}
