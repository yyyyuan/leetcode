class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int index = numCourses - 1;
        int[] result = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int course = stack.pop();
            count++;
            result[index] = course;
            index--;
            for (int i = 0; i < graph[course].size(); i++) {
                if (--indegree[graph[course].get(i)] == 0) {
                    stack.push(graph[course].get(i));
                } 
            }
        }
        
        return index == -1 ? result : new int[0];
    }
}
