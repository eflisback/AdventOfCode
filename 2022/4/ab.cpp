#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <sstream>

bool rangesOverlap(int rangeAStart, int rangeAEnd, int rangeBStart, int rangeBEnd)
{
    std::vector<int> rangeA;
    std::vector<int> rangeB;

    for (int i = rangeAStart; i <= rangeAEnd; i++)
    {
        rangeA.push_back(i);
    }
    for (int i = rangeBStart; i <= rangeBEnd; i++)
    {
        rangeB.push_back(i);
    }
    for (int i = 0; i < rangeA.size(); i++)
    {
        for (int j = 0; j < rangeB.size(); j++)
        {
            if (rangeA[i] == rangeB[j])
            {
                return true;
            }
        }
    }
    return false;
}

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

    int overlapCount = 0;
    int fullyContainCount = 0;

    for (const auto &line : lines)
    {
        int commaIndex = line.find(',');
        std::string first = line.substr(0, commaIndex);
        std::string second = line.substr(commaIndex + 1);

        int firstDashIndex = first.find('-');
        int secondDashIndex = second.find('-');

        int rangeAStart, rangeAEnd, rangeBStart, rangeBEnd;
        std::istringstream(first.substr(0, firstDashIndex)) >> rangeAStart;
        std::istringstream(first.substr(firstDashIndex + 1)) >> rangeAEnd;
        std::istringstream(second.substr(0, secondDashIndex)) >> rangeBStart;
        std::istringstream(second.substr(secondDashIndex + 1)) >> rangeBEnd;

        if ((rangeAStart <= rangeBStart && rangeAEnd >= rangeBEnd) || (rangeBStart <= rangeAStart && rangeBEnd >= rangeAEnd))
        {
            fullyContainCount += 1;
        }

        if (rangesOverlap(rangeAStart, rangeAEnd, rangeBStart, rangeBEnd))
        {
            overlapCount += 1;
        }
    }

    std::cout << fullyContainCount << std::endl;
    std::cout << overlapCount << std::endl;
    return 0;
}