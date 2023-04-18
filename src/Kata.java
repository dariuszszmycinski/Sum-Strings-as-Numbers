import java.util.Arrays;

public class Kata {
    public static String sumStrings(String a, String b) {
        if (a.isEmpty()) a = "0";
        if (b.isEmpty()) b = "0";
        char[] aChars = a.replaceFirst("^0+(?!$)", "").toCharArray();
        char[] bChars = b.replaceFirst("^0+(?!$)", "").toCharArray();
        int i = Integer.max(aChars.length, bChars.length);
        int[] aInts = new int[i];
        for (int j = 0; j < aChars.length; j++) {
            aInts[j + i - aChars.length] = Character.getNumericValue(aChars[j]);
        }
        int[] bInts = new int[i];
        for (int j = 0; j < bChars.length; j++) {
            bInts[j + i - bChars.length] = Character.getNumericValue(bChars[j]);
        }
        int[] resountInts = new int[i + 1];
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            if (aInts[i - j - 1] == 0) {
                resountInts[i - j] = resountInts[i - j] + bInts[i - j - 1];
            } else if (bInts[i - j - 1] == 0) {
                resountInts[i - j] = resountInts[i - j] + aInts[i - j - 1];
            } else {
                resountInts[i - j] = resountInts[i - j] + aInts[i - j - 1] + bInts[i - j - 1];
            }
            if (resountInts[i - j] > 9) {
                resountInts[i - j] = resountInts[i - j] % 10;
                resountInts[i - j - 1]++;
            }
        }
        if (resountInts[0] != 0) sb.append(resountInts[0]);
        for (int j = 1; j < resountInts.length; j++) {
            sb.append(resountInts[j]);
        }
        return sb.toString();
    }
}