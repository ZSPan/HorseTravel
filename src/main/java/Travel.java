

import entity.Board;
import entity.Horse;

import java.util.Iterator;

public class Travel {

    public static void main(String agrs[]) {
        long start = System.currentTimeMillis();
        Board board = new Board(5, 5);
        Horse horse = new Horse(board.positions[2][2], board);
        horse.travel();
        long end = System.currentTimeMillis();
        System.out.println("马周游路线数：" + horse.count);
        System.out.println(end - start + "ms");
    }
}
