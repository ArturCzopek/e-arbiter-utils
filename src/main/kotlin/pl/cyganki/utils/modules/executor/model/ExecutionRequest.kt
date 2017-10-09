package pl.cyganki.utils.modules.executor.model

import java.io.Serializable

data class ExecutionRequest(var program: ByteArray = "".toByteArray(), var extension: String = "c",
                            var testData: ByteArray = "".toByteArray()) : Serializable