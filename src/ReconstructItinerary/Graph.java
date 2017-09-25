class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, List<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        
        // This is for building the graph
        for (String[] travel : tickets) {
            String departure = travel[0];
            String arrival = travel[1];
            if (!graph.containsKey(departure)) {
                List<String> neighs = new ArrayList<>();
                graph.put(departure, neighs);
            }
            graph.get(departure).add(arrival);
//                graph.put(departure, graph.get(departure).add(arrival));
        }
        
        List<String> currentPath = new ArrayList<>();
        currentPath.add("JFK");
        DFS(graph, "JFK", tickets.length, result, currentPath);
        
        
        return result;
    }
    
    
    // We use DFS Search to finish the task.
    private void DFS(HashMap<String, List<String>> graph, String current, int size, List<String> result, List<String> currentPath) {
        // Use PriorityQueue to find the best one.
        PriorityQueue<String> queue = new PriorityQueue<String>();
        List<String> neighs = graph.get(current);

        if (neighs == null || neighs.size() == 0) { 
            if (currentPath.size() == size + 1) {
                for (String s : currentPath) result.add(s);
                return;                
            }
            else {
                return;
            }
        }
                
        for (String arrival : neighs) queue.offer(arrival);
        while (!queue.isEmpty()) {
            String arrival = queue.poll();
            graph.get(current).remove(arrival);
            currentPath.add(arrival);
            DFS(graph, arrival, size, result, currentPath);
            if (result.size() != 0) return;       // If result.size() != 0, which means we find one result meeting the requirement, and it has the smallest lexical order
            currentPath.remove(currentPath.size() - 1);
            graph.get(current).add(arrival);
        }
        
        return;
    }
}
