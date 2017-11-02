package pl.cyganki.utils.model.executor

import java.io.Serializable

data class ExecutionRequest(var program: ByteArray = "".toByteArray(), var extension: String = "c",
                            var testData: ByteArray = "".toByteArray(), var timeout: Long = 0) : Serializable