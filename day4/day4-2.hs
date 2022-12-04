import Data.List.Split

overlap :: [Int] -> Bool
overlap [a, b, c, d] = max a c <= min b d

getRange :: String -> [String]
getRange str = splitOn "-" f ++ splitOn "-" s
	where [f, s] = splitOn "," str

main = interact $ show . length . filter (overlap . map read . getRange) . lines