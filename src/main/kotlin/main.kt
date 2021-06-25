import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.requests.DownloadRequest
import io.github.typosquat_pd.*
import java.io.File

fun main(args: Array<String>) {

    download_and_expand("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-zip-file.zip")

    val lic = LibrariesIoClient()
    val download_list = lic.search_packages("grant")?.forEach {
        if(it.language == "Java") {
            // Case: Binary
            // TODO
            //   - Download .jar
            //   - unzip .jar
            //   - find .class files
            //   - javap -v target.class ( create disassembly file )
            //   - extract comment out ( comment out is original code extracted by the assembler )
            //   - extract URL & high entropy (obfuscation) string

        } else if(it.language == "python" || it.language == "PHP") {
            // Memo: In the case of Python & PHP, "LibrariesIO" may not provide a Download Url.
            // The Script language allows for easy string checking.
            // TODO ...
        } else if(it.language == "go") {
            // Memo: In the case of GO, "LibrariesIO" may not provide a Download Url.
            // TODO ...
        } else if(it.language == "ruby") {
            // TODO
            //   - download gem file (from url)
            //   - tar xvf {targetfile}.gem -C {unzip target directory}
            //   - unzip "data.tar.gz"
            //   - (The Script language allows for easy string checking.)
        } else if(it.language == "npm" || it.language == "typescript") {
            val splittedUrl = it.latest_download_url.split("/")
            val fileName = splittedUrl.get(splittedUrl.size)
            val dr: DownloadRequest = Fuel.download(it.latest_download_url)
            // TODO
            //   - download library tgz file (from url)
            //   - unzip "target-library.tgz"
            //   - search `.js`, `.ts` files
            //   - (The Script language allows for easy string checking.)
        } else if(it.language == "c#") {
            // TODO
            //  - download nupkg file
            //  - rename & unzip nupkg
            //  - analyze binary file...?
        }
    }
}


// TODO Rename
fun download_and_expand(url: String) {
    print("start------------")

    val DOWNLOAD_DESTINATION = "/tmp/"

    val splittedUrl = url.split("/")
    val fullFileName = splittedUrl.get(splittedUrl.size - 1)
    val fileAndExtension = fullFileName.split(".", limit=2)
    val fileName = fileAndExtension[0]
    val fileExtension = fileAndExtension[1]

    Fuel.download(url).fileDestination { response, _ ->
//        File( DOWNLOAD_DESTINATION, fullFileName)
        File.createTempFile(fileName, fileExtension)
    }

    val downloadedFilePath = DOWNLOAD_DESTINATION + fullFileName
    print("end ------------")
    print(downloadedFilePath)
    print("end ------------")

}
