package leetcode.day005;

/**
 * Dynamic Programming
 *
 * 1 2 3 5 8 : 피보나치 수열
 * f(n) = f(n-1)+ f(n-2)
 * f(5) = f(4)+f(3)
 * f(4) = f(3)+f(2)
 * 일반 재귀구현: 공간 복잡도 O(1), 시간 복잡도 O(2^n)
 * f(2) = 2
 * f(3) = 3
 * 다이나믹 프로그래밍: 공간 복잡도 O(n), 시간 복잡도 O(n)
 * 점화식 찾기
 */
public class ClimbingStairs {
    public int climbStairs(int n){
        // 예외처리
        if(n <= 0 ) return 0;
        if(n == 1) return 1;

        int[] d = new int[n+1];
        // 초기값
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++){
            d[i] = d[i-1] + d[i-2];  // 점화식
        }

        return d[n];

    }
}
