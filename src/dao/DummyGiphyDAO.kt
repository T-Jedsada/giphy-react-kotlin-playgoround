package dao

object DummyGiphyImg : GiphyImgDAO {
    override var url: String = ""
}

object DummyGiphyImgContainer : GiphyImgagesDAO {
    override var original: GiphyImgDAO = DummyGiphyImg
    override var fixed_height_small_still: GiphyImgDAO = DummyGiphyImg
}

object DummyGiphy : GiphyDetailDAO {
    override var id: String = ""
    override var embed_url: String = ""
    override var images: GiphyImgagesDAO = DummyGiphyImgContainer
    override var slug: String = ""
}