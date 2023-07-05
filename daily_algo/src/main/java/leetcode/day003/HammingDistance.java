package leetcode.day003;

/**
 * Hamming distance:
 *  - bit연산의 기본적
 *  - bit가 다른 자릿수의 개수를 구하는 문제
 *
 * 문제 접근:
 *  - 두 수에 XOR를 취해서 1이 몇번 등장하는지 각 자릿수 만큼 체크해서 해당 count를 반환
 */
public class HammingDistance {

    public int hammingDistance(int x, int y){
        /*
        비트 연산의 기본
        a = 3 -> 이진수 11
        b = 2 -> 이진수 10

        a & b = 10 ; 두 비트가 모두 1이면 1, 아니면 0
        a | b = 11 ; 두 비트중 하나라도 1이면 1, 아니면 0
        a ^ b = 01 ; 두 비트가 다르면 1, 아니면 0


        Shift 연산
        a >> i ; a의 모든 비트를 오른쪽으로 i만큼 밀고, 맨 왼쪽은 0으로 채움
        a << 1 ; a의 모든 비트를 왼쪽으로 i만큼 밀고, 맨 오른쪽은 0으로 채움

        a >> 1 = 01 ;
        a << 1 = 10 ;
         */
        int xor = x ^ y;
        int cnt = 0;
        // int는 4byte - 32bit
        for(int i = 0; i<32; i++){
            cnt +=  ( xor >> i ) & 1;
        }
        return cnt;
    }
}
