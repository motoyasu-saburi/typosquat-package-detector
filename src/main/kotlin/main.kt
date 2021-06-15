import io.github.typosquat_pd.*

fun main(args: Array<String>) {
    val lic = LibrariesIoClient()
    val download_list = lic.search_packages("grant")?.forEach {
        if(it.language == "Java" || ) {
            // Case: Binary
            // TODO
            //   - Download .jar
            //   - unzip .jar
            //   - find .class files
            //   - javap -v target.class ( create disassembly file )
            //   - extract comment out ( comment out is original code extracted by the assembler )
            //   - extract URL & high entropy (obfuscation) string

        } else if (it.language == "python" || it.language == "PHP") {
            // Memo: In the case of Python & PHP, "LibrariesIO" may not provide a Download Url.
            // The Script language allows for easy string checking.
            // TODO ...
        } else if (it.language == "go") {
            // Memo: In the case of GO, "LibrariesIO" may not provide a Download Url.
            // TODO ...
        } else if (it.language == "ruby") {
            // TODO
            //   - download gem file (from url)
            //   - tar xvf {targetfile}.gem -C {unzip target directory}
            //   - unzip "data.tar.gz"
            //   - (The Script language allows for easy string checking.)
        } else if(it.language == "npm" || it.language == "typescript") {
            // TODO
            //   - download library tgz file (from url)
            //   - unzip "target-library.tgz"
            //   - search `.js`, `.ts` files
            //   - (The Script language allows for easy string checking.)
        } else if (it.language == "c#") {
            // TODO
            //  - download nupkg file
            //  - rename & unzip nupkg
            //  - analyze binary file...?
        }
    }

}