class BST
{   
    //Function to find the lowest common ancestor in a BST.
	Node LCA(Node node, int n1, int n2)
	{
	    //base case
        if (node == null) {
            return null;
        }
        
        //If both n1 and n2 are smaller than data at current node, we call 
    	//the function recursively for finding LCA in the left subtree.
        if (node.data > n1 && node.data > n2)
        {
            return LCA(node.left, n1, n2);
        }
        //If both n1 and n2 are greater than data at current node, we call 
    	//the function recursively for finding LCA in the right subtree.
        if (node.data < n1 && node.data < n2)
        {
            return LCA(node.right, n1, n2);
        }
        //returning the lowest common ancestor.
        return node;
    }
    
}
