import java.util.List;

/**
 * Created by sradloff on 3/8/15.
 */
public class WinCondition {
    private final int position1;
    private final int position2;
    private final int position3;


    public WinCondition(int position1, int position2, int position3) {
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
    }

    public boolean isTrue(List<String> cells){

        return cells.get(position1).equals(cells.get(position2)) &&
                cells.get(position3).equals(cells.get(position2)) &&
                !cells.get(position1).equals(" ");


    }
}
