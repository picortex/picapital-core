@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package picapital.info

import identifier.Brand
import koncurrent.Later
import kotlin.js.JsExport

interface PiCapitalInfoScheme {
    fun brand() : Later<Brand>
}