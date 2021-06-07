import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.result.Result

data class LibrariesIoSearchResult(val dummy: String)

val require_field_example = """
[
  {

    "description": "The JavaScript Task Runner",
    "forks": 1540,
    "keywords": [
      "task",
      "async"
    ],
    "language": "JavaScript",
    "latest_download_url": "https://registry.npmjs.org/grunt/-/grunt-1.4.1.tgz",
    "latest_release_number": "1.4.1",
    "latest_release_published_at": "2021-05-24 14:25:05 UTC",
    "latest_stable_release_number": "1.4.1",
    "latest_stable_release_published_at": "2021-05-24 14:25:05 UTC",
    "license_normalized": false,
    "licenses": "MIT",
    "name": "grunt",
    "normalized_licenses": [
      "MIT"
    ],
    "package_manager_url": "https://www.npmjs.com/package/grunt",
    "platform": "NPM",
    "rank": 31,
    "repository_url": "https://github.com/gruntjs/grunt",
    "stars": 12086,
    "versions": [
      {
        "number": "0.1.0",
        "published_at": "2012-01-12 13:08:51 UTC",
        "spdx_expression": "MIT",
        "original_license": "MIT",
        "researched_at": null,
        "repository_sources": [
          "NPM"
        ]
      }
    ]
  }
]
"""


class LibrariesIoClient {
    val API_KEY = System.getenv("LIBRARIES_IO_API_KEY")

    fun search_packages(keyword: String): LibrariesIoSearchResult {
        val SEARCH_API_URL = """https://libraries.io/api/search?q=${keyword}&api_key=${API_KEY}"""
        val (_, response, result) = SEARCH_API_URL.httpGet().responseString()

        return when (result) {
            is Result.Failure -> LibrariesIoSearchResult("TODO throw") // TODO handle error
            is Result.Success -> {
                LibrariesIoSearchResult("TODO") // TODO Parse & Mapping json
            }
    }
}