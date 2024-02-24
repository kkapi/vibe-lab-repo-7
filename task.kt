import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

suspend fun main(args: Array<String>) = coroutineScope {
    val websites = listOf(
        "https://www.google.com",
        "https://www.facebook.com",
        "https://www.github.com",
        "https://www.twitter.com",
        "https://www.instagram.com",
        "https://teach.vibelab.ru/",
        "https://vk.com/",
        "https://www.youtube.com/",
        "https://lk.etu.ru/",
        "https://ya.ru/"
    )
    for (websiteUrl in websites) {
        launch {checkWebsite(websiteUrl)}
    }
}

fun checkWebsite(url: String) {
    try {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "HEAD"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000
        connection.responseCode == HttpURLConnection.HTTP_OK
        print("Сайт ${url} доступен\n")
    } catch (e: Exception) {
        print("Сайт ${url} недоступен\n")
    }
}
