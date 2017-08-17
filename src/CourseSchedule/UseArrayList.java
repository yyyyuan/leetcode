// This stills uses topological sorting and it uses adjacency lists instead of adjacency matrices, so its speed is much faster.

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[][] matrix = new int[numCourses][numCourses];
        ArrayList[] matrix = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) matrix[i] = new ArrayList();
        
        for (int i = 0; i < prerequisites.length; i++) {
            matrix[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < matrix[course].size(); i++) {
                int pre = (int) matrix[course].get(i);
                if (--indegree[pre] == 0) {
                    queue.offer(pre);
                }
            }
        }
        
        return count == numCourses;
    }
}
