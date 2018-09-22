import java.nio.BufferUnderflowException

data class Node<T>(var value: T) {
    var next: Node<T>? = null
}

private class SinglyLinkedList<T> {
    var head: Node<T>? = null

    fun leftInsert(info: T) {
        val newNode = Node(info)
        newNode.next = head
        head = newNode
    }

    fun rightInsert(info: T) {
        val newNode = Node(info)
        if (head == null) {
            head = newNode
        } else {
            var pointer = head
            while (pointer?.next != null) {
                pointer = pointer.next
            }
            pointer?.next = newNode
        }
    }

    fun leftDelete(): T? {
        if (head == null) {
            throw BufferUnderflowException()
        }
        val temp = head
        head = head?.next
        return temp?.value
    }

    fun rightDelete(): T? {
        if (head == null) {
            throw BufferUnderflowException()
        } else {
            var pointerA = head
            var pointerB = head
            while (pointerA?.next != null) {
                pointerB = pointerA
                pointerA = pointerA.next
            }
            pointerB?.next = null
            return pointerA?.value
        }
    }

    fun sequentialPrint() {
        var pointer = head
        while (pointer != null) {
            println(pointer.value)
            pointer = pointer.next
        }
    }
}

fun main(args: Array<String>) {
    val infoArray = arrayOf(3, 7, 1, 33, 9, 112)
    val linkedList: SinglyLinkedList<Int> = SinglyLinkedList()
    for (elem in infoArray) {
        linkedList.rightInsert(elem)
    }
    linkedList.sequentialPrint()
    val deletedNode = linkedList.rightDelete()
    println("\nThe deleted node is $deletedNode")
}




