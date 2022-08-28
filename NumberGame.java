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
        if(x<0 || x>3 || y<0 || y>3){
            return false;
        }
        if((x==xzero-1 && y==yzero) || (x==xzero+1 && y==yzero) ||(x==xzero && y==yzero-1) ||(x==xzero && y==yzero+1)){
            return true;
        }
        return false;
      }
      public static boolean completionCheck(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(i==3 && j==2){
                    break;
                }
                if(arr[i][j]>arr[i][j+1]){
                    return false;
                }
            }
        }
        return true;
      }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\033[H\033[2J");
            System.out.println("\t\t\t\t\t\t\t😁THE NUMBER GAME😁");
            System.out.println("Your Objective is to sort the Elements of the 4x4 Matrix!");
            System.out.println("Press:\nS - Start🥳\nQ - Quit😒");
            char play=sc.next().charAt(0);
            if(play=='S' || play=='s'){
                int location[]=findZero(arr);
                int xzero=location[0];
                int yzero=location[1];
                while(completionCheck(arr)!=true){
                    System.out.print("\033[H\033[2J");
                    display(arr);
                    int x=xzero,y=yzero;
                    System.out.print("Press W/S/A/D: ");
                    do{
                        char ch=sc.next().charAt(0);
                        if(ch=='a' || ch=='A'){
                            x=xzero;
                            y=yzero+1;
                        }
                        else if(ch=='d' || ch=='D'){
                            x=xzero;
                            y=yzero-1;
                        }
                        else if(ch=='w' || ch=='W'){
                            x=xzero+1;
                            y=yzero;
                        }
                        else if(ch=='s' || ch=='S'){
                            x=xzero-1;
                            y=yzero;
                        }
                        else{
                            System.out.println("Wrong Choice!");
                            continue;
                        }
                        if(indexVerification(x, y, xzero, yzero)==true){
                            break;
                        }
                        else{
                            System.out.print("\033[H\033[2J");
                            display(arr);
                            System.out.print("Wrong Choice!😒\nPress W/S/A/D: ");
                            
                        }
                    }while(true);
                    swap(x, y, xzero, yzero);
                    xzero=x;
                    yzero=y;
                }
                System.out.print("\033[H\033[2J");
                display(arr);
                System.out.println("CONGRATULATIONS🥳, You've won the Game!");
            }
            System.out.println("Have a GOOD DAY!😁");
        }   
    }
}