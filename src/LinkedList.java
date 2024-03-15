/**
 * @param <T> using generic types to allow the lists to work with any data type.
 *            <br>
 *            Linked list class.
 *            Contains references to next (head) node in the sequence. Works with a Node<T> class.
 */
public class LinkedList<T> {
    Node<T> head = null; // will point to first node
    /**
     * @param <T> takes any data type.
     *            <br>
     *            Node class - has next object for pointer reference, and data that is stored.
     */
    static class Node<T> {
        T data;
        Node<T> next = null;
        // constructor
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * @return true if head is null, false if head is not null
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Print the list of nodes.
     */
    public void printNodes() {
        // If the list is empty (nothing at head) then do not continue
        if (!isEmpty()) {
            // Create current pointer to point at head to print the list in forward direction
            Node<T> current = head;
            // Check the nodes to see if the pointer is equal to head (at start) or null (empty)
            // If more than 1 node, will run the while loop, printing the data at pointer and moving the pointer to the next value.
            while (current.next != head && current.next != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            // If there is only 1 node, will run this line
            System.out.println(current.data);
        }
    }

    // ==== INSERT METHODS ====
    /**
     * @param value value to be added to the list
     *              <br>
     *              Adds new node containing value to end of list. Assigns bidirectional characteristic to the nodes (doubly linked).
     */
    public void insertEnd(T value) {
        // Create new node with data = value
        Node<T> newNode = new Node<>(value);
        // If list is empty, this will be the only node in the list
        if (head == null) {
            head = newNode;
            return;
        }
        // Go through the list to find the last item in it
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        // When more values are added, the head will stay the same and the next (newNode) will be appended after the current.
        current.next = newNode;

    }

    /**
     * @param value value to be added to the list
     *              <br>
     *              Adds new node containing value to start of list.
     */
    public void insertStart(T value) {
        // Create new node with data = value
        Node<T> newNode = new Node<>(value);
        // Set the next pointer of newNode to the head
        newNode.next = head;
        // Update the head to point at newNode
        head = newNode;
    }

    public void insertAtIndex(int index, T data) {
        // handle error if index is less than 0
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        // create a new node with the data supplied
        Node<T> newNode = new Node<T>(data);
        // if index supplied is 0, put the new node in the head position.
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        // Create a new node that points at the head
        Node<T> current = head;
        // Go through the list until reaching the index specified
        for (int i = 1; current != null && i < index; i++) {
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        // Move the nodes around to slot in the new data.
        newNode.next = current.next;
        current.next = newNode;
    }

    // ==== DELETE METHODS ====
    /**
     * Removes the first element from the list
     */
    public void deleteFirstNode() {
        if (!isEmpty()) {
            head = head.next;
        }
    }
    /**
     * Removes the last element from the list
     */
    public void deleteLastNode() {
        // Check to see if list is empty
        if (!isEmpty()) {
            // If there is only one element, make the head null (no elements in list)
            if (head.next == null) {
                head = null;
                return;
            } else {
                // If more than one element, go through the list and find the second to last node
                // and update the tail to the second to last index and set the next to null
                Node<T> secondLast = head;
                while (secondLast.next.next != null) {
                    secondLast = secondLast.next;
                }
                // Remove the last node by setting the next of second last to null
                secondLast.next = null;
            }
        }
    }

    /**
     * Removes the element at the index indicated
     */
    public void deleteNodeAt(int index) {
        // Handle errors:
        if (isEmpty()) {
            System.out.println("List is empty.");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
            // Remove the head if at first element
        } else if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        int count = 0;
        if (!isEmpty()) {
            // Locate the node before the index indicated
            while (current != null && count < index - 1) {
                current = current.next;
                count++;
            }

            // If the index is greater than the size of the list
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds.");
            }

            // Delete the node at the index when it's found
            current.next = current.next.next;
        }

    }

    /**
     * @return total number of nodes in the list
     */
    public int size() {
        int counter = 0; // initialize at 0, if list empty will return 0
        if (!isEmpty()) {
            // Create a current node, pointing at the head
            Node<T> current = head;
            counter++; // start the counter at 1 (head)
            // Loop through and update the counter.
            while (current.next != head && current.next != null) {
                counter++;
                current = current.next;
            }
        }
        return counter;
    }

    /**
     * @return the value of the first node in the list
     */
    public T head() {
        // If the list is empty, return null, otherwise return the data stored in the head.
        if (isEmpty()) {
            return null;
        } else {
            return head.data;
        }
    }

    /**
     * @return the last node in the list
     */
    public T tail() {
        // If list is empty, return null, otherwise return the data stored in the tail.
        if (isEmpty()) {
            return null;
        } else {
            Node<T> current = head;

            // Go through the list until the last node and set current as that node
            while (current.next != null) {
                current = current.next;
            }

            // Return the value of the last note
            return current.data;
        }
    }


    /**
     * @param index index to search
     * @return node value stored at the index provided
     */
    public T at(int index) {
        // Ensure index valid int and greater or equal to size of list
        if (index < 0 || index >= size()) {
            return null; // Index is invalid
        }
        // Pointer node starting pointed at the head
        Node<T> pointer = head;
        // Counter starting at 0.
        int counter = 0;
        // Loop through list until the counter is equal to the index provided and then return the data at the index
        while (pointer != null) {
            if (counter == index) {
                return pointer.data;
            }
            // Increment counter and point to the next node.
            counter++;
            pointer = pointer.next;
        }
        return null;
    }


    /**
     * @param value value to search for
     * @return true if the passed in value is in the list, false if not
     */
    public boolean contains(T value) {
        if (!isEmpty()) {
            // Set pointer node to head
            Node<T> pointer = head;
            // Loop through until pointer is null, return false if it gets to this point (no match)
            while (pointer != null) {
                // If the data of the pointer equals the value supplied, return true
                if (pointer.data == value) {
                    return true;
                }
                pointer = pointer.next;
            }
            return false;
        }
        return false;
    }

    /**
     * @param value value to search
     * @return the index of the node containing the value or nil if not found
     */
    public Integer find(T value) {
        if (!isEmpty()) {
            // Set pointer to head
            Node<T> pointer = head;
            // Start index at 0
            int index = 0;
            // Loop through until pointer is null (no match)
            while (pointer != null) {
                // If the pointer data is equal to the value supplied, return the index value
                if (pointer.data == value) {
                    return index;
                }
                // Increment the index value per loop and point to the next node in the list
                index++;
                pointer = pointer.next;
            }
            return null;
        }
        return null;
    }

    /**
     *
     * Method to split a list in half
     * @param list current working linked list to be used in recursive method
     * @param frontHalf list to store and work with front half of list
     * @param backHalf list to store and work with back half of list
     */
    public void frontBackSplit(LinkedList<T> list, LinkedList<T> frontHalf, LinkedList<T> backHalf) {
        int sizeOfList = list.size();
        int midList = sizeOfList / 2;

        Node<T> current = list.head;
        for (int i = 0; i < midList; i++) {
            current = current.next;
        }

        // Splitting the list
        frontHalf.head = list.head;
        backHalf.head = current.next;

        current.next = null;
    }


    /**
     * Method to sort a list using merge sort algorithm
     * @param linkedList to be sorted
     * @return sorted linked list
     */
    public LinkedList<Integer> mergeSort(LinkedList<Integer> linkedList) {
        // If the list is only 1 element, then just return that as it doesn't need to be sorted
        if (linkedList.size() <= 1) {
            return linkedList;
        }
        // Split the list in half
        LinkedList<Integer> frontHalf = new LinkedList<>();
        LinkedList<Integer> backHalf = new LinkedList<>();
        int midList = linkedList.size() / 2;
        for (int i = 0; i < midList; i++) {
            frontHalf.insertEnd(linkedList.at(i));
        }
        for (int i = midList; i < linkedList.size(); i++) {
            backHalf.insertEnd(linkedList.at(i));
        }
        // Use recursion to sort the two halves
        frontHalf = mergeSort(frontHalf);
        backHalf = mergeSort(backHalf);
        // Merge the sorted halves using the merge sorted lists method.
        return mergeSortedLists(frontHalf, backHalf);
    }

    /**
     * Method to merge two lists that are already sorted.
     * @param firstList list 1 to merge
     * @param secondList list 2 to merge
     * @return merged list
     */
    public LinkedList<Integer> mergeSortedLists(LinkedList<Integer> firstList, LinkedList<Integer> secondList) {
        LinkedList<Integer> mergedSortedList = new LinkedList<>();
        Node<Integer> firstCurrent = firstList.head;
        Node<Integer> secondCurrent = secondList.head;
        // Go through the lists
        while (firstCurrent != null && secondCurrent != null) {
            // Check to see if the data at in the first list's head is less than the second list's head.
            // Add the first list's head to the end of the list, then move the pointer to the next element in the list.
            // Otherwise, do the above for the second list.
            if (firstCurrent.data < secondCurrent.data) {
                mergedSortedList.insertEnd(firstCurrent.data);
                firstCurrent = firstCurrent.next;
            } else {
                mergedSortedList.insertEnd(secondCurrent.data);
                secondCurrent = secondCurrent.next;
            }
        }
        // Add any remaining elements from the first list to the merged list
        while (firstCurrent != null) {
            mergedSortedList.insertEnd(firstCurrent.data);
            firstCurrent = firstCurrent.next;
        }
        // Add any remaining elements from the second list to the merged list
        while (secondCurrent != null) {
            mergedSortedList.insertEnd(secondCurrent.data);
            secondCurrent = secondCurrent.next;
        }
        return mergedSortedList;
    }


}
