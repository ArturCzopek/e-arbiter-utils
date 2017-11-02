package pl.cyganki.utils.model.executor

data class ExecutionResult(var status: Status = Status.FAILURE, var output: String = "") {

    enum class Status {
        SUCCESS, FAILURE, TIMEOUT, INTERNAL_ERROR
    }
}