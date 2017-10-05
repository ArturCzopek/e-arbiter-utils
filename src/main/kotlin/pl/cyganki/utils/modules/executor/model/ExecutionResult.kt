package pl.cyganki.utils.modules.executor.model

class ExecutionResult(private val status: Status, private val output: String) {

    enum class Status {
        SUCCESS, FAILURE, TIMEOUT, INTERNAL_ERROR
    }
}