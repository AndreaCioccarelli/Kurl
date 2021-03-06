/**
 * Designed and developed by Andrea Cioccarelli (@cioccarellia)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.cioccarellia.kurl.dsl

import com.cioccarellia.kurl.annotations.KurlLauncher
import com.cioccarellia.kurl.api.Api
import com.cioccarellia.kurl.api.Endpoint
import com.cioccarellia.kurl.compose.Composer

/**
 * Output class representing an high level interface for
 * importing/exporting request data, derived from the
 * execution of a [kurl launcher][KurlLauncher] function.
 *
 * All the processed fields are public and final, thus the exact representation
 * of what the real URL the calling software is referring to, in Kurl syntax.
 * */
data class KurlRequest @PublishedApi internal constructor(
    val api: Api,
    val endpoint: Endpoint,
    val urlParameters: UrlParameters,
    val headers: Map<String, Any>,
    val fragment: String
) {
    /**
     * Returns the URL representing the built request.
     * */
    fun url(): String = buildString {
        append(
            Composer.compose(api.url(), endpoint)
        )

        append(urlParameters.toString())
        append(fragment)
    }

    /**
     * Checks if the passed string, converted to [Regex],
     * is contained inside the Kurl builder content.
     * */
    fun contains(
        string: String,
        ignoreCase: Boolean = false
    ) = check(url().contains(string, ignoreCase))

    /**
     * Checks if the passed [regex][Regex] is contained inside the
     * Kurl builder content.
     * */
    fun contains(
        regex: Regex
    ) = check(url().contains(regex))


    /**
     * Checks if the passed [regex][Regex] matches the
     * Kurl builder content.
     * */
    fun matches(
        regex: Regex
    ) = check(url().matches(regex))

    /**
     * Checks if the passed  matches the
     * Kurl builder content.
     * */
    fun matches(
        regex: String
    ) = check(url().matches(regex.toRegex()))

    override fun toString() = url()
}