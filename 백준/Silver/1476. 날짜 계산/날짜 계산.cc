#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);

    int E, S, M;
    cin >> E >> S >> M;

    int year = 1, e = 1, s = 1, m = 1;

    while (!(E == e && S == s && M == m)) {
        year++;
        e++;
        s++;
        m++;

        if (e > 15) {
            e = 1;
        }
        if (s > 28) {
            s = 1;
        }
        if (m > 19) {
            m = 1;
        }
    }

    cout << year;

    return 0;
}