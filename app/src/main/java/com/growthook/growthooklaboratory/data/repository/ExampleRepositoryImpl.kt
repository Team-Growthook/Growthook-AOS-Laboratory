package com.growthook.growthooklaboratory.data.repository

import com.growthook.growthooklaboratory.data.datasource.remote.ExampleRemoteDataSource
import com.growthook.growthooklaboratory.data.model.request.ExampleRequest
import com.growthook.growthooklaboratory.data.model.response.ExampleResponse
import com.growthook.growthooklaboratory.domain.repository.ExampleRepository

class ExampleRepositoryImpl(
    private val exampleDataSource: ExampleRemoteDataSource,
) : ExampleRepository {
    override suspend fun postExample(exampleRequest: ExampleRequest): Result<ExampleResponse> =
        kotlin.runCatching { exampleDataSource.postExample(exampleRequest) }
}
