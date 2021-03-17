package br.ufpe.cin.android.services

// Notification Channel constants

@JvmField val VERBOSE_NOTIFICATION_CHANNEL_NAME: CharSequence =
        "Verbose WorkManager Notifications"
const val VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION =
        "Shows notifications whenever work starts"
@JvmField val NOTIFICATION_TITLE: CharSequence = "WorkRequest Iniciando"
const val CHANNEL_ID = "VERBOSE_NOTIFICATION"
const val NOTIFICATION_ID = 1

// Other keys
const val OUTPUT_PATH = "downloads"
const val KEY_LINK_URI = "KEY_LINK_URI"
const val KEY_IMAGEFILE_URI = "KEY_IMAGEFILE_URI"
const val TAG_OUTPUT = "OUTPUT"

const val DELAY_TIME_MILLIS: Long = 3000
