package com.myorg.lambda

import com.amazonaws.services.lambda.runtime.Context
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk

class HandlerTest : DescribeSpec({
    describe("Handler") {
        val handler = Handler()
        lateinit var context: Context

        beforeEach {
            context = mockk(relaxed = true)
        }

        it("should handle a request") {
            handler.handleRequest(null, context) shouldNotBe null
        }

        it("should respond with a specific message") {
            val request = HandlerRequest().also { it.message = "world" }
            val response = handler.handleRequest(request, null)

            response.message shouldBeEqualComparingTo "Hello, world"
        }

        it("should respond with 'None' when given no input") {
            val response = Handler().handleRequest(null, context)

            response.message shouldBeEqualComparingTo "None"
        }
    }
})
