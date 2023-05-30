pub fn reverse_words(s: String) -> String {
    return s
        .rsplit(' ')
        .filter(|&str| !str.is_empty())
        .collect::<Vec<&str>>()
        .join(" ");
}
