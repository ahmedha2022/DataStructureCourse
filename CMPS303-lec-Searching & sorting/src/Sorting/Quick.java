package Sorting;

public class Quick {

	
	1 /** Sort the subarray S[a..b] inclusive. */
	2 private static <K> void quickSortInPlace(K[ ] S, Comparator<K> comp,
	3 int a, int b) { 4 if (a >= b) return; // subarray is trivially sorted
	5 int left = a;
	6 int right = b−1;
	7 K pivot = S[b];
	8 K temp; // temp object used for swapping
	9 while (left <= right) { 10 // scan until reaching value equal or larger than pivot (or right marker)
	11 while (left <= right && comp.compare(S[left], pivot) < 0) left++;
	12 // scan until reaching value equal or smaller than pivot (or left marker)
	13 while (left <= right && comp.compare(S[right], pivot) > 0) right−−;
	14 if (left <= right) { // indices did not strictly cross
	15 // so swap values and shrink range
	16 temp = S[left]; S[left] = S[right]; S[right] = temp;
	17 left++; right−−;
	18 } 19 } 20 // put pivot into its final place (currently marked by left index)
	21 temp = S[left]; S[left] = S[b]; S[b] = temp;
	22 // make recursive calls
	23 quickSortInPlace(S, comp, a, left − 1);
	24 quickSortInPlace(S, comp, left + 1, b);
	25 }
}
