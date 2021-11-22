#include <bits/stdc++.h>

using namespace std;
const int maxn = 1e4 + 10;
const int dx[4] = {0, 0, -1, 1};
const int dy[4] = {1, -1, 0, 0};

int n, m, id[maxn][maxn], idCnt;
set<int> bordered;
set<int> adj[maxn * maxn];
vector<string> A;

inline bool valid(int x, int y) {
    return (x >= 0 && y >= 0 && x < m && y < n);
}
void dfs(int x, int y) {
    id[x][y] = idCnt;
    for(int i = 0; i < 4; i++) {
        int newx = x + dx[i];
        int newy = y + dy[i];
        if (valid(newx, newy) && id[newx][newy] == -1 && A[newx][newy] == A[x][y])
            dfs(newx, newy);
    }
}
void constructGraph() {
    for(int i = 0; i < m; i++)
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < 4; k++) {
                int newi = i + dx[k];
                int newj = j + dy[k];
                if (valid(newi, newj) && id[newi][newj] != id[i][j]) {
                    adj[id[newi][newj]].insert(id[i][j]);
                    adj[id[i][j]].insert(id[newi][newj]);
                }
            }
        }
}
void process(int x, int &res) {
    queue<pair<int,bool>    > que;
    que.push({x, false});
    bordered.insert(x);
    int cnt = 1, cntTrue = 0;
    while (!que.empty()) {
        pair<int,bool> u = que.front(); que.pop();
        for(int y : adj[u.first]) {
            if (!bordered.count(y)) {
                bordered.insert(y);
                cntTrue += (u.second == false);
                cnt++;
                que.push({y, !u.second});
            }
        }
    }
    res += min(cntTrue, cnt - cntTrue);
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> m >> n;
    for(int i = 0; i < m; i++) {
        string s;
        cin >> s;
        A.push_back(s);
        for(int j = 0; j < n; j++)
            id[i][j] = -1;
    }
    idCnt = 0;
    for(int i = 0; i < m; i++)
        for(int j = 0; j < n; j++) {
            if (id[i][j] == -1) {
                idCnt += 1;
                dfs(i, j);
            }
        }

    int res = 0;
    constructGraph();
    for(int i = 0; i < m; i++) {
        if (!bordered.count(id[i][0])) {
            bordered.insert(id[i][0]);
            res += 1;
        }
        if (!bordered.count(id[i][n-1])) {
            bordered.insert(id[i][n-1]);
            res += 1;
        }
    }
    for(int i = 0; i < n; i++) {
        if (!bordered.count(id[0][i])) {
            bordered.insert(id[0][i]);
            res += 1;
        }
        if (!bordered.count(id[m-1][i])) {
            bordered.insert(id[m-1][i]);
            res += 1;
        }
    }

    for(int i = 1; i <= idCnt; i++)
        if (!bordered.count(i)) {
            process(i, res);
        }
    cout << res;
    return 0;
}