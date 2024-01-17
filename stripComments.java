public class stripComments {
    public static void main(String[] args) {
        System.out.println(stripComment("apples, pears # and bananas\ngrapes\nbananas !apples   ", new String[] { "#", "!" }));
    }
    public static String stripComment (String text, String[] commentSymbols) {
        StringBuilder sb = new StringBuilder(text);
        // Loop for delete comments
        for (int i = 0; i < commentSymbols.length; i++) {
            int j = 0;

            // j = index of the comment value, starting
            while ((j = sb.indexOf(commentSymbols[i], j)) != -1) {
                // The end will be the \n, starting from j --> ... \n
                int end = sb.indexOf("\n", j);
                
                if (end != -1) { 
                    // It will delete starting from j until \n
                    sb.delete(j, end);
                } else {
                    // It will delete starting from j until the end of the string
                    sb.delete(j, sb.length());
                }
            }
        }
        // For delete multiply spaces of middle rows
        for (int i = 0; i < sb.length(); i++) {
            if (i + 1 < sb.length() && sb.charAt(i) == ' ' && sb.charAt(i + 1) == '\n') {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString().stripTrailing();
    }
}