package io.github.typosquat_pd

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType

@JsonClass(generateAdapter = true)
data class LibrariesIoSearchResult(
    val description: String,
    val forks: Int,
    val stars: Int,
    val language: String,
    val platform: String,
    val latest_release_published_at: String, // Datetime, "2021-05-24 14:25:05 UTC",
    val latest_stable_release_number: String, // "1.4.1
    val latest_stable_release_published_at: String, // Datetime, "2021-05-24 14:25:05 UTC",
    val license_normalized: Boolean,
    val licenses: String?, // MIT
    val name: String, // grunt
    val package_manager_url: String, // "https://www.npmjs.com/package/grunt"
    val latest_download_url: String?, // "https://registry.npmjs.org/grunt/-/grunt-1.4.1.tgz",
    val repository_url: String // "https://github.com/gruntjs/grunt",
)

class LibrariesIoSearchResultListDeserializer : ResponseDeserializable<List<LibrariesIoSearchResult>> {
    override fun deserialize(content: String): List<LibrariesIoSearchResult>? {
        val moshi = Moshi.Builder().build()
        val type = newParameterizedType(List::class.java, LibrariesIoSearchResult::class.java)
        val listAdapter: JsonAdapter<List<LibrariesIoSearchResult>> = moshi.adapter(type)
        return listAdapter.fromJson(content)
    }
}


class LibrariesIoClient {
    val API_KEY = System.getenv("LIBRARIES_IO_API_KEY")

    fun search_packages(keyword: String): List<LibrariesIoSearchResult>? {
        val SEARCH_API_URL = """https://libraries.io/api/search?q=${keyword}&api_key=${API_KEY}"""
        LibrariesIoSearchResultListDeserializer()
        val (_, _, result) = SEARCH_API_URL.httpGet().responseString()

        return when (result) {
            is Result.Failure -> listOf()
            is Result.Success -> {
                LibrariesIoSearchResultListDeserializer().deserialize(result.value)
            }
        }
    }
}
