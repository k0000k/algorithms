import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> names = new HashMap<>();
        
        for (String name: completion) {
            if (names.containsKey(name)) {
                int cnt = names.get(name);
                cnt++;
                names.put(name, cnt);
            } else {
                names.put(name, 1);
            }
        }
        
        for (String name: participant) {
            if (!names.containsKey(name)) {
                answer = name;
                break;
            }
            int cnt = names.get(name);
            if (cnt == 1) {
                names.remove(name);
            } else {
                cnt--;
                names.put(name, cnt);
            }
        }
        return answer;
    }
}