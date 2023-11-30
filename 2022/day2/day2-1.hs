getScore :: [String] -> Int
getScore ["A", "X"] = 4
getScore ["A", "Y"] = 8
getScore ["A", "Z"] = 3
getScore ["B", "X"] = 1
getScore ["B", "Y"] = 5
getScore ["B", "Z"] = 9
getScore ["C", "X"] = 7
getScore ["C", "Y"] = 2
getScore ["C", "Z"] = 6

main = interact $ show . sum . map (getScore . words) . lines