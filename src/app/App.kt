package app

import react.*
import react.dom.*
import giphy.*
import dao.*

interface GiphyState : RState {
    var giphies: Array<GiphyDetailDAO>
    var giphy: GiphyDetailDAO
}

class App : RComponent<RProps, GiphyState>() {

    override fun GiphyState.init() {
        giphies = emptyArray()
        giphy = DummyGiphy
    } 

    override fun componentDidMount() {
        giphyTrending().then { response -> 
            setState { giphies = response.data.data }
        }.catch { e -> 
            console.log(e.message) 
        }
    }

    override fun RBuilder.render() {
        div("container") {
            h2 { +"Giphy App (React ️❤ Kotlin )"}
            giphyDetails(state.giphy)
            giphyList(state.giphies, ::onItemClick)
        }
    }

    fun onItemClick(giphy: GiphyDetailDAO) {
        setState {
            this.giphy = giphy
        }
    }
}

fun RBuilder.app() = child(App::class) {}
