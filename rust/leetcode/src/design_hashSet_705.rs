struct MyHashSet {
    vec: Vec<bool>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyHashSet {
    fn new() -> Self {
        let vec = vec![false; 1000001];
        return MyHashSet { vec };
    }

    fn add(&mut self, key: i32) {
        self.vec[key as usize] = true;
    }

    fn remove(&mut self, key: i32) {
        self.vec[key as usize] = false
    }

    fn contains(&self, key: i32) -> bool {
        self.vec[key as usize]
    }
}
