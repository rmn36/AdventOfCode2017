#!/usr/bin/env python

with open('input.txt') as f:
    content = [x.split("\t") for x in [x.strip('\n') for x in f.readlines()]]

divs = []
for x in content:
    for i in x:
        for j in x:
            if (int(i)%int(j) == 0 and i != j):
                divs.append(int(i)/int(j))

print sum(divs)