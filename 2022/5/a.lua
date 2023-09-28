local file = io.open("2022/5/data.txt", "r")
local lines = {}

for line in file:lines() do
    table.insert(lines, line)
end

file:close()

for i, line in ipairs(lines) do
    -- print(tostring(i) .. ", " .. line)
end
