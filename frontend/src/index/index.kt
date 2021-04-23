package index

import react.dom.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class Index : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        h1 {
            +"Hello World"
        }
    }
}

fun RBuilder.index() = child(Index::class) {}
