public class ErWeiShuZu {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        for(int x = 0; x < data.length; x++) {
            for(int y = 0; y < data[x].length; y++) {
                System.out.println("data["+x+"]["+y+"]="+data[x][y]);
            }
            System.out.println();
        }
    }
}