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
package com.cioccarellia.kurl.api

import com.cioccarellia.kurl.compose.Composer
import com.cioccarellia.kurl.compose.KurlComposable

/**
 * Represents an url semi-path inside a complete API address.
 * An [API][Api] is the root web server URL, and an endpoint is
 * the string coming afterwards.
 *
 * Usually it is nested hierarchically and contains just the
 * path in association with a root [API][Api] and endpoints.
 * */
class Endpoint(
    relativePath: String
) : KurlComposable {
    private var path: String = Composer.sanitize(relativePath)

    /**
     * Since an [endpoint][Endpoint] is not aware of its position, nor its
     * super/sub endpoints, it returns the local value.
     * */
    override fun url() = path
    override fun toString() = path

    /**
     * Chains two [endpoints][Endpoint].
     * */
    operator fun plus(other: KurlComposable): Endpoint {
        return Endpoint(Composer.compose(url(), other))
    }

    /**
     * Chains the passed string to this [endpoint][Endpoint].
     * */
    operator fun plus(other: String): String {
        return Composer.compose(this, other)
    }

    /**
     * Joins two [endpoints][Endpoint].
     * */
    operator fun plusAssign(other: KurlComposable) {
        path = Composer.compose(url(), other)
    }

    /**
     * Joins the passed string to this [endpoint][Endpoint].
     * */
    operator fun plusAssign(other: String) {
        path = Composer.compose(url(), other)
    }
}