package com.myorg.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class HandlerRequest(var message: String? = null)

data class HandlerResponse(var message: String)

class Handler : RequestHandler<HandlerRequest, HandlerResponse> {
    override fun handleRequest(
        input: HandlerRequest?,
        context: Context?,
    ): HandlerResponse {
        input?.let {
            return HandlerResponse("Hello, ${it.message ?: "none"}")
        }

        return HandlerResponse("None")
    }
}
