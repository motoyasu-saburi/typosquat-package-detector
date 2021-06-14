import io.github.typosquat_pd.*

fun main(args: Array<String>) {
    val lic = LibrariesIoClient()
    val g = lic.search_packages("grant")
    println(g)
}