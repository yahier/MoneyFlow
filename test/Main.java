

import java.util.Arrays;
import java.util.Random;

/**
 * x个人，每个100块钱。每一次，每个人都随机给一块钱给另一个人。重复n次 看排行榜
 */
public class Main {
    final int exchangeTimes = 100;//重复的次数
    final int peopleNum = 100;
    People[] peoples = new People[peopleNum];

    public static final void main(String[] args) {
        Main main = new Main();
        main.init();
        main.exchange();
        main.showResult();
    }

    private void init() {
        for (int i = 0; i < peopleNum; i++) {
            peoples[i] = new People(i + 1);
        }
    }

    private void exchange() {
        Random random = new Random();
        for (int j = 0; j < exchangeTimes; j++) {
            for (int i = 0; i < peopleNum; i++) {
                peoples[i].count = (--peoples[i].count);
                //不能把钱给自己
                int index = random.nextInt(peopleNum - 1);//lucky guy
                if (index >= i) {
                    peoples[index + 1].count = (peoples[index + 1].count + 1);
                } else {
                    peoples[index].count = peoples[index].count + 1;
                }

            }
        }
    }

    private void showResult() {
        Arrays.sort(peoples);
        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i].no + ":" + peoples[i].count);
        }
    }
}
