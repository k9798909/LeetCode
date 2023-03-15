pub fn str_str(haystack: String, needle: String) -> i32 {
    let hay_len = haystack.len();
    let needle_len = needle.len();
    for i in 0..hay_len {
        let end = i + needle_len;
        let end = match end < hay_len {
            true => end,
            false => hay_len,
        };

        if haystack[i..end].eq(&needle) {
            return i as i32;
        }
    }
    return -1;
}
