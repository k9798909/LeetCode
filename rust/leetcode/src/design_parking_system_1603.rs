struct ParkingSystem {
    big: Space,
    medium: Space,
    small: Space,
}

struct Space {
    num: i32,
}

impl Space {
    fn parking_car(&mut self) -> bool {
        match self.num {
            0 => false,
            _ => {
                self.num = self.num - 1;
                return true;
            }
        }
    }
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl ParkingSystem {
    fn new(big: i32, medium: i32, small: i32) -> Self {
        return ParkingSystem {
            big: Space { num: big },
            medium: Space { num: medium },
            small: Space { num: small },
        };
    }

    fn add_car(&mut self, car_type: i32) -> bool {
        match car_type {
            1 => self.big.parking_car(),
            2 => self.medium.parking_car(),
            3 => self.small.parking_car(),
            _ => false,
        }
    }
}
