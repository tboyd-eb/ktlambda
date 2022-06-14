package com.myorg.lambda

class Lambda {
    companion object {
        fun main(request: HandlerRequest): HandlerResponse {
            return HandlerResponse("Hello, ${request.message ?: "none"}")
        }
    }
}
