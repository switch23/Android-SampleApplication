package switch23.sampleapplication.util

import android.content.Context
import switch23.sampleapplication.SampleApplication

val Context.sampleApplication: SampleApplication
    get() = applicationContext as SampleApplication
