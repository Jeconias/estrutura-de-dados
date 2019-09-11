package classes.ordenacao;

public class Heap{
	    private int[] heapArray;
	    private int heapSize;
		
	    public Heap(int cap){
	        heapSize = 0;
	        heapArray = new int[cap+2];
	    }
	    public boolean isEmpty(){
	        return heapSize == 0;
	    }
	    public void insert(int k){
	        
	        heapArray[++heapSize] = k;
	        upheap();
	    }
	    private void upheap(){
	        int i = heapSize;
	        while(i != 1 && heapArray[i] <= heapArray[i/2]){
	            int temp = heapArray[i];
	            heapArray[i] = heapArray[i/2];
	            heapArray[i/2] = temp;
	            i/=2;
	        }
	    }
	    public int remove(){
	        int temp = heapArray[1];
	        heapArray[1] = heapArray[heapSize--];
	        downheap(1);
	        return temp;
	    }
	    private void downheap(int i){
		    int y;
	        int right = i*2+1;
	        int left = i*2;
	        if(left >= heapSize)
	            return;
	        if(right <= heapSize){
	            if(heapArray[right] < heapArray[left])
	                y = right;
	            else
	                y = left;
	        }else{
	            y = left;
	        }
	        if(heapArray[y] < heapArray[i]){
	            int temp = heapArray[y];
	            heapArray[y] = heapArray[i];
	            heapArray[i] = temp;
	        }
	        downheap(y);
	    }
	    public void displayHeap(){
	        System.out.print("\nHeap array: ");    
	        for(int i = 1; i <= heapSize; i++)
	            System.out.print(heapArray[i] +" ");
	        System.out.println("\n");
	    }
	}