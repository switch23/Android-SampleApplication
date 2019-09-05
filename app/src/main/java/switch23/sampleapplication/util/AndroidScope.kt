package switch23.sampleapplication.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object AndroidScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}
