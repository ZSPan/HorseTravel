package entity;

import java.util.Set;
import java.util.TreeSet;

public class Position implements Comparable<Position> {
    int x;//这个点的横坐标
    int y;//这个点的纵坐标
    int boardLength;//这个点所在的板的长
    int boardWidth; //这个点所在的板的宽
    Set<Position> exit;//出口位置的坐标
    int exitSize;//出口大小

    /*
    *位置的构造方法
    * */
    public Position(int x, int y, int boardLength, int boardWidth) {
        this.x = x;
        this.y = y;
        this.boardLength = boardLength;
        this.boardWidth = boardWidth;
        this.exit = new TreeSet<Position>();
    }

    public Position(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.boardLength = board.length;
        this.boardWidth = board.width;
    }

    public int compareTo(Position position) {
        if (this.exitSize > position.exitSize) {
            return 1;
        }
        if (this.exitSize < position.exitSize) {
            return -1;
        }
        if (this.x > position.x) {
            return 1;
        }
        if (this.x < position.x) {
            return -1;
        }
        if (this.y > position.y) {
            return 1;
        }
        if (this.y < position.y) {
            return -1;
        }
        return 0;
    }

    /*
    * 设置出口大小
    * */
    public void setExitSize() {
        this.exitSize = exit.size();
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
