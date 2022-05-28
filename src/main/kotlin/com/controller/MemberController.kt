package com.controller

import com.configuration.ThreadPoolComponent
import kotlinx.coroutines.withContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val threadPoolComponent: ThreadPoolComponent,
) {

    @GetMapping("member")
    suspend fun getMember(): String {
        return withContext(threadPoolComponent.dispatcherWithThreads) {
            Thread.currentThread().name
        }
    }
}