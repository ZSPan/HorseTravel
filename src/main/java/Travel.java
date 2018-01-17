import entity.Board;
import entity.Horse;

public class Travel {

    public static void main(String agrs[]) {
        long start = System.currentTimeMillis();
        Board board = new Board(5, 5);
        Horse horse = new Horse(board.positions[0][0], board);
        horse.travel();
        long end = System.currentTimeMillis();
        System.out.println("马周游路线数：" + horse.getCount());
        System.out.println(end - start + "ms");
    }
}
