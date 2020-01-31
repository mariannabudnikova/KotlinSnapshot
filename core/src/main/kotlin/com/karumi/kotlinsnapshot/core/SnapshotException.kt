package com.karumi.kotlinsnapshot.core

import junit.framework.ComparisonFailure

class SnapshotException(
    msg: String,
    expected: String,
    actual: String
) : ComparisonFailure(msg, expected, actual)
