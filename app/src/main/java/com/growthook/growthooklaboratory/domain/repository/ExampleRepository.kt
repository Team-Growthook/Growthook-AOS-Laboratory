package com.growthook.growthooklaboratory.domain.repository

import com.growthook.growthooklaboratory.data.model.request.ExampleRequest
import com.growthook.growthooklaboratory.data.model.response.ExampleResponse

interface ExampleRepository {
    suspend fun postExample(exampleRequest: ExampleRequest): Result<ExampleResponse>
}
