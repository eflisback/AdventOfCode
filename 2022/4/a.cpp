#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <sstream>

int main()
{
    std::ifstream file("2022/4/data.txt");
    std::vector<std::string> lines;
    std::string line;
    while (std::getline(file, line))
    {
        lines.push_back(line);
    }
    file.close();

    int count = 0;

    for (const auto &line : lines)
    {
        int commaIndex = line.find(',');
        std::string first = line.substr(0, commaIndex);
        std::string second = line.substr(commaIndex + 1);

        int firstDashIndex = first.find('-');
        int secondDashIndex = second.find('-');

        int firstA, firstB, secondA, secondB;
        std::istringstream(first.substr(0, firstDashIndex)) >> firstA;
        std::istringstream(first.substr(firstDashIndex + 1)) >> firstB;
        std::istringstream(second.substr(0, secondDashIndex)) >> secondA;
        std::istringstream(second.substr(secondDashIndex + 1)) >> secondB;

        if ((firstA <= secondA && firstB >= secondB) || (secondA <= firstA && secondB >= firstB))
        {
            count += 1;
        }
    }
    std::cout << count << std::endl;

    return 0;
}
