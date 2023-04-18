pub fn merge_alternately(word1: String, word2: String) -> String {
    let word1 = word1.as_bytes();
    let word2 = word2.as_bytes();
    let mut i = (0,0);
    let mut rtn = String::from("");
    while i.0 < word1.len() || i.1 < word2.len() {
        if i.0 < word1.len() {
            rtn.push(word1[i.0] as char);
            i.0 += 1;
        } 
        
        if i.1 < word2.len() {
            rtn.push(word2[i.1] as char);
            i.1 += 1;
        }
    }
    return rtn;
}