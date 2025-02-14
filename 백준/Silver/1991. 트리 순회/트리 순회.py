import sys

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
    
class Tree:
    def __init__(self, root):
        self.root = root
    
    def preorder(self, node):
        print(node.data, end="")
        if (node.left != None):
            self.preorder(node.left)
        if (node.right != None):
            self.preorder(node.right)

    def inorder(self, node):
        if (node.left != None):
            self.inorder(node.left)
        print(node.data, end="")
        if (node.right != None):
            self.inorder(node.right)

    def postorder(self, node):
        if (node.left != None):
            self.postorder(node.left)
        if (node.right != None):
            self.postorder(node.right)
        print(node.data, end="")


if __name__ == "__main__":
    cnt = int(sys.stdin.readline())
    nodes = {}

    for i in range(cnt):
        name, left, right = sys.stdin.readline().split()

        if (name not in nodes):
            nodes[name] = Node(name)

        if (left != "." ):
            if (left not in nodes):
                nodes[left] = Node(left)
            nodes[name].left = nodes[left]
        
        if (right != "." ):
            if (right not in nodes):
                nodes[right] = Node(right)
            nodes[name].right = nodes[right]
    
    tree = Tree(nodes["A"])

    tree.preorder(tree.root)
    print()
    tree.inorder(tree.root)
    print()
    tree.postorder(tree.root)
