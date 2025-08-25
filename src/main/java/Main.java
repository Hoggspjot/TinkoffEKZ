import java.util.*;

public class Main {

    static class Edge {
        int u, v, id;
        Edge(int u, int v, int id) {
            this.u = u;
            this.v = v;
            this.id = id;
        }
    }

    static List<Edge>[] graph;
    static boolean[] used;
    static int[] outDegree;
    static int n, m;
    static int[][] answer;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            if (m % 2 == 1) {
                System.out.println(-1);
                return;
            }

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            answer = new int[m][2];
            used = new boolean[m];
            outDegree = new int[n + 1];

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u].add(new Edge(u, v, i));
                graph[v].add(new Edge(v, u, i));
            }

            for (int i = 1; i <= n; i++) {
                if (!graph[i].isEmpty()) {
                    dfs(i);
                }
            }

            for (int i = 0; i < m; i++) {
                System.out.println(answer[i][0] + " " + answer[i][1]);
            }
        }
    }

    static void dfs(int v) {
        for (Edge e : graph[v]) {
            if (!used[e.id]) {
                used[e.id] = true;
                dfs(e.v);

                answer[e.id][0] = v;
                answer[e.id][1] = e.v;
                outDegree[v]++;

                if (outDegree[e.v] % 2 == 1) {
                    answer[e.id][0] = e.v;
                    answer[e.id][1] = v;
                    outDegree[v]--;
                    outDegree[e.v]++;
                }
            }
        }
    }
}