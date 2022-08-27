import java.util.*;
public class NumberGame{
    public static int[][] uniqueRandom() {
        Random rand = new Random();
        int[][] nums = new int[4][4];
        //from  w w  w  .  j  a v a 2s.c  o  m
        boolean[] check = new boolean[16];
        
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++){
                int rnd = rand.nextInt(16);
                //check if the check array index has been set
                //if set regenerate 
                while (check[rnd]) {
                    rnd = rand.nextInt(16);
                }
                nums[i][j] = rnd;
                check[rnd] = true;
            }
        }
        return nums;
      }
      public static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
      }
      public static int[] findZero(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {-1,-1};
      }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = uniqueRandom();
        while(true){
            display(arr);
            System.out.print("Enter Index of the Element to replace with zero: ");
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
        }
    }
}