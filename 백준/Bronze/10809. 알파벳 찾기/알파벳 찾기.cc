#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);

    string word;
    cin >> word;

    vector<int> first(26, -1);
    int idx = 0;

    for(char c: word) {
        int ascii = (int) c;
        if (first[ascii - 97] == -1) {
            first[ascii - 97] = idx;
        }
        idx++;
    }

    for (int num: first) {
        cout << num << " ";
    }

    return 0;
}