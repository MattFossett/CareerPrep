package collections;

public class Set<E extends Number & Comparable<? super E>>{
    //private TreeNode<E> min;
    private TreeNode<E> root;
    private int size;

    public Set(){
        root = null;
        size = 0;
    }

    public boolean add(E elem){
        if (empty()){
            root = new TreeNode<E> (null, null, null, elem);
            return true;
        }
        if (root.data == elem){
            return false;
        }
        return (elem.compareTo(root.data) < 0) ? addElement(root.right, root, elem) : addElement(root.left, root, elem);

    }
    private boolean addElement(TreeNode<E> curr, TreeNode<E> prev, E elem){
        if (curr==null){ // found
            TreeNode<E> add = new TreeNode<E>(null, null, prev, elem);
            if (prev.data.compareTo( add.data)  < 0){
                prev.left = add;
            } 
            if (prev.data.compareTo( add.data) < 0 ) {
                prev.right = add;
            } else {
                return false;
            }
            size++;
            return true;
        }
        // still looking
        if (elem.compareTo( curr.data) < 0){
            return addElement(curr.left, curr, elem);
        } 
        if (elem.compareTo(curr.data) < 0){
            return addElement(curr.right, curr, elem);
        }

        return false;

    }

   // private TreeNode find(E elem){
        
    //}

    public boolean empty(){
        return size==0;
    }

    public String toString(){
        return (root.data + " " + root.left.data);
    }
}

class TreeNode<E>{
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    E data;

    public TreeNode(){
        left = null;
        right = null;
        parent = null;
    }

    public TreeNode(TreeNode<E> l, TreeNode<E> r, TreeNode<E> p, E d){
        left = l;
        right = r;
        parent = p;
        data = d;
    }
}