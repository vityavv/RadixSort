public class Radix {
	public static int nth(int n, int col) {
		return Math.abs((n / (int) Math.pow(10,col)) % 10);
	}
	public static int length(int n) {
		return (int) Math.log10(n) + 1;
	}
	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (SortableLinkedList bucket : buckets) {
			original.extend(bucket);
		}
	}
	public static void radixSortSimple(SortableLinkedList data) {
		SortableLinkedList[] buckets = new SortableLinkedList[10];
		for (int i = 0; i < 10; i++) buckets[i] = new SortableLinkedList();
		int digitOn = 0;
		int length = -1;
		do {
			while (data.size() > 0) {
				int newInt = data.remove(0);
				if (length < length(newInt)) length = length(newInt);
				buckets[nth(newInt, digitOn)].add(newInt);
			}
			merge(data, buckets);
			digitOn++;
		} while (digitOn < length);
	}
	public static void radixSort(SortableLinkedList data) {
		SortableLinkedList negatives = new SortableLinkedList();
		SortableLinkedList positives = new SortableLinkedList();
		while (data.size() > 0) {
			int newInt = data.remove(0);
			if (newInt < 0) {
				negatives.add(-1 * newInt);
			} else {
				positives.add(newInt);
			}
		}

		radixSortSimple(negatives);
		radixSortSimple(positives);

		SortableLinkedList newNegatives = new SortableLinkedList();
		while (negatives.size() > 0) {
			newNegatives.add(-1 * negatives.remove(negatives.size()-1));
		}

		data.extend(newNegatives);
		data.extend(negatives);
		data.extend(positives);
	}
}
