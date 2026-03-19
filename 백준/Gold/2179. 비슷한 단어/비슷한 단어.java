import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    String s;
    int index;

    Word(String s, int index) {
        this.s = s;
        this.index = index;
    }

    public int compareTo(Word w) {
        return this.index - w.index;
    }
}

public class Main {
    int N;
    String[] words;
    Map<String, Integer> idx = new HashMap<>();

    Set<String> wordSet = new HashSet<>();
    int matchCnt = 0;

    public void solve() {
        Arrays.sort(words);
        for (int i = 0; i < N - 1; i++) {
            int baseWordLen = words[i].length();

            int matched = 0;
            for (int j = 0; j < baseWordLen; j++) {
                if (words[i].charAt(j) == words[i+1].charAt(j)) {
                    matched++;
                    continue;
                }
                break;
            }

            // 이전보다 크면 아예 갱신.
            if (matched > matchCnt) {
                wordSet.clear();
                matchCnt = matched;
            }

            // 같으면 집어넣기.
            if (matched >= matchCnt) {
                wordSet.add(words[i]);
                wordSet.add(words[i+1]);
            }
        }

        List<Word> answer = new ArrayList<>();
        for (String s: wordSet) {
            answer.add(new Word(s, idx.get(s)));
        }
        Collections.sort(answer);

        String head = answer.get(0).s.substring(0, matchCnt);
        System.out.println(answer.get(0).s);

        for (int i = 1; i < answer.size(); i++) {
            String tmp = answer.get(i).s.substring(0, matchCnt);
            if (head.equals(tmp)) {
                System.out.println(answer.get(i).s);
                break;
            }
        }
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            words[i] = st.nextToken();
            idx.put(words[i], i);
        }
    }

    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}