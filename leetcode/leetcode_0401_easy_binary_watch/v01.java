package leetcode.leetcode_0401_easy_binary_watch;

import java.util.*;

public class v01 {
    static
    class Solution {
        private List<String> result = new ArrayList<>();
        public List<String> readBinaryWatch(int num) {
            process(0, num, 0, 0);
            return result;
        }

        private void process(int startPos, int countDown, int hour, int minute){
            if (countDown == 0){
                result.add(timeToString(hour, minute));
                return;
            }
            
            for (int i = startPos; i <= 9; ++i){
                if (i >= 0 && i <=3){   // hour
                    int newHour = hour + (1 << i);
                    if (newHour > 11){ // cut
                        continue;
                    }
                    process(i + 1, countDown - 1, newHour, minute);
                }else if(i >= 4 && i <= 9){ //minute
                    int newMinute = minute + (1 << (i - 4));
                    if (newMinute > 59){ // cut
                        continue;
                    }
                    process(i + 1, countDown - 1, hour, newMinute);
                }
            }
        }

        private String timeToString(int hour, int minute){
            var sb = new StringBuilder();
                sb.append(hour + ":");
                if (minute < 10){
                    sb.append("0" + minute);
                }else{
                    sb.append("" + minute);
                }
            return sb.toString();
        }
    }

    public static void main(String[] argv){
        for (var item : new Solution().readBinaryWatch(5)){
            System.out.println(item);
        }
    }
    
}