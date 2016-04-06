import java.util.Arrays;

public class Manchester {
    public int[] manchester_encode(int[] array) {
        if(array.length < 2) return null;
        int[] encoded = new int[array.length - 1];
        for(int i = 1; i < array.length; i++) {
            boolean result = (array[i] == array[i-1]);
            encoded[i-1] = result ? 0 : 1;
        }
        return encoded;
    }
    
    
    public static void main(String[] args) {
        Manchester app = new Manchester();
        int[] array = {1,0, 0,1, 1,1, 0,0, 1,1, 1,0};
        System.out.println("Before Manchester: "+ Arrays.toString(array));
        array = app.manchester_encode(array);
        System.out.println("After Manchester: " + Arrays.toString(array));
    }
}