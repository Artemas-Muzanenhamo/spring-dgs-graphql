package com.artemas.dgs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringDgsGraphqlApplication

fun main(args: Array<String>) {
    runApplication<SpringDgsGraphqlApplication>(*args)
}
