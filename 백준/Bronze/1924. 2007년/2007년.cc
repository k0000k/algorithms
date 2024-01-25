#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);

    int months[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    string days[7] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    int x, y;
    cin >> x >> y;

    int result = 0;
    for (int i = 1; i < x; i++) {
        result += months[i];
    }

    result += (y - 1);

    cout << days[result % 7];

    return 0;
}
