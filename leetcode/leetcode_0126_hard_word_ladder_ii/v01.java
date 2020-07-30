package leetcode.leetcode_0126_hard_word_ladder_ii;

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

        Map<String, List<String>> path = new HashMap<>();
        char[] charList = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Set<String> wordSet = new HashSet<>();
        Map<String, Integer> visited = new HashMap<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            int wordLength = beginWord.length();
            List<List<String>> result = new ArrayList<List<String>>();
            
            
            visited.put(beginWord, 1);
            for (var s : wordList){
                wordSet.add(s);
            }

            if (wordSet.contains(endWord) == false){
                return result;
            }

            Deque<Item> queue = new LinkedList<>();
            queue.addLast(new Item(beginWord, 1));
            while (queue.size() != 0){
                Item item = queue.pollFirst();
                if (item.str.equals(endWord)){
                    break;
                }

                for (int replacePos = 0; replacePos < wordLength; ++replacePos){
                    for (char replaceChar : charList){
                        char[] oriStrCharList = item.str.toCharArray();
                        oriStrCharList[replacePos] = replaceChar;
                        String newStr = new String(oriStrCharList);
                        if (wordSet.contains(newStr) && (visited.containsKey(newStr) == false || visited.get(newStr) > item.level)){
                            if (visited.containsKey(newStr) == false){
                                queue.addLast(new Item(newStr, item.level + 1));
                                visited.put(newStr, item.level + 1);
                            }
                            
                            var pathList = path.getOrDefault(newStr, new ArrayList<String>());
                            pathList.add(item.str);
                            path.put(newStr, pathList);
                        }
                    }
                }
            }

            for (var pathStr : generatePath(endWord, beginWord)){
                result.add(Arrays.asList((pathStr + "#" + endWord).split("#")));
            }

            return result;

        }

        private List<String> generatePath(String target, String beginWord){
            List<String> result = new ArrayList<String>();
            var sourceList = path.get(target);
            if (sourceList == null){
                return result;
            }

            for (var sourceStr : sourceList){
                if (sourceList.get(0).equals(beginWord)){
                    result.add(sourceList.get(0));
                    return result;
                }
                var lastResult = generatePath(sourceStr, beginWord);
                for (var r : lastResult){
                    result.add(r + "#" + sourceStr);
                }
            }
            return result;
        }
    }

    public static void main(String[] argv){
        var result = new Solution().findLadders("hot", "dog", Arrays.asList(new String[]{"hot", "dog"}));
        // var result = new Solution().findLadders("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

        for (var i : result){
            System.out.println(String.join(" -> ", i));
        }
    }
    
}