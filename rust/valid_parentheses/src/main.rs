fn main() {
    println!("Hello, world!");
}

pub fn is_valid(s: String) -> bool {
    if s.len() % 2 != 0 {
        return false;
    }

    let mut vec = Vec::new();
    const TUPLE1: (char, char) = ('(', ')');
    const TUPLE2: (char, char) = ('[', ']');
    const TUPLE3: (char, char) = ('{', '}');

    for i in 0..s.len() {
        let s1 = s.as_bytes()[i];
        let s1 = s1 as char;

        if vec.len() == 0 {
            vec.push(s1);
        }else if TUPLE1.eq(&(vec[vec.len() - 1],s1)) {
            vec.pop();
        } else if TUPLE2.eq(&(vec[vec.len() - 1],s1)) {
            vec.pop();
        } else if TUPLE3.eq(&(vec[vec.len() - 1],s1)) {
            vec.pop();
        } else {
            vec.push(s1);
        }
    }

    return vec.len() == 0;
}
