package program1;
import java.util.Random;
	// Java program for implementations of QuickSort
	public class p1

	{
	/* This method takes last element as pivot, places the pivot element
	 at its correct position in sorted array, and places all smaller
	 (smaller than pivot) to left of pivot and all greater elements
	 to the right of pivot.
	 This is most-frequently seen implementation of QuickSort partition,
	 and this is also known as the Lomuto partition */
	 int partition(int arr[], int low, int high)
	 {
	 int pivot = arr[high]; //pivot is rightmost element
	 int i = (low - 1); // index of smaller element
	 for (int j = low; j < high; j++)
	 {
	 // If current element is smaller than or
	 // equal to pivot
	 if (arr[j] <= pivot)
	 {
	 i++;
	 // swap arr[i] and arr[j]
	 int temp = arr[i];
	 arr[i] = arr[j];
	 arr[j] = temp;
	 }
	 }
	 // swap arr[i+1] and arr[high] (or pivot)
	 int temp = arr[i + 1];
	 arr[i + 1] = arr[high];
	 arr[high] = temp;
	 return i + 1;
	 }
	 /* The main method that implements QuickSort()
	 arr[] --> Array to be sorted,
	 low --> Starting index,
	 high --> Ending index.
	 This sorts the array, and returns the time (in ms) it takes to run */
	 long sort(int arr[], int low, int high)
	 {
	 long startTime = System.currentTimeMillis();
	 if (low < high)
	 {
	 /* partIdx is partitioning index, arr[partIdx] is now at right place */
	 int partIdx = partition(arr, low, high);
	 // Recursively sort elements before partition and after partition
	 sort(arr, low, partIdx - 1); //sorts left half
	 sort(arr, partIdx + 1, high); //sorts right half
	 }
	 return System.currentTimeMillis() - startTime; //returns how long it took
	 }

	 /* The main method that implements QuickSort() with Hoare partitioning
	 TODO: Implement this method and make a new method called partitionHoare
	 that is conceptually similar to the partition method in this class.
	 But instead of using the "default" (Lomuto) partitioning use
	 the Hoare partitioning, as described in Prof. David Taylor's
	 https://www.youtube.com/watch?v=v-1EGgaTFuw
	 and elsewhere.
	 This sorts the array, and returns the time (in ms) it takes to run */
	 
	 int partitionHoare(int arr[], int low, int high)
	 {
		 int pivot = arr[low];
		 int a = low - 1;
		 int b = high + 1;
		 
		 while(true)
		 {
			 do
			 {
				 a++;
		 } while(arr[a]<pivot); //does this while left side array value is smaller than pivot
			
			 do
				 {
					 b--;
				 } while(arr[b]>pivot); //decrements while right side array value is larger than pivot
	 if (a>=b)
	 {
		return b; 
	 }
	 
	 int temp = arr[a];
	 arr[a] = arr[b];
	 arr[b] = temp;
	 
		 }
		 }
	 
	long sortHoare(int arr[], int low, int high)
	 {
	 // temporary, replace this
	 
	 long startTime = System.currentTimeMillis();
	 //return System.currentTimeMillis() - startTime;
	 // TODO...
	 if (low < high)
	 {
		 int pIndex = partition(arr, low, high);
		 
		 sort(arr, low, pIndex);
		 sort(arr, pIndex+1, high);
	 }
		 
		 long endTime = System.currentTimeMillis();
		 return endTime - startTime;
	 }
	 /* This is a method to print array of size n.
	 * NOTE: use of this method is optional.
	 * But this can be helpful to debug your code to make sure it really sorts.
	 * If you reduce the main's NUM_ITEMS to some manageable number
	 * (like 20 or whatever) you can debug your code, and then
	 * reset main's NUM_ITEMS to a large value to make your measurements */
	 static void printArray(int arr[])
	 {
	 int n = arr.length;
	 for (int i = 0; i < n; ++i)
	 {
	 System.out.print(arr[i] + " ");
	 }
	 System.out.println();
	 }
	 /* method to get an already sorted array of size arraySize */
	 static int[] getAscendingArray(int arraySize)
	 {
	 int[] newArray = new int[arraySize];
	 for (int i = 0; i < arraySize; i++)
	 {
	 newArray[i] = i * 3; // arbitrarily increment by 3 each time
	 }
	 return newArray;
	 }
	 /* method to get an array of size arraySize in descending order */
	 static int[] getDescendingArray(int arraySize)
	 {
	 int[] newArray = new int[arraySize];
	 int n = 0;
	 for (int i = arraySize - 1; i >= 0; i--)
	 {
	 n += 4; // arbitrarily increment from end by 4 each time
	 newArray[i] = n ; // gets the array in descending order
	 }
	 return newArray;
	 }

	 /* method to get an array of size arraySize in descending order */
	 static int[] getRandomArray(int arraySize)
	 {
	 Random rand = new Random();
	 // Setting upper bound to generate random numbers in specific range
	 int upperbound = 1000000;
	 int[] newArray = new int[arraySize];
	 for (int i = 0; i < arraySize; i++)
	 {
	 // Generating random values from 0 - 999999 using nextInt()
	 newArray[i] = rand.nextInt(upperbound); 
	 }
	 return newArray;
	 }
	 /* method to get an array of size arraySize with all values the same */
	 static int[] getSameArray(int arraySize)
	 {
	 int[] newArray = new int[arraySize];
	 for (int i = 0; i < arraySize; i++)
	 {
	 newArray[i] = 42; // arbitrary value, same for all elements
	 }
	 return newArray;
	 }
	 // main driver program
	 
	 public static void main(String args[])
	 {
	 // NOTE: if you get StackOverflowError then decrease NUM_ITEMS below
	 final int NUM_ITEMS = 1000;
	 p1 ob = new p1();

	 int arr[] = getAscendingArray(NUM_ITEMS);
	 long ascTime = ob.sort(arr, 0, NUM_ITEMS - 1);
	 arr = getDescendingArray(NUM_ITEMS);
	 long descTime = ob.sort(arr, 0, NUM_ITEMS - 1);
	 arr = getRandomArray(NUM_ITEMS);
	 long randomTime = ob.sort(arr, 0, NUM_ITEMS - 1);
	 //printArray(arr); // NOTE: can verify sorted correctly (for small arrays)

	 arr = getSameArray(NUM_ITEMS);
	 long sameTime = ob.sort(arr, 0, NUM_ITEMS - 1);
	 System.out.println("QuickSort times using Lomuto (default) partitioning follow:");
	 System.out.println("sorted asc array, time in ms: " + Long.toString(ascTime));
	 System.out.println("sorted desc array, time in ms: " + Long.toString(descTime));
	 System.out.println("sorted random array, time in ms: " + Long.toString(randomTime));
	 System.out.println("sorted same values array, time: " + Long.toString(sameTime));

	 arr = getAscendingArray(NUM_ITEMS);
	 ascTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);
	 arr = getDescendingArray(NUM_ITEMS);
	 descTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);
	 arr = getRandomArray(NUM_ITEMS);
	 randomTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);
	 //printArray(arr); // NOTE: can verify sorted correctly (for small arrays)

	 arr = getSameArray(NUM_ITEMS);
	 sameTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);

	 System.out.println("\nQuickSort times using Hoare partitioning follow:");
	 System.out.println("sorted asc array, time in ms: " + Long.toString(ascTime));
	 System.out.println("sorted desc array, time in ms: " + Long.toString(descTime));
	 System.out.println("sorted random array, time in ms: " + Long.toString(randomTime));
	 System.out.println("sorted same values array, time: " + Long.toString(sameTime));
	 }
	}


