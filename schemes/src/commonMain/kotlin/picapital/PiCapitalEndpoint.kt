package picapital

import flame.SmeEndpoint
import picapital.info.PiCapitalInfoEndpoint
import sanity.SanityEndpoint
import sentinel.EmailAuthenticationEndpoint
import sentinel.EmailRegistrationEndpoint

class PiCapitalEndpoint(base: String) {
    val sanity by lazy { SanityEndpoint(base) }
    val registration by lazy { EmailRegistrationEndpoint(base) }
    val authentication by lazy { EmailAuthenticationEndpoint(base) }
    val sme by lazy { SmeEndpoint(base) }
    val info by lazy { PiCapitalInfoEndpoint(base) }
}