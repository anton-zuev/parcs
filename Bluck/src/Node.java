import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Node implements Serializable {



    static int MAX_DEPTH = 50;

    private int id;
    private int time;
    public int xl, xr, yl, yr;

    public Node(int id) {
        this.id = id;
        this.time = 0;
        this.deps = new ArrayList<>();
    }


    public Node(int _id, int _xl, int _yl, int _xr, int _yr) {
        id = _id;
        xl = _xl;
        yl = _yl;
        xr = _xr;
        yr = _yr;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public List<Node> getDeps() {
        return deps;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addDep(Node dep) {
        deps.add(dep);
    }
}
