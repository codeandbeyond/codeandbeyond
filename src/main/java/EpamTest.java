import java.util.LinkedList;

public class EpamTest {
    public LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        int[] array = {2, 5, 3, 8, 1,9};
        EpamTest epamTest = new EpamTest();
        epamTest.revertArray(array);
        for(int num:array){
            System.out.print(num+" ");
        }
        Runnable target;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                epamTest.waitNotifyExample();
            }
        });
    }
    public void revertArray(int[] a){
        int n = a.length;
        for(int i=0;i<n/2;i++){
            int temp =a[i];
            a[i] = a[n-1-i];
            a[n-1-i] = temp;
        }
    }
    public void waitNotifyExample() {
        try{
        synchronized (this){
            while(list.size() == 2){
                wait();
            }
            list.add(1);
            notifyAll();
        }
        }catch (InterruptedException ex){

        }
    }
}
