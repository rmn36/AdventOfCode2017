package main

import (
    "bufio"
    "fmt"
    "log"
	"os"
	"strings"
)

func main() {
    file, err := os.Open("./input.txt")
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

	counter := 0
    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
		line := strings.Fields(scanner.Text())
		m := make(map[string]int)
		for _, element := range line {
			m[element] = 0
		}
		if len(line) == len(m) {
			counter += 1
		}
	}
	
	fmt.Println(counter)

    if err := scanner.Err(); err != nil {
        log.Fatal(err)
    }
}