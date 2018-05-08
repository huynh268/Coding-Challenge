package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 5/7/2018.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
