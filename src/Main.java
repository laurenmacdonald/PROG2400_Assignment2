public class Main {
    public static void main(String[] args) {

        // a. Insertion: at beginning, at the end, at index location in list
        LinkedList<Integer> listOfNum = new LinkedList<>();
        listOfNum.insertStart(2);
        listOfNum.insertEnd(3);
        listOfNum.insertEnd(7);
        listOfNum.insertEnd(11);
        listOfNum.insertAtIndex(2, 5);
        listOfNum.insertStart(1);
        listOfNum.insertEnd(9);
        listOfNum.insertEnd(10);
        System.out.println("List of Numbers after insertion:");
        listOfNum.printNodes();

        // b. Deletion: of first node, of last node, of given item index from list.
        listOfNum.deleteFirstNode();
        System.out.println("After deleting first node:");
        listOfNum.printNodes();
        listOfNum.deleteNodeAt(5);
        System.out.println("After deleting 5th index:");
        listOfNum.printNodes();
        listOfNum.deleteLastNode();
        System.out.println("After deleting last node:");
        listOfNum.printNodes();

        // c. Split list into two sub lists - front and back half. Should be {2, 3, 5} and {7, 11}
        LinkedList<Integer> frontHalf = new LinkedList<>();
        LinkedList<Integer> backHalf = new LinkedList<>();
        listOfNum.frontBackSplit(listOfNum, frontHalf, backHalf);
        System.out.println("Front half:");
        frontHalf.printNodes();
        System.out.println("Back half:");
        backHalf.printNodes();

        // d. Given two lists, sort them independently and then merge as list.
        LinkedList<Integer> firstList = new LinkedList<>();
        LinkedList<Integer> secondList = new LinkedList<>();
        LinkedList<Integer> mergedList = new LinkedList<>();

        // first list - already sorted
        firstList.insertEnd(1);
        firstList.insertEnd(2);
        firstList.insertEnd(3);
        firstList.insertEnd(4);
        firstList.insertEnd(5);
        // second list - needs to be sorted
        secondList.insertEnd(10);
        secondList.insertEnd(9);
        secondList.insertEnd(8);
        secondList.insertEnd(7);
        secondList.insertEnd(6);
        System.out.println("First List: ");
        firstList.printNodes();
        System.out.println("Second list: ");
        secondList.printNodes();

        // sorting second list
        LinkedList<Integer> sortedSecondList = secondList.mergeSort(secondList);
        System.out.println("Sorted Second List: ");
        sortedSecondList.printNodes();

        // merging first list and sorted second list
        System.out.println("Merged: ");
        mergedList = mergedList.mergeSortedLists(firstList, sortedSecondList);
        mergedList.printNodes();


    }
}