package com.myorg.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import java.io.ByteArrayInputStream
import java.io.OutputStream

class AppTest : DescribeSpec({
    val mapper = jacksonObjectMapper()

    describe("Handler") {
        lateinit var context: Context
        lateinit var output: OutputStream

        beforeEach {
            context = mockk(relaxed = true)
            output = mockk(relaxed = true)
        }

        it("should handle a request") {
            val input = ByteArrayInputStream(
                mapper.writeValueAsString(
                    HandlerRequest(null)
                ).toByteArray()
            )

            Handler().handleRequest(input, output, context) shouldBe Unit
        }
    }

    describe("Lambda") {
        lateinit var request: HandlerRequest

        it("should return a HandlerResponse") {
            request = HandlerRequest("world")
            val response = Lambda.main(request)

            response.javaClass shouldBe HandlerResponse::class.java
        }

        it("should return a specific message") {
            request = HandlerRequest("world")
            val response = Lambda.main(request)

            response.message shouldBeEqualComparingTo "Hello, world"
        }

        it("should response with 'none' if no message provided") {
            request = HandlerRequest(null)
            val response = Lambda.main(request)

            response.message shouldBeEqualComparingTo "Hello, none"
        }
    }
})
