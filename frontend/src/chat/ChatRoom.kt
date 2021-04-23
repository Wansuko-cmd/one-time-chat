package chat

import org.w3c.dom.WebSocket
import react.*
import react.dom.h1
import react.dom.script

interface ChatState : RState{
    var chatList: MutableList<ChatData>
}

class ChatRoom : RComponent<RProps, ChatState>() {

    override fun ChatState.init(){
        chatList = mutableListOf()
    }

    private fun getMessage(){
        val connection = WebSocket("ws://localhost:8000/chat/hash")

        connection.onmessage = {
            console.log(it.data)
            setState{
                chatList.add(ChatData("test", it.data.toString()))
            }
        }
    }

    override fun componentDidMount() {
        val connection = WebSocket("ws://localhost:8000/chat/hash")

        connection.onmessage = {
            console.log(it.data)
            setState{
                chatList.add(ChatData("test", it.data.toString()))
            }
        }
    }

    override fun RBuilder.render(){

        state.chatList.forEach { chatData ->
            h1{
                +"${chatData.name} : ${chatData.content}"
            }
        }
        h1{
            +"TEST"
        }
    }
}

fun RBuilder.chatRoom() = child(ChatRoom::class) {}
