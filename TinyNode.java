/**
 * A doubly-linked node base-class for endogenous lists. Lists are circular
 * with a single sentinel node serving as the list header. Your class needs
 * to subclass TinyNode to play.
 */
public class TinyNode {
    private TinyNode prev;
    private TinyNode next;

    /** Make an isolated node. */
    public TinyNode() {
        this.prev = this.next = this;
    }

    /** Insert this node between p and n. Node must be isolated. */
    public void insert(TinyNode p, TinyNode n) {
        assert p != null && n != null; // valid nodes?
        assert this.prev == this && this.next == this; // isolated node?
        this.prev = p;
        this.next = n;
        p.next = n.prev = this;
    }

    /** Remove this node from between its neighbors. Node becomes isolated. */
    public void remove() {
        assert this.prev != null && this.next != null; // valid node?
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.prev = this.next = this;
    }

    /** Next node. Exists to allow covariant overriding. */
    public TinyNode next() {
        return this.next;
    }

    /** Previous node. Exists to allow covariant overriding. */
    public TinyNode prev() {
        return this.prev;
    }
}
