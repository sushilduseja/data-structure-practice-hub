package amazon;

import java.util.*;

public class PairsOfLogins {

    public int countFamilyLogins(List<String> logins) {

        if(logins.size()<2) return 0;

        Map<String, Integer> loginsMap = new HashMap<>();
        int count = 0;
        for (String login : logins) {
            if(login.isEmpty()) break;
            loginsMap.putIfAbsent(login, 0);
            loginsMap.put(login, loginsMap.get(login) + 1);
        }

        for (String login : logins) {
            StringBuilder res = new StringBuilder();

            for (char c : login.toCharArray()) {
                res.append((char)(((c - 'a' + 1) % 26) + 'a'));
            }
            if(loginsMap.containsKey(res.toString())){
                count = count+loginsMap.get(res.toString());
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PairsOfLogins pairsOfLogins = new PairsOfLogins();
        int i = pairsOfLogins.countFamilyLogins(List.of("bag", "sfe", "cbh", "cbh", "red"));
        System.out.println(i);
        int i2 = pairsOfLogins.countFamilyLogins(List.of("bag"));
        System.out.println(i2);
        int i3 = pairsOfLogins.countFamilyLogins(List.of(""));
        System.out.println(i3);
        int i4 = pairsOfLogins.countFamilyLogins(List.of("", ""));
        System.out.println(i4);
        int i5 = pairsOfLogins.countFamilyLogins(List.of("cbu", "bat", "cbu"));
        System.out.println(i5);
    }
}