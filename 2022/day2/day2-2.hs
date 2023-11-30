getScore :: [String] -> Int
getScore ["A", "X"] = 3
getScore ["A", "Y"] = 4
getScore ["A", "Z"] = 8
getScore ["B", "X"] = 1
getScore ["B", "Y"] = 5
getScore ["B", "Z"] = 9
getScore ["C", "X"] = 2
getScore ["C", "Y"] = 6
getScore ["C", "Z"] = 7

main = interact $ show . sum . map (getScore . words) . lines