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

const int maxn = 55;

int t, n;
string in, out;
char res[maxn][maxn];
bool visited[maxn];

void dfs(int x, int y) {
    visited[y] = true;
    res[x][y] = 'Y';
    if (out[y] == 'N') return;
    if (y > 0 && !visited[y - 1] && in[y - 1] == 'Y') dfs(x, y - 1);
    if (y < n - 1 && !visited[y + 1] && in[y + 1] == 'Y') dfs(x, y + 1);
}

int main() {
    ios::sync_with_stdio(false);
    freopen("A.in", "r", stdin);
    freopen("A.txt", "w", stdout); 
    cin.tie(0);
    cin >> t;
    for (int o = 0; o < t; o++) {
        memset(res, 'N', sizeof(res));
        cin >> n >> in >> out;
        for (int i = 0; i < n; i++) {
            memset(visited, false, sizeof(visited));
            dfs(i, i);
        }
        cout << "Case #" << o + 1 << ":" << endl;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) cout << res[i][j];
            cout << endl;
        }
    }
    return 0;
}