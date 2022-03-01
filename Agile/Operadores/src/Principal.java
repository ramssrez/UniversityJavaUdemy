public class Principal {
    public static void main(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[1]);
        int val3 = Integer.parseInt(args[2]);
        int val4 = Integer.parseInt(args[3]);
        int val5 = Integer.parseInt(args[4]);
        int val6 = Integer.parseInt(args[5]);
        int auxiliar;
        int[] arr = {val1, val2, val3, val4, val5, val6};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < args.length-1; j++) {
                if (arr[j] < arr[j+1]) {
                    auxiliar = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = auxiliar;
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}
