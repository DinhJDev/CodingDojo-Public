class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    /*Write a method that accepts a value and create a new node, assign it to the list head, and return a pointer to the new head node.*/
    addFront(value) {
        newNode = new Node(value); 
        newNode.next = this.head;
        this.head = newNode;
        return this
    }

    /*Write a method to remove the head node and return the new list head node. If the list is empty, return null.*/
    removeFront() {
        if (this.head == null) {
            return null;
        }
        temp = this.head;
        this.head = this.head.next;

        return this.head;
    }

    /*Write a method to return the value (not the node) at the head of the list. If the list is empty, return null.*/
    Front() {
        if (this == null) {
            return null;
        }
        return this.head.value;
    }

    view() {
        var currentNode = this.head;

        while (currentNode) {
            console.log('Current nodes value is ${currentNode.value}');

            currentNode = currentNode.next;
        }
    }
}
