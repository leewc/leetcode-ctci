import java.util.Arrays;

public class MergeSort {
	
	// keep forgetting merge sort is not in-place fml
	public void mergeSort(int[] array) {
		int[] tmp = new int[array.length];
		mergeSort(array, 0, array.length - 1);
	}

	public void mergeSort(int[] array, int start, int end) {
		//do nothing or return if end - start is <= 0
		if(start < end) { //this is wrong: end - start > 1
			int mid = start + (end - start) / 2;

			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
		}
	}

	public void merge(int[] array, int start, int mid, int end) {
		int lenl = mid - start + 1;
		int lenr = end - mid;

		int[] left = new int[lenl];
		int[] right = new int[lenr];

		for(int i = 0; i < lenl; i++)
			left[i] = array[start + i];
		for(int i = 0; i < lenr; i++)
			right[i] = array[mid + i + 1];

		int i = start;
		int l = 0; int r = 0;
		while(l < lenl && r < lenr)	{
			if(left[l] <= right[r]) {
				array[i] = left[l];
				l++;
			}
			else {
				array[i] = right[r];
				r++;
			}
			i++;
		}
		while(l < lenl)
			array[i++] = left[l++];
		//no need to copy right half since it's already there
		// while(r < lenr)
		// 	array[i++] = right[r++];
	}

	public static void main(String args[]) {
		MergeSort app = new MergeSort();
		int[] numbers = {5,10,7,8,10,2,9};

		System.out.println("Before Sort: " + Arrays.toString(numbers));
		app.mergeSort(numbers);
		System.out.println("After Sort: " + Arrays.toString(numbers));

	}
}

	//SHITTY CODE THAT DOESN'T WORK
	// public void merge(int[] array, int start, int mid, int end) {
	// 	int[] left = new int[mid - start];
	// 	int[] right = new int[end - start + 1];

	// 	for(int i = 0; i < mid - start; i++)
	// 	{
	// 		left[i] = array[start + i];
	// 	}
	// 	for(int i = 0; i < end - mid; i++)
	// 		right[i] = array[mid + i];

	// 	int i_left = 0;
	// 	int i_right = 0;

	// 	System.out.println(Arrays.toString(left));
	// 	System.out.println(Arrays.toString(right));

	// 	for(int i = start; i < end; i++)
	// 	{
	// 		if(left[i_left] < right[i_right]){
	// 			array[i] = left[i_left];
	// 			i_left++;
	// 		}
	// 		else {
	// 			array[i] = right[i_right];
	// 			i_right++;
	// 		}
	// 	}
	// }
	// public void merge(int[] array, int start, int mid, int end) {
	// 	int[] scratch = new int[end];
	// 	for(int i = start; i < end; i++)
	// 		scratch[i] = array[i];

	// 	while(start < mid && mid < end) {
	// 		if(scratch[start] < scratch[mid]) {
	// 			array[start] = scratch[start];
	// 			start++;
	// 		}
	// 		else
	// 		{
	// 			array[mid] = scratch[mid];
	// 			mid++;
	// 		}
	// 	}
	// 	while(start < mid) {
	// 		array[start] = scratch[start];
	// 		start++;
	// 	}
	// 	while(mid < end) {
	// 		array[mid] = scratch[mid];
	// 		mid++;
	// 	}
	// }
	// public void merge(int[] array, int start, int mid, int end) {
	// 		int[] left = new int[mid - start];
	// 		int[] right = new int[end - mid];

	// 		for(int i = 0; i <= mid - start; i++)
	// 			left[i] = array[start + i];
	// 		for(int i = 0; i <= end - mid; i++)
	// 			right[i] = array[mid + i];

	// 		System.out.println(Arrays.toString(left));
	// 		System.out.println(Arrays.toString(right));
	// 		System.out.println();

	// 		int l = 0;
	// 		int r = 0;
	// 		int i = start;

	// 		while(l != left.length && r != right.length)
	// 		{
	// 			if(left[l] <= right[r]) {
	// 				array[i] = left[l];
	// 				l++;
	// 			}
	// 			else {
	// 				array[i] = right[r];
	// 				r++;
	// 			}
	// 			i++;
	// 		}
	// 		while(l != left.length) {
	// 			array[i] = left[l];
	// 			l++;
	// 			i++;
	// 		}
	// 		while(r != right.length) {
	// 			array[i] = right[r];
	// 			r++;
	// 			i++;
	// 		}
	// 	}
	// public void merge(int[] array, int[] tmp, int start, int mid, int end) {
	// 	for(int i = 0; i < helper.length; i++)
	// 		helper[i] = array[start + i];

	// 	int l = 0;
	// 	int m = mid - start + 1;
	// 	int i = start;

	// 	while(l <= mid - start + 1 && m <= helper.length) {
	// 		if(helper[l] <= helper[m]) {
	// 			array[i] = helper[l];
	// 			l++;
	// 		}
	// 		else {
	// 			array[i] = helper[m];
	// 			m++;
	// 		}
	// 		i++;
	// 	}
	// 	while(l <= mid - start + 1) {
	// 		array[i] = helper[l];
	// 		i++;
	// 		l++;
	// 	}
	// 	while(m < helper.length){
	// 		array[i] = helper[m];
	// 		m++;
	// 		i++;
	// 	}
	// } 
	// public void merge(int[] array, int start, int mid, int end) {
	// 		int m = mid;
	// 		int i = start;
	// 		int k = start;
	// 		while(start < mid && m <= end) {
	// 			if(array[start] <= array[m]) {
	// 				tmp[i] = array[start];
	// 				start++;
	// 			}
	// 			else {
	// 				tmp[i] = array[m];
	// 				m++; 
	// 			}
	// 			i++;
	// 		}

	// 		while(start < mid)
	// 			tmp[i++] = array[start++];
	// 		while(m <= end)
	// 			tmp[i++] = array[m++];

	// 		System.out.println(Arrays.toString(tmp));

	// 		while(k < i) {
	// 			array[k] = tmp[k];
	// 			k++;
	// 		}
	// 	} 