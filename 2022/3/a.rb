file = File.open("2022/3/data.txt", "r")
lines = file.readlines.map(&:chomp)
file.close

sum = 0
prio_is_index = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

lines.each do |line|
    second_compartment = line[line.size / 2..]

    line[..line.size / 2 - 1].each_char do |character|
        if second_compartment.include?(character)
            sum += prio_is_index.index(character)
            break
        end
    end
end

puts sum