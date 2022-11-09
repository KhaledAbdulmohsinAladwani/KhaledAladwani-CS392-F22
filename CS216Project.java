import java.util.*;

public class CS216Project {
    static int TotalCost = 99999999;

    public static void MinimumPath(int[][] Map, int number, int x, int y, int cost, int[][] visited) {
        int[] x_axis = { -1, 1, 0, 0 };
        int[] y_axis = { 0, 0, -1, 1 };

        for (int i = 0; i < x_axis.length; i++) {
            int nx = x + x_axis[i];
            int ny = y + y_axis[i];

            if (nx >= 0 && ny >= 0 && nx < number && ny < number && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                if (nx == number - 1 && ny == number - 1 && TotalCost > cost + Map[nx][ny]) {
                    TotalCost = cost + Map[nx][ny];
                }
                MinimumPath(Map, number, nx, ny, cost + Map[nx][ny], visited);
                visited[nx][ny] = 0;
            }

        }
    }

    public static void main(String[] args) {
        int number;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Colums and Rows number: \n");
        number = input.nextInt();
        int[][] visited = new int[number][number];
        int[][] Map = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                Map[i][j] = input.nextInt();
                visited[i][j] = 0;
            }
        }
        visited[0][0] = 1;
        int cost = Map[0][0];
        MinimumPath(Map, number, 0, 0, cost, visited);
        System.out.println("The total cost of the shortest path is = " + TotalCost);
    }
}
