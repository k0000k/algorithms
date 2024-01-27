#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    int max_num = INT_MIN;
    int min_num = INT_MAX;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;

        if (num < min_num) {
            min_num = num;
        }
        if (num > max_num) {
            max_num = num;
        }
    }

    cout << min_num << " " << max_num << endl;

    return 0;
}
