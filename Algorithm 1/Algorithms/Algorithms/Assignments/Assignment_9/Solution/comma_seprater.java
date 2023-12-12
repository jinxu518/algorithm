public class comma_seprater {
    public static void main(String[] args) {
        String s = "5 6 7 4 2 3 1 8 11 13 14 16 10 12 11 9";
        String newStr = s.replaceAll("\\s+", ",");
        System.out.println(newStr);
    }
}
