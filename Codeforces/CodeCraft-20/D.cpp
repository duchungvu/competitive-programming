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

#define maxn 1005

int n;
char res[maxn][maxn];
pi a[maxn][maxn];

bool inside(int x, int y) {
    return x > 0 && x <= n && y > 0 && y <= n;
}

void dfs(int x, int y, int r, int c) {
    if (inside(x + 1, y) && res[x + 1][y] == '*' && a[x + 1][y].first == r && a[x + 1][y].second == c) {
        res[x + 1][y] = 'U';
        dfs(x + 1, y, r, c);
    }
    if (inside(x - 1, y) && res[x - 1][y] == '*' && a[x - 1][y].first == r && a[x - 1][y].second == c) {
        res[x - 1][y] = 'D';
        dfs(x - 1, y, r, c);
    }
    if (inside(x, y + 1) && res[x][y + 1] == '*' && a[x][y + 1].first == r && a[x][y + 1].second == c) {
        res[x][y + 1] = 'L';
        dfs(x, y + 1, r, c);
    }
    if (inside(x, y - 1) && res[x][y - 1] == '*' && a[x][y - 1].first == r && a[x][y - 1].second == c) {
        res[x][y - 1] = 'R';
        dfs(x, y - 1, r, c);
    }
}

bool fill(int x, int y) {
    if (a[x][y].first != -1 && a[x][y].second != -1)
        return false;
    if (inside(x + 1, y) && a[x + 1][y].first == -1 && a[x + 1][y].second == -1) {
        res[x][y] = 'D';
        return true;
    }
    if (inside(x - 1, y) && a[x - 1][y].first == -1 && a[x - 1][y].second == -1) {
        res[x][y] = 'U';
        return true;
    }
    if (inside(x, y + 1) && a[x][y + 1].first == -1 && a[x][y + 1].second == -1) {
        res[x][y] = 'R';
        return true;
    }
    if (inside(x, y - 1) && a[x][y - 1].first == -1 && a[x][y - 1].second == -1) {
        res[x][y] = 'L';
        return true;
    }
    return false;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> a[i][j].first >> a[i][j].second;
            res[i][j] = a[i][j].first == i && a[i][j].second == j ? 'X' : '*';
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (res[i][j] == 'X') dfs(i, j, i, j);
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (res[i][j] == '*') {
                if (!fill(i, j)) {
                    cout << "INVALID" << endl;
                    return 0;
                }
            }
        }
    }
    cout << "VALID" << endl;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) cout << res[i][j];
        cout << endl;
    }
    return 0;
}