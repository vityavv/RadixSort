import java.util.Random;
import java.util.ArrayList;
public class VTest {
	public static void main(String[] args) {
		//testing only positive
		Random rng = new Random();
		SortableLinkedList myList = new SortableLinkedList();
		for (int i = 0; i < 1000; i++) {
			myList.add(Math.abs(rng.nextInt()));
		}
		Radix.radixSortSimple(myList);
		System.out.println(checkSorted(myList));

		SortableLinkedList testList = new SortableLinkedList();
		for (int i = -5; i <= 5; i++) {
			testList.add(i);
		}
		Radix.radixSort(testList);
		System.out.println(testList.toString());
	}
	public static boolean checkSorted(SortableLinkedList list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i+1)) return false; //inefficient, to do is to fix
		}
		return true;
	}
}
