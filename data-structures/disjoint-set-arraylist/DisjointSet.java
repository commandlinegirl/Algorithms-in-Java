import java.util.ArrayList;
import java.util.List;

/* Simple disjoint set implementation using ArrayList.
 * It uses an additional array for */
public class DisjointSet {
    private List<Integer> parent;
    private List<Integer> rank;

    public DisjointSet(int count) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    /* Finds a representative of the set */
    public int find(int i) {
        if (parent.get(i).equals(i)) {
            return i;
        } else {
            int result = find(parent.get(i));
            parent.add(i, result);
            return result;
        }
    }

    /* Unites the set that includes i and the set that includes j */
    public void union(int i, int j) {
        int rep_i = find(i);
        int rep_j = find(j);
        int rank_i = rank.get(i);
        int rank_j = rank.get(j);

        if (rep_i == rep_j) {
            return;
        }
        if (rank_i < rank_j) {
            parent.set(rep_i, rep_j);
        } else if (rank_j < rank_i) {
            parent.set(rep_j, rep_i);
        } else {
            parent.set(rep_i, rep_j); // any join is ok
            rank.set(rep_j, rank_j++); 
        }
    }  
}
