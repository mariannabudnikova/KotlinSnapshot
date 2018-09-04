package com.karumi.kotlinsnapshot

import com.karumi.kotlinsnapshot.core.Camera
import com.karumi.kotlinsnapshot.core.KotlinSerialization
import com.karumi.kotlinsnapshot.core.SerializationModule
import com.karumi.kotlinsnapshot.core.TestCaseExtractor

class KotlinSnapshot<in A>(
    serializationModule: SerializationModule<A>,
    snapshotsFolder: String = ""
) {
    companion object {
        operator fun invoke(snapshotsFolder: String = ""): KotlinSnapshot<Any> = KotlinSnapshot(
            KotlinSerialization(),
            snapshotsFolder
        )
    }

    private val camera = Camera(
        serializationModule,
        TestCaseExtractor(),
        snapshotsFolder
    )

    fun matchWithSnapshot(value: A, snapshotName: String? = null) {
        camera.matchWithSnapshot(value, snapshotName)
    }
}

private val camera = Camera(KotlinSerialization(), TestCaseExtractor())

fun Any.matchWithSnapshot(snapshotName: String? = null) {
    camera.matchWithSnapshot(this, snapshotName)
}
