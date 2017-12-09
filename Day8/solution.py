#!/usr/bin/env python

from collections import defaultdict

register = defaultdict(int)
max_val = 0
with open("input.txt") as inputfile:
    for line in inputfile:
        var, instruction, value, _, var2, operator, value2 = line.replace("\n","").split()
        if eval(str(register[var2]) + operator + value2):
            if instruction == "inc":
                register[var] += int(value)
            else:
                register[var] -= int(value)
        if max(register.values()) > max_val:
            max_val = max(register.values())

print max_val
print(max(register.values()))