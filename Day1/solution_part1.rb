#!/usr/bin/env ruby

f = File.read("input.txt")
sum = 0
previous = f[-1]
f.each_char do |s|
    if previous.eql? s
        sum += s.to_i
    end
    previous = s
end

puts sum