local file = io.open("2022/5/data.txt", "r")
if not file then
    print("Error: Could not open the file.")
    return
end

local lines = {}

for line in file:lines() do
    table.insert(lines, line)
end

file:close()

local box_stacks = {}
local instructions_start_index

for line_index, line in ipairs(lines) do
    if line:find("^%s*1") then
        instructions_start_index = line_index + 2
        break
    else
        print(line)
        for i = 2, #line, 4 do
            local char = line:sub(i, i)
            if char ~= " " then
                print(char)
                local stack_index = math.ceil(i / 4)

                if not box_stacks[stack_index] then
                    box_stacks[stack_index] = {}
                end

                table.insert(box_stacks[stack_index], char)
            end
        end
    end
end

for i, stack in ipairs(box_stacks) do
    print("Stack", i, ":", table.concat(stack, " "))
end

for i = instructions_start_index, #lines do
    print(lines[i])
end
