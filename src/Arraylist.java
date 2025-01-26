import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
 /*       list.add(23);
        list.add(2343);
        list.add(34);
        System.out.println(list);
        System.out.println(list.contains(34));
        list.set(0, 34);
        System.out.println(list);
*/
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<5;i++){
            list.add(sc.nextInt());
        }
            System.out.println(list);
    }
}
