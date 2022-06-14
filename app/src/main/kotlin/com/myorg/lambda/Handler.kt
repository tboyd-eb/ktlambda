package com.myorg.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.InputStream
import java.io.OutputStream

class HandlerRequest(var message: String?)
data class HandlerResponse(var message: String)

class Handler : RequestStreamHandler {
    private val mapper = jacksonObjectMapper()

    override fun handleRequest(
        input: InputStream,
        output: OutputStream,
        context: Context,
    ) {
        val request = mapper.readValue(input, HandlerRequest::class.java)
        val response = Lambda.main(request)

        mapper.writeValue(output, response)
    }
}
