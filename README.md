# Doubly Linked List Data Structure

> **Completed for PROG2400 Assignment 2**
> 
> Lauren MacDonald, March 2024
> 
> **Languages/Concepts**: Java, Data structures, linked lists

## Class and Methods
### Node< T > Static Class
- Takes parameter< T >, using generic types to allow user to work with any data type.
- Has next object for pointer reference, and data that is stored.
#### Attributes
- **T data**: data of generic type held by the node
- **Node< T > next**: pointer reference to the node next to this node.

### LinkedList< T > Class
- Takes parameter of generic type, using generic types to allow for the list to work with any data type
- Singly Linked list class.
- Contains references to next (head) node in the sequence. Works with a Node<T> class.
#### Attributes
- **Node< T > head**: will point to the first node in list.

#### Methods
#### isEmpty and printNodes
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/9d81ee9b-d202-4f3e-a90c-3aed42640673)


#### insert methods
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/56bf4e89-2313-4af0-8363-36b1c908a9d7)
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/2f215935-32cd-45ae-a1ac-0705eec8d8d5)



#### delete methods
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/07e203bf-d2c1-420f-b346-5a303d65b30a)
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/b42931dd-3470-4843-a6d3-91a4f681045f)



#### front back split method
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/b83da8e6-56c5-4b3c-bd7b-e09ce0c6749d)


#### merge sort method (sorts an unsorted list via merge sort algorithm)
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/c8db0274-9680-4e5c-b613-7f3eb3f75886)


#### merge sorted list (merges two already sorted lists)
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/c847ff09-d182-4c78-80d0-8890b356556e)



## Example of Program Output
![image](https://github.com/laurenmacdonald/PROG2400_Assignment2/assets/117761702/a06947a9-118f-4ce5-857a-d05bf5c01819)

