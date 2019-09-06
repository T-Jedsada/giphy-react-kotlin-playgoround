package giphy

import axios.*
import dao.*
import kotlin.js.Promise
import kotlinext.js.jsObject

const val GIPHY_TRENDING = "https://api.giphy.com/v1/gifs/trending"
const val API_KEY = "qK7M9qsy2JdMnUReGCfR8J1tXnKYKPci"

fun giphyTrending() : Promise<AxiosResponse<GiphyDAO>> {
    val config: AxiosConfigSettings = jsObject {
        url = "${GIPHY_TRENDING}?api_key=${API_KEY}&limit=25&rating=G"
        timeout = 3000
    }
    return axios<GiphyDAO>(config)
}
