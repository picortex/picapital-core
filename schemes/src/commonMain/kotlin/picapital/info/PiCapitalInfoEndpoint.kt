package picapital.info

class PiCapitalInfoEndpoint(private val base: String) {

    private val root = "$base/info"
    fun healthCheck() = "$root/health"

    fun brand() = "$root/brand"
}