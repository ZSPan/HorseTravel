package entity;

public class Board {
    int length;//棋盘的长度
    int width;//棋盘的宽度
    int size;//棋盘的大小
    int everPcount;//棋盘已使用位置数量，当其等于位置总数时结束旅途
    public Position[][] positions;//用来存储这个板的所有位置

    /*
    * 棋盘的构造方法
    * */
    public Board(int length, int width) {
        this.length = length;
        this.width = width;
        this.size = length * width;
        this.positions = new Position[length][width];//初始化棋盘点阵
        this.everPcount = 0;//棋盘已使用位置初始化为0
        this.setPositions();//设置棋盘的各个位置
        this.setPositionExit();//设置棋盘的各个位置的出口
    }

    /*
    * 设置棋盘的各个位置
    * */
    public void setPositions() {
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                positions[x][y] = new Position(x, y, length, width);//建立板的每一个位置
                //或者positions[x][y] = new Position(x,y,this);
            }
        }
    }

    /*
    * 设置棋盘上点的出口
    * */
    public void setPositionExit() {
        int[] xIncrements = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yIncrements = {-1, 1, -2, 2, -2, 2, -1, 1};
        int changedX = 0;
        int changedY = 0;
        Position currentPosition = null;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                currentPosition = positions[x][y];
                for (int i = 0; i < xIncrements.length; i++) {//遍历这个点可能的八个落点，符合条件则加入出口exit
                    changedX = x + xIncrements[i];//改变后的横坐标
                    changedY = y + yIncrements[i];//改变后的纵坐标
                    if (changedX >= 0 && changedX < length && changedY >= 0 && changedY < width) {
                        currentPosition.exit.add(positions[changedX][changedY]);//将这个点的出口位置加入集合
                    }
                }
                currentPosition.setExitSize();//设置位置出口的大小
            }
        }
    }

}
