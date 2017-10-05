package pl.cyganki.utils.modules

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import pl.cyganki.utils.modules.executor.model.ExecutionRequest
import pl.cyganki.utils.modules.executor.model.ExecutionResult

@FeignClient("executor-module")
@ConditionalOnProperty(value = "e-arbiter.modules.enabled", matchIfMissing = true)
interface ExecutorModuleInterface {

    // PRIVATE

    @PostMapping("/inner/execute")
    fun execute(@RequestBody executionRequest: ExecutionRequest): ExecutionResult
}