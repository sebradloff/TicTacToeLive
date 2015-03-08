import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WinConditionTest {

    private WinCondition winCondition;
    private List<String> cells;
    @Before
    public void setUp(){
        winCondition = new WinCondition(0,1,2);
        cells = new ArrayList<String>();

    }
    @Test
    public void shouldHaveXAsWinnerWhenTheTopRowIsFilledWithXs(){


        cells.add("X");
        cells.add("X");
        cells.add("X");


        boolean aTrue = winCondition.isTrue(cells);
        assertThat(aTrue, is(true));
    }
    @Test
    public void shouldHaveNoWinnerWhenTheTopRowIsOnlyFilledWithOneX(){


        cells.add(" ");
        cells.add("X");
        cells.add(" ");

        boolean aTrue = winCondition.isTrue(cells);
        assertThat(aTrue, is(false));

    }
    @Test
    public void shouldHaveNoWinnerWhenTheTopRowDoesNotHaveThreeXsInARow(){
        cells.add("O");
        cells.add("X");
        cells.add("X");

        boolean aTrue = winCondition.isTrue(cells);
        assertThat(aTrue, is(false));
    }
    @Test
    public void shouldHaveNoWinnerWhenTheTopRowIsAllEmpty(){
        cells.add(" ");
        cells.add(" ");
        cells.add(" ");

        boolean aTrue = winCondition.isTrue(cells);
        assertThat(aTrue, is(false));
    }



}