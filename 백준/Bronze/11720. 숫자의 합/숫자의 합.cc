#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    int sum = 0;
    for (int i = 0; i < n; i++) {
        char num;
        cin >> num;
        sum += (int) num - '0';
    }

    cout << sum;

    return 0;
}
