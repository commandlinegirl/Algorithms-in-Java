package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.CourseSchedule;
import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleTest {
    
//    @Test
//    public void testCourseSchedule1() {
//        CourseSchedule e = new CourseSchedule();
//        int[] result = e.findOrder(2, new int[][]{{1, 0}});
//        Assert.assertArrayEquals(new int[]{0, 1}, result);
//    }
//
//    @Test
//    public void testCourseSchedule2() {
//        CourseSchedule e = new CourseSchedule();
//        Assert.assertArrayEquals(new int[]{0,1,2,3}, e.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
//    }
//
//    @Test
//    public void testCourseSchedule3() {
//        CourseSchedule e = new CourseSchedule();
//        int[] result = e.findOrder(2, new int[][]{{1, 0}, {0, 1}});
//        Assert.assertArrayEquals(new int[]{}, result);
//    }
//
//    @Test
//    public void testCourseSchedule4() {
//        CourseSchedule e = new CourseSchedule();
//        int[] result = e.findOrder(2, new int[][]{{1}, {0}});
//        Assert.assertArrayEquals(new int[]{0, 1}, result);
//    }
//
//    @Test
//    public void testCourseSchedule5() {
//        CourseSchedule e = new CourseSchedule();
//        int[] result = e.findOrder(0, new int[][]{{}});
//        Assert.assertArrayEquals(new int[]{}, result);
//    }
//
//    @Test
//    public void testCourseSchedule6() {
//        CourseSchedule e = new CourseSchedule();
//        int[] result = e.findOrder(1, new int[][]{{}});
//        Assert.assertArrayEquals(new int[]{0}, result);
//    }

//    @Test
//    public void testCourseSchedule7() {
//        CourseSchedule e = new CourseSchedule();
//        int[] result = e.findOrder(7, new int[][]{{0, 1}, {1, 2}, {2,3}, {3,4}, {4,5}, {5,6}});
//        Assert.assertArrayEquals(new int[]{6,5,4,3,2,1,0}, result);
//    }

    @Test
    public void testCourseSchedule8_cycle() {
        CourseSchedule e = new CourseSchedule();
        int[] result = e.findOrder(8, new int[][]{{0, 1}, {1, 2}, {2,3}, {3,4}, {4,5}, {5,6}, {0,7}, {7,6}});
        Assert.assertArrayEquals(new int[]{6,5,4,3,2,1,0}, result);
    }
}

