#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);

    string buffer;
    while (true) {
        if (!getline(cin, buffer)) {
            break;
        }
        cout << buffer << endl;
    }

    return 0;
}
