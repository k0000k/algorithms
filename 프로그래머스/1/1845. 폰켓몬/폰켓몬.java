import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> pokemons = new HashMap<>();
        int getPokemon = nums.length / 2;
        
        for (int num: nums) {
            pokemons.put(num, 0);
        }
        
        int kinds = pokemons.size();
        
        if (kinds >= getPokemon) {
            answer = getPokemon;
        }
        else {
            answer = kinds;
        }
        
        return answer;
    }
}