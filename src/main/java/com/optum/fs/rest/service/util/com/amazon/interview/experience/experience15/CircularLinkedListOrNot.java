package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import com.optum.fs.rest.service.util.problems.LinkedListService;

public class CircularLinkedListOrNot {
    public static void main(String[] args) {
        LinkedListService service = new LinkedListService();
        service.createNodeIntheBegining(10);
        service.insertAfter(20,10);
        service.insertAfter(30,20);
       findIfCircular(LinkedListService.head);
    }

    private static void findIfCircular(LinkedListService.Node head) {
        if(head == null)
            return;
        LinkedListService.Node next = LinkedListService.getNext(head);
        for(LinkedListService.Node x=next;x!=null;x=LinkedListService.getNext(x)){

        }
    }
}
