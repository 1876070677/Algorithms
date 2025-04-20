import java.io.*;
import java.util.*;

public class Main {
	BufferedReader bf;
	int N;
	int[][] map;
	
	public void input() throws IOException {
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public int straightShape(int x, int y) {
		int sum = -10000001;
		// 원본 모양
		if (y + 3 < N) {
			sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x][y+2] + map[x][y+3]);
		}
		// 
		if (x + 3 < N) {
			sum = Math.max(sum,  map[x][y] + map[x+1][y] + map[x+2][y] + map[x+3][y]);
		}
		
		return sum;
	}
	
	public int secondShape(int x, int y) {
		int sum = -10000001;
		
		// 원본 모양
		if (x + 1 < N && y + 2 < N) {
			sum = Math.max(sum,  map[x][y] + map[x][y+1] + map[x+1][y+1] + map[x+1][y+2]);
		}
		// 90도 회전 
		if (x + 2 < N && y - 1 >= 0) {
			sum = Math.max(sum,  map[x][y] + map[x+1][y] + map[x+1][y-1] + map[x+2][y-1]);
		}
		
		return sum;
	}
	
	public int thirdShape(int x, int y) {
		int sum = -10000001;
		// 원본 모양
		if (x + 1 < N && y + 2 < N) {
			sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+2]);
		}
		// 90도 회전
		if (x + 2 < N && y - 1 >= 0) {
			sum = Math.max(sum,  map[x][y] + map[x + 1][y] + map[x+2][y] + map[x+2][y-1]);
		}
		// 180도 회전
		if (x + 1 < N && y + 2 < N) {
			sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x+1][y+1] + map[x+1][y+2]);
		}
		// 270도 회전
		if (x + 2 < N && y + 1 < N) {
			sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x+1][y] + map[x+2][y]);
		}
		return sum;
	}
	
	public int fourthShape(int x, int y) {
		int sum = -10000001;
		
		if (y + 2 < N && x + 1 < N) {
			sum = Math.max(sum, map[x][y] + map[x][y + 1] + map[x][y+2] + map[x+1][y+1]);
		}
		if (x + 2 < N && y - 1 >= 0) {
			sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1]);
		}
		if (x - 1 >= 0 && y + 2 < N) {
			sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1]);
		}
		if (x + 2 < N && y + 1 < N) {
			sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1]);
		}
		return sum;
 	}
	
	public int fifthShape(int x, int y) {
		int sum = -10000001;
		if (x + 1 < N && y + 1 < N) {
			sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x][y+1] + map[x+1][y+1]);
		}
		
		return sum;
	}
	
	public void solution(int n) {
		int answer = -10000001;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(answer, straightShape(i, j));
				answer = Math.max(answer, secondShape(i, j));
				answer = Math.max(answer,  thirdShape(i, j));
				answer = Math.max(answer,  fourthShape(i, j));
				answer = Math.max(answer, fifthShape(i, j));
			}
		}
		System.out.println(n + ". " + answer);
	}
	
	public void solve() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		bf = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(bf.readLine().trim());
			if (N == 0)
				break;
			input();
			solution(cnt);
			cnt++;
		}
		//System.out.println("Finished");
	}
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
