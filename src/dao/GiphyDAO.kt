package dao

val GiphyDetailDAO.fileName : String
    get() = "${this.slug}.gif"

val GiphyDetailDAO.giphyUrl: String
    get() = this.embed_url

val GiphyDetailDAO.downloadUrl: String
    get() = "https://media.giphy.com/media/${this.id}/giphy.gif"

val GiphyDetailDAO.previewUrl: String
    get() = this.images.fixed_height_small_still.url;

external interface GiphyImgDAO {
    val url : String
}

external interface GiphyImgagesDAO {
    val original: GiphyImgDAO
    val fixed_height_small_still: GiphyImgDAO
}

external interface GiphyDetailDAO {
    val id : String
    var embed_url: String
    var images: GiphyImgagesDAO
    var slug: String
}

external interface GiphyDAO {
    val data: Array<GiphyDetailDAO>
}