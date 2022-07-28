import com.revature.CustomArrayList;
import com.revature.CustomLinkedList;
import com.revature.CustomList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Custom linked list tests: ");
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Zero");
        customLinkedList.add("One");
        customLinkedList.add("Two");
        customLinkedList.add("Three");


        System.out.println("testing add: ");
        for (String str : customLinkedList) {
            System.out.println(str);
        }


        System.out.println("testing get... ");
        System.out.println(customLinkedList.get(1));


        System.out.println("testing remove: ");
        customLinkedList.remove(4);
        customLinkedList.remove(2);
        customLinkedList.remove(0);

        for (String str : customLinkedList) {
            System.out.println(str);
        }

        System.out.println("testing clear: ");
        customLinkedList.clear();
        for (String str : customLinkedList) {
            System.out.println(str);
        }


        System.out.println("testing remove(E e)...");
        customLinkedList.add("Zero");
        customLinkedList.add("One");
        customLinkedList.add("Two");
        customLinkedList.add("Three");

        customLinkedList.remove("Zero");
        customLinkedList.remove("Two");

        for (String str : customLinkedList) {
            System.out.println(str);
        }




    }
}
