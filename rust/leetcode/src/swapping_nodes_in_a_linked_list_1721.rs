// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}
pub fn swap_nodes(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
    let mut vec = Vec::new();
    let mut node = head;

    while let Some(curry_node) = node {
        vec.push(curry_node.val);
        node = curry_node.next;
    }

    let start = k as usize - 1;
    let end = vec.len() - k as usize;
    vec.swap(start, end);
    let mut ans: Option<Box<ListNode>> = None;
    for val in vec.iter().rev() {
        ans = Some(Box::new(ListNode {
            next: ans,
            val: *val,
        }));
    }
    ans
}
