/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackeg;

/**
 *
 * @author dell
 */
public class StackEg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Stack<Integer> stack = new Stack<Integer>(); late in first out
//        stack.push(12);
//        stack.push(13);
//        System.out.println(stack.empty());
//        System.out.println(stack.peek());
//       // System.out.println(stack.search(12));
//Queue<String> que = new LinkedList<String>(); First in and first out
//que.offer("asim");
//        que.offer("ahsan");
//        System.out.println(que.peek());
//        System.out.println(que);
//        que.size();
//        que.isEmpty();

//Queue<Double> que = new PriorityQueue<Double>();//acending order
//Queue<String> pue = new PriorityQueue<>(Collections.reverseOrder());//decending order
//que.offer(3.1);
//que.offer(3.5);
//que.offer(3.8);
//que.offer(2.1);
//que.poll();
//        System.out.println(que);
//        pue.offer("Asim");
//        pue.offer("Rahman");
//                pue.offer("asim");
//                System.out.println(pue.peek());
//        System.out.println(pue);

//LinkedList <Integer> link = new LinkedList<>();//linked list aS A sTACk if we use push method
//link.push(12);
//link.push(10);
//link.push(13);
//link.push(9);
//        System.out.println(link);


             // ArrayList<String> arr = new ArrayList<>();
           /*   DynamicArray arr = new DynamicArray(5);
              arr.add(1);
               arr.add(5);
              arr.insert(3, 8);
              System.out.println(arr);*/
           
          int[] arr = {5,8,2,9,1,0};
         // BubbleSorting(arr);
         merge(arr);
          for(int a :arr){
          System.out.print(+a+" , ");
           }
    }
     public static void merge(int[] arr){
         if(arr.length==1)
         {
             return;
         }
         
         int a[]=new int[arr.length/2];
         int b[]=new int[arr.length/2];
         for (int i = 0; i < arr.length/2; i++) 
         {
             a[i]=arr[i];
         }
         for (int i = arr.length/2-1; i < arr.length; i++) 
         {
             b[i]=arr[i];
         }
          for (int i = 0; i < a.length; i++) {
             System.out.print(" ,"+a[i]);
         }
         merge(a);
          
           System.out.println("");  
         merge(b);
         sort(a);
       
       sort(b);
       
         for (int i = 0; i < a.length; i++) {
             System.out.print(" ,"+b[i]);
         }
       
         
     }
     public static void sort(int[] arr ) {
         for (int i = 0; i < arr.length; i++) {
             int temp =i;
             for (int j = i+1; j < arr.length; j++) {
                 if(arr[i]<arr[j]){
                     temp =j;
                 }
             }
             int tem = arr[i];
             arr[i]= arr[temp];
             arr[temp]=tem;
         }
     }
    public static void BubbleSorting(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    int temp = arr[j];
                    arr[j]= arr[i];
                    arr[i]= temp;
                }
            }
        }
    }
    public static void InsertionSorting(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i ; j < arr.length; j++) 
            {
                if(temp<arr[j]){
                   int t = arr[j];
                   arr[j]= temp;
                   temp =t;
                }
            }
            arr[i]=temp;
        System.out.println(+temp);     
        }
       
    }
    
    
}
 class DynamicArray{
int size;
int capacity=10;
Object[] array;

    public DynamicArray() {
        this.array= new Object[capacity];
    }
    
    public DynamicArray(int c)
    {
        capacity= c;
        this.array= new Object[c];
    }
    public void add(int a){
        if(size>=capacity){
            grow();
        }
        array[size]= a;
        size++;
    }
    
    
        //grow insert delete shrink add
public void grow(){
    
}
    @Override
    public String toString() {
       
        String n ="";
        for(int i =0;i<capacity;i++){
            
            if(i==capacity-1){
                n+=array[i];
            }
            else{
                n+=array[i]+",";
            }
        }
         return "DynamicArray{" + "size=" + size + ", capacity=" + capacity + '}'+"\nArray {"+n+"}";
    }
     public void insert(int index, int num) {
         for (int i = size; i >= index; i--) {
             array[i+1]= array[i];
         }
         array[index]= num;
         size++;
         
     }
    
}