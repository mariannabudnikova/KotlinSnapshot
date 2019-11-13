package com.karumi.kotlinsnapshot.core

import java.io.File

internal object TestCaseExtractorNotSupported : TestCaseExtractor() {
    override fun getTestStackElement(): StackTraceElement? = null
}

object SnapshotFileReader {
    fun getRootFile(): File = File("__snapshot__")

    fun getSnapshotFile(filename: String): File = File(getRootFile(), "$filename.snap")

    fun getSnapshotFile(parent: String, filename: String): File =
        File(getRootFile().absolutePath).resolve(parent).resolve("$filename.snap")
}
