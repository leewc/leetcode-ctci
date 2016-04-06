import java.util.Arrays;

public class HeapSort {
	
	int heapSize; //set by calling build max heap
	
	public void heapSort(int[] array) {
		build_max_heap(array);
		for(int i = heapSize; i > 0; i--)
		{
			//swap 0 with i
			swap(array, 0, i);
			heapSize--;
			max_heapify(array, 0);
		}
	}
	
	private void build_max_heap(int[] array) {
		//build max heap
		heapSize = array.length - 1;
		for(int i = heapSize/ 2; i >= 0; i--) // notice it's half down to one.
		    max_heapify(array, i);
	}

	//max heapify
	private void max_heapify(int[] A, int i) {
		//apprently starting with these also don't matter (Well, it worked)
		// int left = 2 * i;
		// int right = 2 * i + 1;
		
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		int largest = i;
		if (left <= heapSize && A[left] > A[i])
			largest = left;
		if (right <= heapSize && A[right] > A[largest])
			largest = right;
		//exchange if needed here we swap without temp var
		if(largest != i) { 
			swap(A, i, largest);
			max_heapify(A, largest);
		}

	}
	
	private void swap(int[] A, int i, int j) {
		A[i] -= A[j];
		A[j] += A[i];
		A[i] = A[j] - A[i];
	}

	public static void main(String args[]) {
	    HeapSort app = new HeapSort();
	    // int[] array = {4, 5, 6, 1, 8, 10, 0};
	    int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
	    System.out.println("Before Sort: " + Arrays.toString(array));
	    app.heapSort(array);
	    System.out.println("After Sort: " + Arrays.toString(array));

	}
}