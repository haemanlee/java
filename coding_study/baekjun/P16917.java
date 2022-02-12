package baekjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P16917 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strArr = input.split(" ");
        int A = Integer.parseInt(strArr[0]);
        int B = Integer.parseInt(strArr[1]);
        int C = Integer.parseInt(strArr[2]);
        int D = Integer.parseInt(strArr[3]);
        int E = Integer.parseInt(strArr[4]);

        // 양념 + 후라이드 > 2 * 반반 이면 반반을 2개 사서 나누는게 더 효율적
        int sum = 0;
        if(A + B > 2*C){
            if(E - D > 0){
               // 반반을 2개 사는더 더 싸다면 굳이 양념, 후라이드 가격을 주고 살 필요 없이 반반을 2개 사서 비용 최소화
               if( B > 2*C ){
                   sum = sum + 2*C*D + (E-D) * 2 * C;
               } else {
                   sum = sum + 2*C*D + (E-D) * B;
               }
            } else {
                if( A > 2*C ){
                    sum = sum + 2*C*E + (D-E) * 2 * C;
                } else {
                    sum = sum + 2*C*E + (D-E) * A;
                }
            }
        } else {
            sum = sum + A*D + B*E;
        }
        System.out.println(sum);

    }
}
