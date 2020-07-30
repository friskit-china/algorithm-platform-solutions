package leetcode.leetcode_0127_medm_word_ladder;

import java.util.*;

public class v01 {
    static
    class Solution {
        class Item{
            String str;
            Integer level;
            public Item(String str, Integer level){
                this.str = str;
                this.level = level;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            char[] charList = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            int wordLength = beginWord.length();
            Set<String> wordSet = new HashSet<>();
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            for (var s : wordList){
                wordSet.add(s);
            }

            if (wordSet.contains(endWord) == false){
                return 0;
            }

            Deque<Item> queue = new LinkedList<>();
            queue.addLast(new Item(beginWord, 1));
            while (queue.size() != 0){
                Item item = queue.pollFirst();
                if (item.str.equals(endWord)){
                    return item.level;
                }

                for (int replacePos = 0; replacePos < wordLength; ++replacePos){
                    for (char replaceChar : charList){
                        char[] oriStrCharList = item.str.toCharArray();
                        oriStrCharList[replacePos] = replaceChar;
                        String newStr = new String(oriStrCharList);
                        if (wordSet.contains(newStr) && visited.contains(newStr) == false){
                            queue.addLast(new Item(newStr, item.level + 1));
                            visited.add(newStr);
                        }
                    }
                }
            }

            return 0;

        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }
    
}