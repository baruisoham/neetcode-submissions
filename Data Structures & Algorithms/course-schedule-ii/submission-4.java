class Solution {

    // topological sort

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        final HashMap<Integer, List<Integer>> adjMat = new HashMap<Integer, List<Integer>>();

        final int[] inDegree = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            adjMat.computeIfAbsent(prerequisites[i][1], k-> new ArrayList<Integer>()).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        final Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0) queue.offer(i);
        }

        final List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){

            int node = queue.poll();

            result.add(node);
            for(int nextNode : adjMat.computeIfAbsent(node, k -> new ArrayList<>())){
                inDegree[nextNode]--;
                if(inDegree[nextNode]==0) queue.offer(nextNode);
            }
        }
        if(result.size()<numCourses) return new int[0];
        final int[] lol = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            lol[i] = result.get(i);
        }
        return lol;
    }
}
