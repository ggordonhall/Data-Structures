import java.util.*

private class BinaryTree<T : Comparable<T>>(var info: T? = null) {
    private var left: BinaryTree<*>? = null
    private var right: BinaryTree<*>? = null

    fun preOrderTraverse() {
        println(info)
        left?.preOrderTraverse()
        right?.preOrderTraverse()
    }

    fun inorderTraverse() {
        left?.inorderTraverse()
        println(info)
        right?.inorderTraverse()
    }

    fun postOrderTraverse() {
        left?.postOrderTraverse()
        right?.postOrderTraverse()
        println(info)
    }

    fun preOrderIterativeTraverse() {
        var pointer: BinaryTree<*>? = this
        val stack: Stack<BinaryTree<*>?> = Stack()
        while (true) {
            if (pointer?.info != null) {
                println(pointer.info)
                stack.push(pointer)
                pointer = pointer.left
            } else {
                if (stack.empty()) return
                else {
                    pointer = stack.pop()
                    pointer = pointer?.right
                }
            }
        }
    }

    fun inorderIterativeTraverse() {
        var pointer: BinaryTree<*>? = this
        val stack: Stack<BinaryTree<*>?> = Stack()
        while (true) {
            if (pointer?.info != null) {
                stack.push(pointer)
                pointer = pointer.left
            } else {
                if (stack.empty()) return
                else {
                    pointer = stack.pop()
                    println(pointer?.info)
                    pointer = pointer?.right
                }
            }
        }
    }

    fun constructTree(args: Array<T>) {
        for (arg in args) {
            this.insert(arg)
        }
    }

    private fun insert(value: T) {
        when {
            info == null -> info = value
            value < info!! -> if (left?.info == null) left = BinaryTree(value) else (left as BinaryTree<T>).insert(value)
            value > info!! -> if (right?.info == null) right = BinaryTree(value) else (right as BinaryTree<T>).insert(value)
        }
    }

    fun delete(value: T) {
        var pointerA: BinaryTree<*>? = this
        var pointerB: BinaryTree<*>? = null
        while (pointerA?.info != null && pointerA.info != value) {
            pointerB = pointerA
            pointerA = if (value < (pointerA.info as T)) pointerA.left else pointerA.right
        }
        var pointerC: BinaryTree<*>?
        when {
            pointerA?.left == null -> pointerC = pointerA?.right
            pointerA.right == null -> pointerC = pointerA.left
            else -> {
                pointerC = pointerA.right
                if (pointerC?.left == null) {
                    pointerC?.left = pointerA.left
                } else {
                    var pointerD: BinaryTree<*>? = null
                    while (pointerC?.left != null) {
                        pointerD = pointerC
                        pointerC = pointerC?.left
                    }
                    pointerD?.left = pointerC?.right
                    pointerC?.left = pointerA.left
                    pointerC?.right = pointerA.right
                }
            }
        }
        if (pointerB?.left == pointerA) {
            pointerB?.left = pointerC
        } else {
            pointerB?.right = pointerC
        }
    }
}


fun main(args: Array<String>) {
    val tree: BinaryTree<String> = BinaryTree()
    val treeTwo: BinaryTree<Int> = BinaryTree()
    val names = arrayOf("Zebedee", "Phil", "Phillip", "Jones", "Kylie", "Marshall", "Anna", "Bella", "Richard", "Toby",
            "Mark", "Jennifer", "Trevor", "Kyle")
    val numbers = arrayOf(1, 34, 34 , 11, 23, 44, 55, 1, 20, 34, 89)
    treeTwo.constructTree(numbers)
    tree.constructTree(names)

    treeTwo.inorderTraverse()

    println("\nPrinting in inorder!\n")
    tree.inorderTraverse()

    println("\nDeleting Phil!\n")
    tree.delete("Phil")

    println("\nPrinting in inorder!\n")
    tree.inorderTraverse()


//    println("\nPrinting in iterative inorder!\n")
//    tree.inorderIterativeTraverse()

//    println("\nPrinting in preorder!\n")
//    tree.preOrderTraverse()
//
//    println("\nPrinting in iterative preorder!\n")
//    tree.preOrderIterativeTraverse()

//    println("\nPrinting in postorder!\n")
//    tree.postOrderTraverse()
}

