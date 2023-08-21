package java7onlineHWs.hw8;

public class Main {

    public static void main(String[] args) {
        String stc = "Hello World";
        System.out.println(reverse(stc, 0, 4));
    }

    public static String reverse(String src) {
        StringBuilder reversed = new StringBuilder();
        for (int i = src.length() - 1; i >= 0; i--) {
            reversed.append(src.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverse(String src, String dest) {
        int index = src.indexOf(dest);
        if (index == -1) {
            return src;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = dest.length() - 1; i >= 0; i--) {
            reversed.append(dest.charAt(i));
        }
        return src.substring(0, index) + reversed.toString() + src.substring(index + dest.length());
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= src.length() || firstIndex > lastIndex) {
            return src;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = lastIndex; i >= firstIndex; i--) {
            reversed.append(src.charAt(i));
        }
        return src.substring(0, firstIndex) + reversed.toString() + src.substring(lastIndex + 1);
    }

}

