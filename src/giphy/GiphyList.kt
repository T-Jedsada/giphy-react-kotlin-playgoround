package giphy

import react.*
import dao.*
import react.dom.ul

interface GiphyListProps : RProps {
    var giphies : Array<GiphyDetailDAO>
    var onItemClick: (GiphyDetailDAO) -> Unit

}

class GiphyList(props: GiphyListProps) : RComponent<GiphyListProps, RState>(props) {

    override fun RBuilder.render() {
        ul() {
            props.giphies.map { giphy ->
                giphyItem(giphy, props.onItemClick)
            }
        }
    }
}

fun RBuilder.giphyList(giphies: Array<GiphyDetailDAO>, onItemClick: (GiphyDetailDAO) -> Unit) = child(GiphyList::class) {
    attrs.let {
        it.giphies = giphies
        it.onItemClick = onItemClick
    }
}