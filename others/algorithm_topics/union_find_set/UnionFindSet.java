package others.algorithm_topics.union_find_set;

public class UnionFindSet {
    private int[] parent;
    private int count;
    private int[] level;
    public UnionFindSet(int count){
        this.count = count;
        parent = new int[this.count];
        level = new int[this.count];
        for (int i = 0; i < parent.length; ++i){
            parent[i] = i;
            level[i] = 1;
        }
    }

    public int Find(int q){
        while (parent[q] != q){
            q = parent[q];
        }
        return q;
    }

    public void Union(int p, int q){
        int root_p = Find(p);
        int root_q = Find(q);
        if(root_p == root_q){
            return;
        }
        if (level[root_p] > level[root_q]){
            parent[root_q] = root_p;
        }else if(level[root_p] < level[root_q]){
            parent[root_p] = root_q;
        }else{  // level[root_p] == level[root_q]
            parent[root_q] = root_p;
            level[root_p] += 1;
        }
    }
}