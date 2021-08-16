class SLL {
    /*Create display() that returns a string containing all list values. Build what you wish console.log(myList) did!*/

    display() {
        var currentNode = this.head;

        while (currentNode) {
            console.log(currentNode.value);

            currentNode = currentNode.next;
        }
    }
}