// https://leetcode-cn.com/problems/day-of-the-week/
#include <iostream>
using namespace std;

//submit start
class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        int days = 0;
        int days_of_month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        string weekdays[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int diff_year = year - 1970;
        days += (diff_year / 4) * 1461; // each 4 years, there are 1,451 days
        while(diff_year % 4 > 0){
            days += 365;
            if (is_leap_year(year - (diff_year % 4))){
                days += 1;
            }
            diff_year -= 1;
        }
        
        int diff_month = month - 1;
        while(diff_month > 0){
            days += days_of_month[diff_month - 1];
            diff_month -= 1;
        }

        int diff_day = day - 1;
        days += diff_day;

        // if in a leap year and later than Feb.
        if ((month > 2) and is_leap_year(year)){
            days += 1;
        }
        return weekdays[(days + 4) % 7];
    }

    bool is_leap_year(int year){
        return (year % 400 == 0 || (year % 4 == 0 and year % 100 != 0));
    }
};
//submit end

int main(){
    Solution sl;
    cout<<sl.dayOfTheWeek(1, 1, 1970)<<endl; // Thursday
    
    cout<<sl.dayOfTheWeek(31, 8, 2019)<<endl; // Saturday
    cout<<sl.dayOfTheWeek(18, 7, 1999)<<endl; // Sunday
    cout<<sl.dayOfTheWeek(15, 8, 1993)<<endl; // Sunday

    return 0;
}