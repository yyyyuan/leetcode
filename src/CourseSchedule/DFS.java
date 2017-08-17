public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];   // It cant create a array with generics. So I should 
        
        // This is necessary for creating an array of lists.
        for (int i = 0; i < numCourses; i++) {  
            graph[i] = new ArrayList<Integer>();
        }
        
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, boolean[] visited, int course) {
        if (visited[course]) return false;
        visited[course] = true;
        
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, graph[course].get(i))) return false;
        }
        visited[course] = false;
        return true;
        
    }
}
