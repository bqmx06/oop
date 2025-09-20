public class Reverse {
    public static void main(String[] args) {
        int[] a = new int[10];
        int n = a.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = a[n - i - 1];
            a[n - i - 1] = a[i];
            a[i] = temp;
        }
        for (int x : a) {
            System.out.print(x + " ");
        }

    }
}
