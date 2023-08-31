#User function Template for python3

''' structure of tree node:

class Node:
    def __init__(self,x):
        self.data=x
        self.left=None
        self.right=None
        self.height=1

'''

def getHeight(root):
   if root is None: return 0
   return root.height
def rightRotate(disbalancedNode):
   newRoot = disbalancedNode.left
   disbalancedNode.left = disbalancedNode.left.right
   newRoot.right = disbalancedNode
   disbalancedNode.height = 1 + max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right))
   newRoot.height = 1 + max(getHeight(newRoot.left), getHeight(newRoot.right))
   return newRoot
def leftRotate(disbalancedNode):
   newRoot = disbalancedNode.right
   disbalancedNode.right = disbalancedNode.right.left
   newRoot.left = disbalancedNode
   disbalancedNode.height = 1 + max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right))
   newRoot.height = 1 + max(getHeight(newRoot.left), getHeight(newRoot.right))
   return newRoot
def getBalance(root):
   if root is None: return 0
   return getHeight(root.left) - getHeight(root.right)
def getMinValueNode(root):
   if root is None or root.left is None:
       return root
   return getMinValueNode(root.left)
def deleteNode(root, key):
   if root is None:
       return root
   elif key < root.data:
       root.left = deleteNode(root.left, key)
   elif key > root.data:
       root.right = deleteNode(root.right, key)
   else:
       if root.left is None:
           curr = root.right
           root = None
           return curr
       if root.right is None:
           curr = root.left
           root = None
           return curr
       curr = getMinValueNode(root.right)
       root.data = curr.data
       root.right = deleteNode(root.right, curr.data)
       
   # get difference between leftsubtree and rightsubtree
   root.height = 1 + max(getHeight(root.left), getHeight(root.right))
   
   balance = getBalance(root)
   # left left condition:
   if balance > 1 and getBalance(root.left) >= 0:
       return rightRotate(root)
   # left right condition:
   elif balance > 1 and getBalance(root.left) < 0:
       root.left = leftRotate(root.left)
       return rightRotate(root) 
   # right right condition:
   elif balance < -1 and getBalance(root.right) <= 0:
       return leftRotate(root)
   # right left condition:
   elif balance < -1 and getBalance(root.right) > 0:
       root.right = rightRotate(root.right)
       return leftRotate(root)
   return root

