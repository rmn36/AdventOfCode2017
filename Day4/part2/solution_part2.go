package main

import (
    "bufio"
    "fmt"
    "log"
	"os"
	"strings"
	"sort"
)

func main() {
    file, err := os.Open("../input.txt")
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
			e := SortString(element)
			m[e] = 0
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

func SortString(w string) string {
    s := strings.Split(w, "")
    sort.Strings(s)
    return strings.Join(s, "")
}