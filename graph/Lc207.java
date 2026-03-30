package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc207 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * @since Created in 2026-03-30
 */
public class Lc207 {
    private static int numCourses  = 2;
//    private static int[][] prerequisites = {{1, 0}};
    private static int[][] prerequisites = {{1,0},{0,1}};

    /**
     * 无向有度图构建
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] adj = new int[numCourses];
        List<List<Integer>> group = new ArrayList<>();

        for(int i = 0; i < numCourses; ++i) {
            group.add(new ArrayList<>());
        }

        for(int[] cp : prerequisites) {
            int course = cp[0];
            int preCourse = cp[1];
            adj[course]++;
            group.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; ++i){
            if(adj[i] == 0) queue.add(i);
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            count++;

            for(int c : group.get(pre)){
                adj[c]--;
                if(adj[c] == 0) queue.add(c);
            }
        }

        return numCourses == count;
    }

    public static void main(String[] args) {
        boolean ans = canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }
}
