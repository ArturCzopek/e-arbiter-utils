package pl.cyganki.utils.modules.executor.model

data class ExecutionResult(var status: Status = Status.FAILURE, var output: String = "") {

    enum class Status {
        SUCCESS, FAILURE, TIMEOUT, INTERNAL_ERROR
    }
}