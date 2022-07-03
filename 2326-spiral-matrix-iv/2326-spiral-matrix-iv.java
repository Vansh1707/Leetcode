/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int[] row : matrix){
            Arrays.fill(row, -1);
        }
        int sr = 0 , sc = 0, dr = m-1, dc = n-1;
        while(head != null){
            for(int i=sr, j = sc ; j <= dc && head != null; j++){
                matrix[i][j] = head.val;
                head = head.next;
            }
            sr++;
            for(int i=sr, j = dc ; i <= dr && head != null; i++){
                matrix[i][j] = head.val;
                head = head.next;
            }
            dc--;
            for(int i=dr, j = dc ; j >= sc && head != null; j--){
                matrix[i][j] = head.val;
                head = head.next;;
            }
            dr--;
            for(int i=dr, j = sc ; i >= sr && head != null; i--){
                matrix[i][j] = head.val;
                head = head.next;
            }
            sc++;
        }
        return matrix;
    }
}