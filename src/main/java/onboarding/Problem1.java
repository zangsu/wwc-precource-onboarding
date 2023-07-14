package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Problem1 {
    private static int Fail = -1;
    private static int PobiWin = 1;
    private static int CrongWin = 2;
    private static int Draw = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!assertInput(pobi, crong))
            return Fail;

        Game game = new Game();
        int pobiPoint = game.getPagePoint(pobi);
        int crongPoint = game.getPagePoint(crong);

        if(pobiPoint > crongPoint)
            return PobiWin;
        else if(pobiPoint == crongPoint)
            return Draw;
        else
            return CrongWin;

    }

    /**
     * @return
     * return true, input param is correct
     * return false else
     */
    private static boolean assertInput(List<Integer> pobi, List<Integer> crong){
        int correctSize = 2;

        if(pobi.size() != correctSize || crong.size() != correctSize)
            return false;

        if(pobi.get(0) % 2 != 1)
            return false;
        if(crong.get(0) % 2 != 1)
            return false;
        if(pobi.get(1) != pobi.get(0) + 1)
            return false;
        if(crong.get(1) != crong.get(0) + 1)
            return false;

        return true;
    }
}

class Game{
    public int getPagePoint(List<Integer> pages){

        List<Integer> pointList = new ArrayList<>();
        pointList.add(getPlusPoint(pages.get(0)));
        pointList.add(getMultPoint(pages.get(0)));
        pointList.add(getPlusPoint(pages.get(1)));
        pointList.add(getMultPoint(pages.get(1)));

        return pointList.stream().max(Integer::compareTo).get();
    }

    private int getPlusPoint(int page){
        int sum = 0;
        while(page != 0) {
            sum += page%10;
            page /= 10;
        }

        return sum;
    }

    private int getMultPoint(int page) {
        int mult = 1;
        while(page != 0) {
            mult *= page%10;
            page /= 10;
        }

        return mult;
    }
}