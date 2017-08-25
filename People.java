
public class People implements Comparable<People> {
    public int no;//人员编号
    public int count = 100;//人员初始的money数目

    public People(int no) {
        this.no = no;
    }

    @Override
    public int compareTo(People o) {
        if (count > o.count) return 1;
        else if (count == o.count) return 0;
        else return -1;
    }
}
