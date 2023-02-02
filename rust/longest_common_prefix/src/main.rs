pub fn longest_common_prefix(strs: Vec<String>) -> String {
    if strs.len() == 1 {
        return strs.get(0).unwrap().clone();
    }

    let mut prefix_str = strs.get(0).unwrap().clone();
    for str in strs {
        let min_len = if prefix_str.len() > str.len() {
            str.len()
        } else {
            prefix_str.len()
        };
        let mut rtn_str: Option<String> = None;
        for i in 0..min_len {
            let com_str1 = &str[0..i + 1];
            let com_str2 = &prefix_str[0..i + 1];
            if com_str1.eq(com_str2) {
                rtn_str = Some(com_str1.to_string());
            }
        }
        prefix_str = rtn_str.unwrap_or(String::from(""));
        
    }

    prefix_str
}

fn main() {
    let sss = longest_common_prefix(vec!["ab".to_string(), "a".to_string()]);
    println!("::::::{}", sss);
}