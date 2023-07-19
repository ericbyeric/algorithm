package arrays_string;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressString("aabbbbbccccdd"));
        System.out.println(compressString("abcd"));
    }
    private static String compressString(String str) {
        String newStr = compress(str);
        return str.length() < newStr.length() ? str : newStr;  // 두 개중에 짧은 것을 반환
    }

    private static String compress(String str) {
        int count = 0;
        StringBuilder newString = new StringBuilder(getTotal(str));
        for(int i = 0; i < str.length(); i++){
            count++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                newString.append(str.charAt(i));
                newString.append(count);
                count = 0;
            }
        }
        return newString.toString();
    }

    // 결과로 반환할 문자열이 몇개가 될지 미리 getTotal함수를 통해 획득
    private static int getTotal(String str) {
        int count = 0;
        int total = 0;
        for(int i=0; i<str.length(); i++) {
            count++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                System.out.println("count = " + count);
                System.out.println("String.valueOf(count): " + String.valueOf(count));
                System.out.println("String.valueOf(count).length(): " + String.valueOf(count).length());
                total += 1 + String.valueOf(count).length();
                System.out.println("total = " + total);
                count = 0;
                System.out.println("--------------------");
            }
        }
        return total;
    }
}
