package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseSchedule {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, GraphNode> courses = prepareGraph(prerequisites);
        Queue<GraphNode> s = new LinkedList<>();
        int[] ordered = new int[numCourses];
        int cur = 0;
        int i = 0;
        while (cur < numCourses) {
            GraphNode g = courses.get(cur);
            if (g == null) {
                ordered[i] = cur;
                i++;
            }
            else {
                if (!g.visited) {
                    if (dfs(g, s))
                        return new int[]{};
                }
            }
            cur++;
        }

        while (!s.isEmpty()) {
            ordered[i] = s.remove().val;
            i++;
        }
        return ordered;
    }

    private boolean dfs(GraphNode g, Queue<GraphNode> s) {
        boolean containsCycles = false;
        if (g == null)
            return false;
        g.setVisited(true);
        for (GraphNode n : g.adjacencies) {
            if (!n.visited)
                containsCycles = dfs(n, s);
            else if (!n.completed)
                return true;
        }
        s.add(g);
        g.setCompleted(true);
        return containsCycles;
    }

    private Map<Integer, GraphNode> prepareGraph(int[][] prerequisites) {
        Map<Integer, GraphNode> courses = new LinkedHashMap<>();
        for (int[] preq : prerequisites) {
            if (preq.length > 0) {
                int i = preq[0];
                GraphNode ig = courses.get(i);
                if (ig == null) {
                    ig = new GraphNode(i);
                    courses.put(i, ig);
                }
                if (preq.length > 1) {
                    int j = preq[1];
                    GraphNode jg = courses.get(j);
                    if (jg == null) {
                        jg = new GraphNode(j);
                        courses.put(j, jg);
                    }
                    ig.addAdjacency(jg);
                }
            }
        }
        return courses;
    }

}
