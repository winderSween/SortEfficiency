
import java.lang.*;
import java.util.Random;
public class assignment4 {

	public static void main(String argv[])
	{
		long sum=0;
		Random r=new Random(10);
		int[] list=new int[100000];
		for(int ii=0;ii<10;ii++){
		for(int i=0;i<10000;i++)
			list[i]=r.nextInt()/100000;
		long startTime=System.currentTimeMillis();
		heapSort(list);
		long endTime=System.currentTimeMillis();
		sum=sum+(-startTime+endTime);
		}
		System.out.println("the list[10000] run time "+(sum/10)+"ms");
		sum=0;
		for(int ii=0;ii<10;ii++){
			for(int i=0;i<20000;i++)
				list[i]=r.nextInt()/100000;

			long startTime=System.currentTimeMillis();
			heapSort(list);
			long endTime=System.currentTimeMillis();
			sum=sum+(-startTime+endTime);
			}
			System.out.println("the list[20000] run time "+(sum/10)+"ms");
			sum=0;
			for(int ii=0;ii<10;ii++){
				for(int i=0;i<30000;i++)
					list[i]=r.nextInt()/100000;

					long startTime=System.currentTimeMillis();
					heapSort(list);
					long endTime=System.currentTimeMillis();
					sum=sum+(-startTime+endTime);
					}
					System.out.println("the list[30000] run time "+(sum/10)+"ms");
					sum=0;
					for(int ii=0;ii<10;ii++){
						for(int i=0;i<40000;i++)
							list[i]=r.nextInt()/100000;

							long startTime=System.currentTimeMillis();
							heapSort(list);
							long endTime=System.currentTimeMillis();
							sum=sum+(-startTime+endTime);
							}
							System.out.println("the list[40000] run time "+(sum/10)+"ms");
			sum=0;
			for(int ii=0;ii<10;ii++){
				for(int i=0;i<50000;i++)
					list[i]=r.nextInt()/100000;

				long startTime=System.currentTimeMillis();
				heapSort(list);
				long endTime=System.currentTimeMillis();
				sum=sum+(-startTime+endTime);
				}
				System.out.println("the list[50000] run time "+(sum/10)+"ms");
			
		
	}
	
//====================================================================================
	public static void insertionSort(int[] data) {
        for (int index = 1; index < data.length; index++) {
            int key = data[index];
            int position = index;
            // shift larger values to the right
            while (position > 0 && data[position - 1] > key) {
                data[position] = data[position - 1];
                position--;
            }
            data[position] = key;
        }
    }
//====================================================================================	
	public static void bubbleSort(int[] data) {
        int temp = 0;
        for (int i = data.length - 1; i > 0; --i) {
            boolean isSort = false;
            for (int j = 0; j < i; ++j) {
                if (data[j + 1] < data[j]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isSort = true; 
                }
            }
            if (!isSort)
                break;
        }
    }
//====================================================================================
	public static void selectSort(int[] data) {
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < data.length; i++) {
            minIndex = i; 
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }
//==================================================================================
	public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int half = arr.length / 2;
        int[] arr1 = new int[half];
        int[] arr2 = new int[arr.length - half];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, half, arr2, 0, arr2.length);
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        return mergeSortSub(arr1, arr2);
    }
  public static int[] mergeSortSub(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                if (++i > arr1.length - 1) {
                    break;
                }
            } else {
                result[k] = arr2[j];
                if (++j > arr2.length - 1) {
                    break;
                }
            }
            k++;
        }
        for (; i < arr1.length; i++) {
            result[++k] = arr1[i];
        }
        for (; j < arr2.length; j++) {
            result[++k] = arr2[j];
        }
        return result;
    }
  //===============================================================
  static int partition(int arr[], int left, int right)
  {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
       
        while (i <= j) {
              while (arr[i] < pivot)
                    i++;
              while (arr[j] > pivot)
                    j--;
              if (i <= j) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
              }
        };
       
        return i;
  }
   
  static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
              quickSort(arr, left, index - 1);
        if (index < right)
              quickSort(arr, index, right);
  }
  //============================================================================
  public static void exchangeElements(int[] array, int index1, int index2) {  
      int temp = array[index1];  
      array[index1] = array[index2];  
      array[index2] = temp;  
  }
  public static void heapSort(int[] array) {  
      if (array == null || array.length <= 1) {  
          return;  
      }  

      buildMaxHeap(array);  

      for (int i = array.length - 1; i >= 1; i--) {  
          exchangeElements(array, 0, i);  

          maxHeap(array, i, 0);  
      }  
  }  

  private static void buildMaxHeap(int[] array) {  
      if (array == null || array.length <= 1) {  
          return;  
      }  

      int half = array.length / 2;  
      for (int i = half; i >= 0; i--) {  
          maxHeap(array, array.length, i);  
      }  
  }  

  private static void maxHeap(int[] array, int heapSize, int index) {  
      int left = index * 2 + 1;  
      int right = index * 2 + 2;  

      int largest = index;  
      if (left < heapSize && array[left] > array[index]) {  
          largest = left;  
      }  

      if (right < heapSize && array[right] > array[largest]) {  
          largest = right;  
      }  

      if (index != largest) {  
          exchangeElements(array, index, largest);  

          maxHeap(array, heapSize, largest);  
      }  
  }  
}  


