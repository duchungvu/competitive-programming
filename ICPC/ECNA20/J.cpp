/*input
0 0 0 0 0 0 7 0 1
0 0 0 0 0 1 2 3 5
0 0 1 8 0 0 0 0 6
0 0 0 0 2 5 0 9 3
9 0 0 0 0 0 0 0 2
3 1 0 6 7 0 0 0 0
2 0 0 0 0 3 8 0 0
1 3 8 9 0 0 0 0 0
4 0 6 0 0 0 0 0 0

*/

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef long double ld;

typedef pair<int,int> pi;
typedef pair<ll,ll> pll;
typedef pair<ld,ld> pd;

typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<ld> vd;
typedef vector<pi> vpi;
typedef vector<pll> vpll;
typedef vector<pd> vpd;

int a[9][9];
bool s[9][9][10];

void fill(int x, int y, int num) {
    // cout << x << " " << y << " " << num << "\n";
    a[x][y] = num;
    for (int i = 1; i <= 9; i++) {
        s[x][y][i] = false;
    }
    for (int i = 0; i < 9; i++) {
        s[i][y][num] = false;
        s[x][i][num] = false;
    }
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            s[i + (x / 3 * 3)][j + (y / 3 * 3)][num] = false;
        }
    }
}

bool single_value() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            // if (a[i][j]) continue;
            int val = 0, val2 = -1;
            for (int k = 1; k <= 9; k++) {
                if (s[i][j][k]) {
                    val++;
                    val2 = k;
                }
            }
            if (val == 1) {
                fill(i, j, val2);
                return true;
            }
        }
    }
    return false;
}

bool unique_value() {
    // row
    for(int i = 0; i < 9; i++) {
        for(int num = 1; num <= 9; num++) {
            int val = 0, val2 = -1;
            for(int j = 0; j < 9; j++) {
                if(s[i][j][num]) {
                    val ++, val2 = j;
                }
            }
            if(val == 1) {
                fill(i, val2, num);
                return true;
            }
        }
    }

    // column
    for(int i = 0; i < 9; i++) {
        for(int num = 1; num <= 9; num++) {
            int val = 0, val2 = -1;
            for(int j = 0; j < 9; j++) {
                if(s[j][i][num]) {
                    val++, val2 = j;
                }
            }
            if(val == 1) {
                fill(val2, i, num);
                return true;
            }
        }
    }

    // grid
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            int top = i * 3, left = j * 3;
            for(int num = 1; num <= 9; num++) {
                int val = 0, val2x = -1, val2y = -1;
                for(int x = top; x < top + 3; x++) {
                    for(int y = left; y < left + 3; y++) {
                        if(s[x][y][num]) {
                            val++;
                            val2x = x;
                            val2y = y;
                        }
                    }
                }
                if(val == 1) {
                    fill(val2x, val2y, num);
                    return true;
                }
            }
        }
    }

    // no unique value found!
    return false;

}

bool is_easy() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (!a[i][j]) return false;
        }
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            for (int k = 1; k <= 9; k++) {
                s[i][j][k] = true;
            }
        }
    }

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            int ak;
            cin >> ak;
            if(ak > 0) fill(i, j, ak);
        }
    }
    
    while (true) {
        if (single_value()) {
            continue;
        }
        if (unique_value()) {
            continue;
        }
        break;
    }

    if (is_easy()) {
        cout << "Easy" << endl;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cout << a[i][j] << " ";
            }
            cout << endl;
        }
    } else {
        cout << "Not easy" << endl;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j])
                    cout << a[i][j] << " ";
                else
                    cout << ". ";
            }
            cout << endl;
        }
        // for (int i = 1; i <= 9; i++) {
        //     cout << s[2][4][i] << " ";
        // }
        // cout << endl;
    }
}