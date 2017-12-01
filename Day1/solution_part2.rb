#!/usr/bin/env ruby

f = File.read("input.txt")
comp_indx = f.length/2
sum = 0
compare = f[comp_indx]
f.each_char do |s|
    if compare.eql? s
        sum += s.to_i
    end

    comp_indx += 1
    if comp_indx >= f.length
        comp_indx = comp_indx - f.length
        compare = f[comp_indx]
    else
        compare = f[comp_indx]
    end
end

puts "TOTAL SUM: "+sum.to_s