package ru.cib.log4shellrce

import org.apache.logging.log4j.LogManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Log4jController {

    companion object {
        private val logger = LogManager.getLogger(Log4jController::class.java)
    }

    @GetMapping("/log")
    fun logInput(@RequestParam input: String): String {
        // Уязвимость: логирование непроверенных пользовательских данных
        logger.info("Received input: $input")
        return "Logged: $input"
    }
}