import index.index
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

class Router : RComponent<RProps, RState>() {
    override fun RBuilder.render(){
        browserRouter {
            switch {
                route("/", exact = true){
                    index()
                }

                route("/chat", exact = true){
                    h1{
                        +"Hello World"
                    }
                }
            }
        }
    }
}

fun RBuilder.router() = child(Router::class){}
