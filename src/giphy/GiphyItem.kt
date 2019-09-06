package giphy

import kotlinx.html.js.onClickFunction
import kotlinx.html.title
import react.*
import react.dom.div
import react.dom.img
import react.dom.li
import dao.*

interface GiphyItemProps : RProps {
    var giphy: GiphyDetailDAO
    var onItemClick: (GiphyDetailDAO) -> Unit
}

class GiphyItem(props: GiphyItemProps) : RComponent<GiphyItemProps, RState>(props) {

    override fun RBuilder.render() {
        val giphy = props.giphy
        li("list-group-item") {
            attrs.onClickFunction = { props.onItemClick(giphy) }
            div("giphy-item media") {
                img("media-object") {
                        attrs {
                            src = giphy.previewUrl
                            alt = giphy.fileName
                            title = giphy.fileName
                        }
                    }
            }
        }
    }
}


fun RBuilder.giphyItem(giphy: GiphyDetailDAO, onItemClick : (GiphyDetailDAO) -> Unit) = child(GiphyItem::class) {
    attrs.apply {
        this.giphy = giphy
        key = giphy.id
        this.onItemClick = onItemClick
    }
}