/*input
6
26 11 23 14 13 16
6 7 32 4 29 29
26 19 30 10 30 11
6 28 23 5 24 23
6 24 1 27 24 20
13 9 32 18 20 18
MY HOVERCRAFT IS FULL OF EELS

*/

#include <bits/stdc++.h>
using namespace std;

int a[15][15];
int temp[15];
int ans[15];

int transform(char ch) {
	if('A' <= ch && ch <= 'Z') {
		return ch - 'A';
	}
	else if('0' <= ch && ch <= '9') {
		return ch - '0' + 26;
	}
	else return 36;
}

char retransform(int ch) {
	if(0 <= ch && ch <= 25) return char(ch + 'A');
	else if(26 <= ch && ch <= 35) return char(ch - 26 + '0');
	else return ' ';
}

int main() {
	int n;
	cin >> n;
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}
	// cout << a[0][0] << endl;

	string s;
	getline(cin, s);
	getline(cin, s);
	// cout << s << endl;
	while(s.size() % n != 0) s.push_back(' ');

	int mod = s.size() / n;

	for(int i = 0; i < mod; i++) {
		for(int j = 0; j < n; j++) {
			temp[j] = transform(s[n * i + j]);
			// cout << temp[j] << endl;
			ans[j] = 0;
		}
		for(int j = 0; j < n; j++) {
			for(int k = 0; k < n; k++) {
				ans[j] += a[j][k] * temp[k];
				ans[j] %= 37;
			}
		}
		for(int j = 0; j < n; j++) {
			s[n * i + j] = retransform(ans[j]);
		}
		
	}
	cout << s << "\n";

}