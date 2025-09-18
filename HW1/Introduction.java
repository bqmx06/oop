public class Introduction {
    public static void main(String[] args) {
        System.out.println("Họ tên: Bùi Quang Minh\t" +
                "Mã sinh viên: 24021562\t" +
                "Lớp: K69I-CS5\t" +
                "Username github: bqmx06\t" +
                "Email: 24021562@vnu.edu.vn");
        for (int i = 9; i >= 1; i--) {
            String wordForm = (i == 1) ? "bottle" : "bottles";
            System.out.println(i + " " + wordForm + " of beer on the wall, " +
                    i + " " + wordForm + " of beer. ");
            System.out.println("Take one down, pass it around, ");
        }
        System.out.println("No more bottles of beer on the wall. ");
    }
}
