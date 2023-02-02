# MinStack() initializes the stack object.
# void push(int val) pushes the element val onto the stack.
# void pop() removes the element on the top of the stack.
# int top() gets the top element of the stack.
# int getMin() retrieves the minimum element in the stack

class MinStack(object):

    def __init__(self):
        self.array = []

    def push(self, val):
        self.array.append(val)

    def pop(self):
        if(len(self.array) != 0):
            del self.array[len(self.array) - 1]

    def top(self):
        if(len(self.array) != 0):
            return self.array[len(self.array) - 1]
        else: 
            return 
            
    def getMin(self):
        return min(self.array)

# ["MinStack","push","push","push","getMin","pop","top","getMin"]
# [[],[-2],[0],[-3],[],[],[],[]]
