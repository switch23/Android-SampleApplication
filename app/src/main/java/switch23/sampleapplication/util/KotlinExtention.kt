package switch23.sampleapplication.util

fun <T> nonConcurrentLazy(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)
