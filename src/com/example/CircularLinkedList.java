package com.example;


/**
 * Returns the node at the start of a loop in the given circular linked
 * list. A circular list is one in which a node's next pointer points
 * to an earlier node, so as to make a loop in the linked list. For
 * instance:
 *
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 *
 * (CCI_0205)
 *
 * @param linkedList
 *            list to be tested
 * @return the node at the start of the loop if there is a loop, null
 * otherwise
 * ref: http://umairsaeed.com/2011/06/23/finding-the-start-of-a-loop-in-a-circular-linked-list/
 */
 
public class CircularLinkedList{

  public static IntegerNode findLoopStart(LinkedList linkedList) {
      if (linkedList == null || linkedList.getHead() == null) {
          return null;
      }
   
      IntegerNode loopStartNode = null;
      IntegerNode slow = linkedList.getHead();
      IntegerNode fast = linkedList.getHead();
   
      while (slow != null && fast != null) {
          slow = slow.getNext();
          if (fast.getNext() == null) {
              loopStartNode = null;
              break;
          }
          fast = fast.getNext().getNext();
   
          // If slow and fast point to the same node, it means that the
          // linkedList contains a loop.
          if (slow == fast) {
   
              slow = linkedList.getHead();
   
              while (slow != fast) {
                  // Keep incrementing the two pointers until they both
                  // meet again. When this happens, both the pointers will
                  // point to the beginning of the loop
                  slow = slow.getNext(); // Can't be null, as we have a loop
                  fast = fast.getNext(); // Can't be null, as we have a loop
              }
   
              loopStartNode = slow;
              break;
          }
      }
   
      return loopStartNode;
  }
}
