# Strip-Comments-Kata
***Solution for the kata kyu 4 ( Strip Comments)***

Link --> [Strip Comments Kyu 4](https://www.codewars.com/kata/51c8e37cee245da6b40000bd)

Phase 1
**Create function and the StringBuilder**
~~~
public static String stripComment (String text, String[] commentSymbols) {
        StringBuilder sb = new StringBuilder(text);
        
        return sb.toString().stripTrailing();
    }
}
~~~

Phase 2
**Delete comments**
~~~
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
        return sb.toString().stripTrailing();
    }
}
~~~

Phase 3 (Final Code)
**Delete useless spaces**
~~~
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
~~~

*In the repository you can find the executable*

*Thanks for spend your time reading this*
