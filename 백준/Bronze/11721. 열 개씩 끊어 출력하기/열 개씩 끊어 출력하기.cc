#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);

    string word;
    cin >> word;

    for (int i = 0; i < word.length(); i++) {
        cout << word.at(i);
        if (i % 10 == 9) {
            cout << endl;
        }
    }

    return 0;
}
