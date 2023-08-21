package java7onlineHWs.hw8;

public class Main {

    public static void main(String[] args) {
        String stc = "Hello World";
        System.out.println(reverse(stc, 1, 4));
    }

    public static String reverse(String src) {
        char[] charArray = src.toCharArray();
        int length = charArray.length;
        char[] reversedArray = new char[length];

        for (int i = 0; i < length; i++) {
            reversedArray[length - 1 - i] = charArray[i];
        }

        return new String(reversedArray);
    }

    public static String reverse(String src, String dest) {
        int index = src.indexOf(dest);
        if (index == -1) {
            return src;
        }
        char[] srcArray = src.toCharArray();
        char[] destArray = dest.toCharArray();
        int destLength = destArray.length;
        char[] reversedDestArray = new char[destLength];

        for (int i = 0; i < destLength; i++) {
            reversedDestArray[destLength - 1 - i] = destArray[i];
        }

        String result = "";
        for (int i = 0; i < srcArray.length; i++) {
            if (i == index) {
                result += new String(reversedDestArray);
                i += destLength - 1;
            } else {
                result += srcArray[i];
            }
        }

        return result;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= src.length() || firstIndex > lastIndex) {
            return src;
        }
        char[] srcArray = src.toCharArray();

        for (int i = firstIndex; i <= (firstIndex + lastIndex) / 2; i++) {
            char temp = srcArray[i];
            srcArray[i] = srcArray[lastIndex - i + firstIndex];
            srcArray[lastIndex - i + firstIndex] = temp;
        }

        return new String(srcArray);
    }

}