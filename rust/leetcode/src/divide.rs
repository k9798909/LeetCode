fn main() {
    println!("x = {}" , divide(-2147483648,-1));
}

pub fn divide(dividend: i32, divisor: i32) -> i32 {
    let is_positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
    let dividend = dividend as i64;
    let divisor = divisor as i64;

    let dividend = dividend.abs();
    let divisor = divisor.abs();

    let dividend = dividend.to_string();
    let mut dividend = dividend.chars();

    let mut add = 0;
    let mut rtn = String::from("");
    loop {
        let mut num = match dividend.next() {
            Some(num)  => num.to_digit(10).unwrap() as i64,
            None => break,
        };
        
        let mut count = 0;
        let num = add.to_string() + &num.to_string();
        let mut num = num.parse::<i64>().unwrap();

        loop {
            if divisor > num {
                add = num;
                break;
            }
            num = num - divisor;
            count = count + 1;
        }
        rtn = rtn + &count.to_string();
    } 

    
    let mut rtn = rtn.parse::<i64>().unwrap();
    rtn = match is_positive {
        true => rtn,
        false => -rtn
    };

    if rtn > std::i32::MAX as i64 {
        return std::i32::MAX;
    } else {
        return rtn as i32;
    }
}
