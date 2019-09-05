package switch23.sampleapplication.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart

interface LifecycleScopeSupport {
    val scope: LifecycleScope
}

fun LifecycleScopeSupport.bindLaunch(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) = scope.bindLaunch(start, block)
