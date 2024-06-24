/*
Leetcode - 721 (google and Facebook interview question
 */

import java.util.*;

public class AccountsMerge {

    public static void main(String[] ar) {
        /*List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        ); */

        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("David", "David0@m.co", "David1@m.co"),
                Arrays.asList("David", "David3@m.co", "David4@m.co"),
                Arrays.asList("David", "David4@m.co", "David5@m.co"),
                Arrays.asList("David", "David2@m.co", "David3@m.co"),
                Arrays.asList("David", "David1@m.co", "David2@m.co")
        );

        List<List<String>> mergedAccounts = accountsMerge(accounts);

        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

      /*  Map<String, Set<String>> map = new HashMap<>();
        counter = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            Set<String> emails = new HashSet<>(account.subList(1, account.size()));

            boolean merged = false;
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                Set<String> existingEmails = entry.getValue();
                if (hasCommonEmail(existingEmails, emails)) {
                    existingEmails.addAll(emails);
                    map.put(entry.getKey(), existingEmails);
                    merged = true;
                    break;
                }
            }

            if (!merged) {
                if (counter.containsKey(name)) {
                    int count = counter.get(name);
                    map.put(name +"("+ count, emails);
                    counter.put(name, count + 1);
                } else {
                    map.put(name, emails);
                    counter.put(name, 1);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> sortedEmails = new ArrayList<>(entry.getValue());
            Collections.sort(sortedEmails);

            List<String> tempRes = new ArrayList<>();
            tempRes.add(stripCountFromName(key));
            tempRes.addAll(sortedEmails);

            res.add(tempRes);
        }

        return res;
    }

    private static boolean hasCommonEmail(Set<String> set1, Set<String> set2) {
        for (String email : set1) {
            if (set2.contains(email)) {
                return true;
            }
        }
        return false;
    }

    private static String stripCountFromName(String name) {
        int lastIndex = name.lastIndexOf('(');
        if (lastIndex != -1) {
            return name.substring(0, lastIndex);
        }
        return name;
    } */

        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        // Initialize the maps
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                parent.put(email, email);
            }
        }

        // Union operation
        for (List<String> account : accounts) {
            String rootEmail = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(account.get(i), parent), rootEmail);
            }
        }

        // Group emails by root email
        Map<String, Set<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String rootEmail = find(email, parent);
            unions.computeIfAbsent(rootEmail, k -> new HashSet<>()).add(email);
        }

        // Build the result
        List<List<String>> result = new ArrayList<>();
        for (Set<String> emails : unions.values()) {
            List<String> emailList = new ArrayList<>(emails);
            Collections.sort(emailList);
            emailList.add(0, emailToName.get(emailList.get(0)));
            result.add(emailList);
        }

        return result;
    }

    // Find with path compression
    private static String find(String email, Map<String, String> parent) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent.get(email), parent));
        }
        return parent.get(email);
    }
}
