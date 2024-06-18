package package1;

public class Main {
    public static int fact(int n){
        if(n == 0){
            return 1;
        }else{
            return n * fact(n--);
        }
    }
    public static void main(String[] args){
        fact(3);
    }
}

3 = 3 * 2 * 1;
3! = 3! * 2! * 1!;