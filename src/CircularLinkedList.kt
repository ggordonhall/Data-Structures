private class CircularLinkedList<T> {
    var ptr: Node<T>? = null

    fun leftInsert(info: T) {
        val newNode: Node<T> = Node(info)
        if (ptr == null) {
            newNode.next = newNode
            ptr = newNode
        } else {
            newNode.next = ptr?.next
            ptr?.next = newNode
        }
    }
}
