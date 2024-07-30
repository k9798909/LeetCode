// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

use std::cell::RefCell;
use std::rc::Rc;
struct Solution {}

impl Solution {
    pub fn is_same_tree(
        p: Option<Rc<RefCell<TreeNode>>>,
        q: Option<Rc<RefCell<TreeNode>>>,
    ) -> bool {
        return match (p,q) {
            (None,None) => true,
            (None,Some(_)) => false,
            (Some(_),None) => false,
            (Some(p),Some(q)) => {
                p.borrow().val == q.borrow().val && 
                Self::is_same_tree(p.borrow().left.clone(), q.borrow().left.clone()) &&
                Self::is_same_tree(p.borrow().right.clone(), q.borrow().right.clone())
            }
        };
    }
}

