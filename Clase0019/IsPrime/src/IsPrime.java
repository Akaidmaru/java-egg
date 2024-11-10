public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(5));
        System.out.println(isPrime(88));
        System.out.println(isPrime(1));
        System.out.println(isPrime(90));
        System.out.println(isPrime(47));
        System.out.println("----------------------");
        System.out.println(isPrimeRecursive(5, 2));
        System.out.println(isPrimeRecursive(88, 2));
        System.out.println(isPrimeRecursive(1, 2));
        System.out.println(isPrimeRecursive(90, 2));
        System.out.println(isPrimeRecursive(47, 2));
    }

    public static boolean isPrime(int number){
        if (number <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeRecursive(int number, int divisor){
        if (number <= 1){
            return false;
        }
        if (number % divisor == 0){
            return false;
        }
        if (divisor * divisor > number){
            return true;
        }
        return isPrimeRecursive(number, divisor + 1);
    }
}
