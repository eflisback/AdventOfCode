file = File.open("2022/3/data.txt", "r")
lines = file.readlines.map(&:chomp)
file.close

sum = 0
prio_is_index = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

for i in (0... lines.size).step(3)
    badge_char = (lines[i].chars & lines[i + 1].chars & lines[i + 2].chars).first
    sum += prio_is_index.index(badge_char)
end

puts sum