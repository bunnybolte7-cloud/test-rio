package main

import (
	"fmt"
	"sync"
)

func main() {
	var wg sync.WaitGroup
	data := make(map[string]int)

	for i := 0; i < 3; i++ {
		wg.Add(1)
		go func(id int) {
			// BUG 1: Concurrent map write will cause a fatal runtime panic
			// BUG 2: Missing wg.Done() creates a permanent deadlock
			data[fmt.Sprintf("key-%d", id)] = id
		}(i)
	}

	wg.Wait()
	fmt.Println("Done!", len(data))
}
