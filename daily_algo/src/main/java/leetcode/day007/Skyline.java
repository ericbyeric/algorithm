package leetcode.day007;

import java.util.*;
import java.util.stream.Collectors;

class Skyline {
    public static void main(String[] args) {
        int[][] testSet = {{0,2,3},{2,5,3}};
        int[][] testSet2 = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        var retset = getSkyline(testSet2);
        System.out.println(retset);
    }

    // 1. 자료구조 정의
    public static class Point {
        int x;
        int height;
        boolean start;
        public Point(int x, int height, boolean start){
            this.x = x;
            this.height = height;
            this.start = start;
        }
        public String toString(){
            return "x: "+ this.x + "\n height: " + this.height + "\n start: " + start;
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> list = new ArrayList<>();
        // 2. building parsing
        for (int[] b : buildings){
            list.add(new Point(b[0], b[2], true));
            list.add(new Point(b[1], b[2], false));
        }

        // 4.
        Collections.sort(list, (a, b) -> {
            if(a.x != b.x){
                return a.x - b.x;   // x의 오름차순
            } else if(a.start && !b.start){ // a는 시작지점, b는 종료지점일때
                // 시작점을 무조건 먼저 pq에 넣어준다
                return -1;
            } else if(!a.start && b.start){
                // b를 먼저 처리
                return 1;
            } else if(a.start && b.start){  // start가 같을 경우
                // 높은 빌딩부터 처리
                return b.height - a.height;  // 내림차순
            } else {  // !a.start && !b.start
                // 낮은 빌딩부터 처리
                return a.height - b.height;  // 오름차순
            }

        });

        // 3. 내림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, (a, b) -> b-a);
        pq.offer(0);    // 최후에는 0을 꼭 찍어 주어야 한다

        for(Point pp : list){
            System.out.println("pp = " + pp.toString());
        }
        System.out.println("initial pq: " + pq);
        System.out.println("loop start");
        System.out.println("---------------");

        List<List<Integer>> ret = new ArrayList<>();

        int count = 0;
        for(Point p : list){
            System.out.println("===============");
            System.out.println("pq process before: " + pq);
            int max = pq.peek();
            if(p.start){
                // add to pq
                pq.offer(p.height);
            } else {
                // remove from pq
                pq.remove(p.height);
            }
            System.out.println("pq process after: " + pq);
            // skyline(등고선)에 변화가 있을때
            if(pq.peek() != max){
                Integer[] arr = new Integer[2];
                arr[0] = p.x;
                arr[1] = pq.peek();
                var temp = Arrays.stream(arr).collect(Collectors.toList());
                ret.add(temp);
                System.out.println("ret value is added" + "x: " + p.x + " height: " + pq.peek());
                // ret.add(new int[]{p.x, pq.peek()})
            }
        }
        return ret;
    }
}
