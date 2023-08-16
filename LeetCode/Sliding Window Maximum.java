class Solution {
    static class node {
        public int data;
        public int maximum;
        public node(int data, int maximum)
        {
            this.data = data;
            this.maximum = maximum;
        }
    }
 
    // it is a modification in the way
    // of implementation of queue using two stack
    static void insert(Stack<node> s2, int val)
    {
 
        // inserting the element in s2
        node other = new node(0, 0);
        other.data = val;
 
        if (s2.size() == 0)
            other.maximum = val;
        else {
            node front = s2.peek();
 
            // updating maximum in that stack push it
            other.maximum = Math.max(val, front.maximum);
        }
        s2.add(other);
        return;
    }
 
    static void delete(Stack<node> s1, Stack<node> s2)
    {
        // if s1 is not empty directly pop
        // else we have to push all element from s2 and
        // thatn pop from s1 while pushing from s2 to s1
        // update maximum variable in s1
        if (!s1.empty())
            s1.pop();
        else {
            while (!s2.empty()) {
                node val = s2.peek();
                insert(s1, val.data);
                s2.pop();
            }
            s1.pop();
        }
    }
 
    static int get_max(Stack<node> s1, Stack<node> s2)
    {
        // the maximum of both stack will be the maximum of
        // overall window
        int ans = -1;
        if (s1.size() > 0)
            ans = Math.max(ans, s1.peek().maximum);
        if (s2.size() > 0)
            ans = Math.max(ans, s2.peek().maximum);
        return ans;
    }
 
    static ArrayList<Integer> slidingMaximum(int a[], int b,
                                             int N)
    {
        // s2 for push
        // s1 for pop
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<node> s1 = new Stack<>(), s2 = new Stack<>();
 
        // shifting all value except the last one if first
        // window
        for (int i = 0; i < b - 1; i++)
            insert(s2, a[i]);
 
        for (int i = 0; i <= N - b; i++) {
            // removing the last element of previous
            // window as window has shift by one
            if (i - 1 >= 0)
                delete(s1, s2);
 
            // adding the new element to
            // the window as the window is shift by one
            insert(s2, a[i + b - 1]);
 
            ans.add(get_max(s1, s2));
        }
        return ans;
    }
}
