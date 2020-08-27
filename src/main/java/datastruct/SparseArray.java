package datastruct;


/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建原始数组
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][4] = 3;

        //从原始数组获取信息，数组大小和不为0元素个数
        int sum = 0;
        for (int i = 0;i<chessArray.length;i++){
            for (int j =0;j<chessArray.length;j++){
                if (chessArray[i][j] != 0) sum++;
            }
        }

        //创建稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int x = 0;x<11;x++){
            for (int y = 0;y<11;y++){
                if(chessArray[x][y] != 0) {
                    count++;
                    sparseArray[count][0] = x;
                    sparseArray[count][1] = y;
                    sparseArray[count][2] = chessArray[x][y];
                }
            }
        }


        //print
        for (int x =0;x<count+1;x++){
            for (int y = 0;y<3;y++){
                System.out.print(sparseArray[x][y]+"\t");
            }
            System.out.println();
        }

        //还原
        int count1 = 1;
        int cherryArrayCopy[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1;i<sparseArray.length;i++){
            cherryArrayCopy[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int i =0;i<11;i++){
            for (int j = 0;j<11;j++){
                System.out.print(cherryArrayCopy[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
