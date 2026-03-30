package graph;

import java.util.*;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-30
 */
public class Lc210 {
//    private static int numCourses  = 2;
    private static int numCourses  = 4;
//    private static int[][] prerequisites  = {{1,0}};
    private static int[][] prerequisites  = {{1,0},{2,0},{3,1},{3,2}};

    public static int[] findOrder(int numCourses,int[][] prerequisites) {
        int[] adj = new int[numCourses];
        List<List<Integer>>  group = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            group.add(new ArrayList<>());
        }

        for(int[] cp : prerequisites) {
            int course = cp[0];
            int preCourse = cp[1];
            adj[course]++;
            group.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses; ++i) {
            if(adj[i] == 0) queue.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        int count = 0;
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            ans.add(pre);
            if(numCourses == count) return ans.stream().mapToInt(Integer::intValue).toArray();

            for(int cur : group.get(pre)) {
                adj[cur]--;
                if(adj[cur] == 0) queue.add(cur);
            }
        }

        return new int[]{};
    }
    public static void main(String[] args) {
        int[] ans = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }
}
