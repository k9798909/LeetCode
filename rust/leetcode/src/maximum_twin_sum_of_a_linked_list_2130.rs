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

pub fn pair_sum(head: Option<Box<ListNode>>) -> i32 {
    let mut node = &head;
    let mut vec = Vec::new();
    while let Some(ref cur_node) = node {
        vec.push(cur_node.val);
        node = &cur_node.next;
    }

    let mut start = 0;
    let mut end = (vec.len() - 1) as usize;
    let mut max = 0;
    while start < end {
        let sum = vec[start] + vec[end];
        if sum > max {
            max = sum;
        }
        start += 1;
        end -= 1;
    }

    return max;
}
