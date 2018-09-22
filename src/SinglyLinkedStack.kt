import java.nio.BufferUnderflowException

private class SinglyLinkedStack<T> {
    var head: Node<T>? = null

    fun push(info: T) {
        val newNode = Node(info)
        newNode.next = head
        head = newNode
    }

    fun pop(): T? {
        if (head == null) {
            throw BufferUnderflowException()
        }
        val temp = head
        head = head?.next
        return temp?.value
    }

    fun peek(): T? {
        if (head == null) {
            throw BufferUnderflowException()
        }
        return head?.value
    }
}

fun main(args: Array<String>) {
    val myStack: SinglyLinkedStack<Int> = SinglyLinkedStack()
    val infoArray = arrayOf(3, 7, 1, 33, 9, 112)
    for (elem in infoArray) {
        myStack.push(elem)
    }
    println(myStack.peek())
    println(myStack.pop())
}