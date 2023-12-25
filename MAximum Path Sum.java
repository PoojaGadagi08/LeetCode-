A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000






int solve(BinaryTreeNode<int> *root,int &sum){

 

if(root==NULL){

return 0;

}

// getting max sum from left and right subtree

 

int leftsum=solve(root->left,sum);

int rightsum=solve(root->right,sum);

 

// max of root data, left tree including root , right tree including root, and sum of left right and root

 

int maxi=max(max(leftsum+rightsum+root->data,root->data),

max(root->data + leftsum,root->data + rightsum));

 

// updating sum

sum=max(sum,maxi);

 

int singlepath=max(root->data,max(root->data + leftsum,root->data + rightsum));

return singlepath;

}

 

int maxPathSum(BinaryTreeNode<int> *root)

{

// Write your code here

int sum=INT_MIN;

solve(root,sum);

return sum;

 

}

