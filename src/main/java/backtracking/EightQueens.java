package backtracking;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {

    public List<List<String>> solveNQueens(int n) {
        int[] subResult = new int[n];
        List<List<String>> result = new ArrayList<>();
        calNQueens(0, n, subResult, result);
        return result;
    }

    private void calNQueens(int row, int n, int[] subResult, List<List<String>> result) {
        if (row == n) {
            result.add(buildSubResult(subResult, n));
            return;
        }

        for (int column = 0; column < n; column++) {
            if (isOk(row, column, n, subResult)) {
                subResult[row] = column;
                calNQueens(row + 1, n, subResult, result);
            }
        }
    }

    private boolean isOk(int row, int column, int n, int[] subResult) {
        int leftUp = column-1;
        int rightUp = column+1;
        for (int i = row-1; i>=0;i--) {
            if (subResult[i] == column) {
                return false;
            }

            if (leftUp >=0) {
                if (subResult[i] == leftUp) {
                    return false;
                }
            }

            if (rightUp <= n) {
                if (subResult[i] == rightUp) {
                    return false;
                }
            }

            leftUp--;
            rightUp++;
        }
        return true;
    }

    private List<String> buildSubResult(int[] subResult, int n) {
        List<String> subResultList = new ArrayList<>(n);
        for (int row = 0; row < n; row++) {
            char[] rowResult = new char[n];
            for (int column = 0;column<n;column++) {
                rowResult[column] = subResult[row] == column ? 'Q' : '.';
            }
            subResultList.add(new String(rowResult));
        }
        return subResultList;
    }

    public static void main(String[] args) {
        System.out.println(new EightQueens().solveNQueens(4));
        System.out.println(new EightQueens().solveNQueens(8));
    }
}
