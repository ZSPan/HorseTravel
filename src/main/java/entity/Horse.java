package entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Horse {
    int travelCount;//马跳跃的次数
    int boardLength;//马所在棋盘的长度
    int boardWidth;//马所在棋盘的宽度
    Board board;
    Position[][] positions;//马所有可以走的位置
    Position currentPosition;//马当前的位置
    ArrayList<Position> trace;//马的足迹
    public int count;//从这个位置出发马周游的路线数

    /*
    * 马的构造方法
    * */
    public Horse(Board board) {
        this.board = board;
        this.boardLength = board.length;
        this.boardWidth = board.width;
        this.positions = board.positions;
        this.travelCount = 1;//当马出现时，记跳跃1次
        this.currentPosition = board.positions[0][0];//默认位置为棋盘上的（0，0）
        currentPosition.setUseable(false);//设置马的初始位置为不可用
        this.trace = new ArrayList<Position>(board.size);
        trace.add(this.travelCount - 1, this.currentPosition);//把当前位置加入足迹
    }

    public Horse(Position position, Board board) {
        this(board);
        this.currentPosition = position;
        currentPosition.setUseable(false);//设置马的初始位置为不可用
        this.trace = new ArrayList<Position>(board.size);
        trace.add(this.travelCount - 1, this.currentPosition);//把当前位置加入足迹
    }

    /*
    * 马的旅游方法
    * */
    public void travel() {
        if (this.trace.size() == this.board.size) {
            System.out.println("完成马周游");
            System.out.println("穷游路线图：");
            for (Position position : trace) {
                System.out.print(position + "→");
            }
            count++;
            System.out.println();
            return;
        }
        Iterator<Position> iterator = this.currentPosition.exit.iterator();//遍历马当前位置的出口
        while (iterator.hasNext()) {//还有出口时，试探其出口是否可用
            currentPosition = iterator.next();
            if (!trace.contains(currentPosition)) {//马的足迹中没有这个位置时
                trace.add(trace.size(), currentPosition);//将这个位置加入足迹
                travel();
                trace.remove(trace.size() - 1);//将此位置的足迹移除
            }
            currentPosition = trace.get(trace.size() - 1);//回到上一步
        }
        return;
    }

}

