package ua.com.alevel;

public class Main {

    public static void main(String[] args) {
        String stc = "Hello World";
        System.out.println(reverse(stc, 0, 4));
    }

    public static String reverse(String src) {
        return new StringBuilder(src).reverse().toString();
    }

    public static String reverse(String src, String dest) {
        int index = src.indexOf(dest);
        if (index == -1) {
            return src;
        }
        return new StringBuilder(src).replace(index, index + dest.length(), new StringBuilder(dest).reverse().toString()).toString();
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= src.length() || firstIndex > lastIndex) {
            return src;
        }
        return new StringBuilder(src).replace(firstIndex, lastIndex + 1, new StringBuilder(src.substring(firstIndex, lastIndex + 1)).reverse().toString()).toString();
    }
}

