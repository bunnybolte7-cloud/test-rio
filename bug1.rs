use std::thread;

fn main() {
    let mut numbers = vec![1, 2, 3];

    let handle = thread::spawn(move || {
        numbers.push(4);
        println!("Thread vector: {:?}", numbers);
    });

    // BUG 1: Borrow checker error. 'numbers' was moved into the closure above.
    numbers.push(5); 

    // BUG 2: The thread handle is never joined, so the program might exit before the thread finishes.
    println!("Main vector: {:?}", numbers);
}
