package com.configuration

import kotlinx.coroutines.newFixedThreadPoolContext
import org.springframework.stereotype.Component

@Component
class ThreadPoolComponent {
    val dispatcherWithThreads = newFixedThreadPoolContext(2, "test")
}