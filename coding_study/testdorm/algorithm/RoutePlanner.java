/*
As a part of the route planner, the routeExists method is used as a quick filter if the destination is reachable,
before using more computationally intensive procedures for finding the optimal route.

The roads on the map are rasterized and produce a matrix of boolean values - true if the road is present or false if it is not.
The roads in the matrix are connected only if the road is immediately left, right, below or above it.

Finish the routeExists method so that it returns true if the destination is reachable or false if it is not.
The fromRow and fromColumn parameters are the starting row and column in the mapMatrix.
The toRow and toColumn are the destination row and column in the mapMatrix.
The mapMatrix parameter is the above mentioned matrix produced from the map.

For example, the following code should return true since destination is reachable:
 */
package testdorm.algorithm;

import java.util.*;
// 방문을 표시하는 visited 2차원 배열을 만든다. 왜냐하면 방문을 했을 경우는 다시 돌아가지 않기 위해서다.

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        boolean[][] visited = new boolean[mapMatrix.length][mapMatrix[0].length];

        return isPath(toRow, toColumn, mapMatrix, fromRow, fromColumn, visited);
    }
    public static boolean isSafe(int i, int j, boolean[][] mapMatrix){
        if(i>=0 && i<mapMatrix.length && j>=0 && j<mapMatrix[0].length){
            return true;
        }
        return false;
    }

    public static boolean isPath(int toRow, int toColumn, boolean[][] mapMatrix, int i, int j, boolean[][] visited){
        //validation
        if(isSafe(i,j,mapMatrix) && mapMatrix[i][j] && !visited[i][j]){
            visited[i][j] = true;

            //terminate
            if(i == toRow && j == toColumn) return true;

            //recursive
            boolean up = isPath(toRow, toColumn, mapMatrix, i - 1, j, visited);
            if(up) return true;

            boolean left = isPath(toRow, toColumn, mapMatrix, i, j-1, visited);
            if(left) return true;

            boolean down = isPath(toRow, toColumn, mapMatrix, i+1, j, visited);
            if(down) return true;

            boolean right = isPath(toRow, toColumn, mapMatrix, i, j+1, visited);
            if(right) return true;

        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}