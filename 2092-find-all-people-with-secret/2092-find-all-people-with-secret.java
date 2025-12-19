class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        // Step 2: Set to track who knows the secret
        Set<Integer> hasSecret = new HashSet<>();
        hasSecret.add(0);
        hasSecret.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> participants = new HashSet<>();

            // Step 3: Gather all meetings happening at this time
            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                participants.add(x);
                participants.add(y);
                i++;
            }

            // Step 4: BFS among participants who already know the secret
            Queue<Integer> queue = new LinkedList<>();
            for (int p : participants) {
                if (hasSecret.contains(p)) {
                    queue.offer(p);
                }
            }

            Set<Integer> newlyInformed = new HashSet<>();
            while (!queue.isEmpty()) {
                int person = queue.poll();
                if (newlyInformed.contains(person)) continue;
                newlyInformed.add(person);

                for (int neighbor : graph.getOrDefault(person, Collections.emptyList())) {
                    if (!newlyInformed.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }

            // Step 5: Add all newly informed participants to the main secret set
            hasSecret.addAll(newlyInformed);
        }

        // Step 6: Return the result as a list
        return new ArrayList<>(hasSecret);
    }
}