#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);

    while (1) {
        int a, b;
        cin >> a >> b;

        if (a == 0 && b == 0) {
            break;
        }

        cout << a + b << endl;
    }
    
    return 0;
}
