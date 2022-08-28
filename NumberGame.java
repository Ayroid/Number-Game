import java.util.*;
public class NumberGame{
    static int arr[][] = uniqueRandom();
    public static int[][] uniqueRandom() {
        Random rand = new Random();
        int[][] nums = new int[4][4];
        boolean[] check = new boolean[16];
        
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++){
                int rnd = rand.nextInt(16);
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
      public static void swap(int x, int y, int xzero, int yzero){
        int temp = arr[x][y];
        arr[x][y] = arr[xzero][yzero];
        arr[xzero][yzero] = temp;
      }  
      public static boolean indexVerification(int x, int y, int xzero, int yzero){
        if(xzero<0 || xzero>3 || yzero<0 || yzero>3){
            return false;
        }
        if((x==xzero-1 && y==yzero) || (x==xzero+1 && y==yzero) ||(x==xzero && y==yzero-1) ||(x==xzero && y==yzero+1)){
            return true;
        }
        return false;
      }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int location[]=findZero(arr);
            int xzero=location[0];
            int yzero=location[1];
            while(true){
                System.out.print("\033[H\033[2J");
                display(arr);
                int x,y;
                System.out.print("Enter Index of the Element to replace with zero: ");
                do{
                    x=sc.nextInt();
                    y=sc.nextInt();
                    if(indexVerification(x, y, xzero, yzero)==true){
                        break;
                    }
                    else{
                        System.out.print("\033[H\033[2J");
                        display(arr);
                        System.out.print("Element cannot be swapped!\nEnter Index: ");
                        
                    }
                }while(true);
                swap(x, y, xzero, yzero);
                xzero=x;
                yzero=y;
            }
        }
    }
}