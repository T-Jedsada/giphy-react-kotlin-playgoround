package giphy

import kotlinx.html.role
import kotlinx.html.title
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.iframe
import dao.*

interface GiphyProps : RProps {
    var giphy: GiphyDetailDAO
}

class GiphyDetails(props: GiphyProps) : RComponent<GiphyProps, RState>(props) {

    override fun RBuilder.render() {
        val giphy = props.giphy
        giphy?.takeIf{it != DummyGiphy}?.apply {
            div("giphy-detail col-md-8") {
                div("embed-responsive embed-responsive-16by9") {
                    iframe(classes = "embed-responsive-item") {
                        attrs {
                            src = giphyUrl
                            title = fileName
                        }
                    }
                }
                div("details text-center") {
                    a(downloadUrl, classes = "btn btn-primary") {
                        attrs {
                            title = fileName
                            role = "button"
                            target = "_blank"
                        }
                        +"Download from Giphy"
                    }
                }
            }
        } ?: run {
            div() {}
        }
    }
}


fun RBuilder.giphyDetails(giphy: GiphyDetailDAO = DummyGiphy) = child(GiphyDetails::class) {
    attrs.giphy = giphy
}