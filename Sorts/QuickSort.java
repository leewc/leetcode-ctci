import java.util.Arrays;

public class QuickSort {

	/**************************************************************************************/
	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(int[] array, int low, int high) {
		int partition = partition(array, low, high); //both partition methods work here
		if(low < partition - 1)
			quickSort(array, low, partition - 1);
		if(high > partition)
			quickSort(array, partition, high);
	}

	private int partition(int[] array, int low, int high) {
		int pivot = array[(low + high) /2];
		//keep doing this until we meet at a partition point
		while(low <= high) {
			//find next out of place values in low and high
			while(array[low] < pivot) low++;
			while(array[high] > pivot) high--;

			if(low <= high) { //swap values at indexes
				int swap = array[low];
				array[low] = array[high];
				array[high] = swap;  

				//shift low and high since we can move on from values we already swapped
				low++;
				high--;
			}
		}
		return low; //or high, doesn't matter, this is where the pivot should be
	}
	/**************************************************************************************/


	/**************************************************************************************/
	public void quickSortTwo(int[] array) {
		quickSortTwo(array, 0, array.length - 1);
	}

	private void quickSortTwo(int[] array, int low, int high) {
		if(low < high) {
			int partition = partition2(array, low, high); //both partition methods work here
			quickSortTwo(array, low, partition - 1); //note the minus 1 here
			quickSortTwo(array, partition + 1, high); //note the plus 1 here, since partition is already in the right place
		}
	}

	private int partition2(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low; //or i can just increment low and later return
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				//swap i and j
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				//essentially push value at j to left side of partition
				i++; 
			}
		}
		//finally swap pivot value (array[high]) with value at i (i.e the partition)
		array[high] = array[i];
		array[i] = pivot; 

		return i;
	}

	/**************************************************************************************/

	public static void main(String args[]) {
		int[] a = {6,5,1,2,9,7,0};
		QuickSort app = new QuickSort();
		System.out.println("Before sort: " + Arrays.toString(a));
		app.quickSort(a);
		System.out.println("After sort: " + Arrays.toString(a));

	}
}