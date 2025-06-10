public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {

        for (int i = str.length() / 2; i >= 1; i--) {
            if(str.length() % i == 0){
                StringBuilder tempStr = new StringBuilder();
                String partStr = str.substring(0, i);
                for (int j = 0; j < str.length() / i; j++) {
                    tempStr.append(partStr);
                }
                if(tempStr.toString().equals(str)){
                    return true;
                }
            }
        }
        return false;

       /* //java.util.List<String> substrings = new java.util.ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String substring = s.substring(i, j);
                if(substring.equals("")) continue;
                //substrings.add(substring);
                int times = len / substring.length();
                String constructedString = "";
                for (int k = 0; k < times; k++) {
                    constructedString += substring;
                }
                if (constructedString.equals(s)) {
                    return true;
                }
            }
        }
        //System.out.println(substrings);
        *//*for (String str: substrings) {
            int times = len / str.length();
            String constructedString = "";
            for (int i = 0; i < times; i++) {
                constructedString += str;
            }
            if (constructedString.equals(s)) {
                return true;
            }
        }*//*
        return false;*/
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern pattern = new RepeatedSubstringPattern();
        System.out.println(pattern.repeatedSubstringPattern("aba"));
    }

}
