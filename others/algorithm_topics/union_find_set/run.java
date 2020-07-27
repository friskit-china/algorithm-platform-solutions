package others.algorithm_topics.union_find_set;

public class run {
    public static void main(String[] argv){
        var ufs = new UnionFindSet(10);
        ufs.Union(0, 9);
        ufs.Union(1, 2);
        ufs.Union(9, 3);
        ufs.Union(9, 3);
        ufs.Union(0, 1);
        ufs.Union(1, 2);
        ufs.Union(2, 3);
        ufs.Union(3, 4);
        ufs.Union(4, 5);
        ufs.Union(5, 6);
        ufs.Union(6, 7);
        ufs.Union(7, 8);
        ufs.Union(8, 9);
    }
}