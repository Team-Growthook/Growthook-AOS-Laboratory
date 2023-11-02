package com.growthook.growthooklaboratory.data.datasource.remote

import com.growthook.growthooklaboratory.data.model.request.ExampleRequest
import com.growthook.growthooklaboratory.data.model.response.ExampleResponse
import com.growthook.growthooklaboratory.data.service.ExampleService

class ExampleRemoteDataSource(
    private val exampleService: ExampleService,
) {
    suspend fun postExample(exampleRequestDto: ExampleRequest): ExampleResponse =
        exampleService.postExample(exampleRequestDto)
}
