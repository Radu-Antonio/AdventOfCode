-- cabal install --lib split
import Data.List.Split

includes :: [Int] -> Bool
includes [a, b, c, d] = (c <= a && b <= d) || (a <= c && d <= b)

getRange :: String -> [String]
getRange str = splitOn "-" f ++ splitOn "-" s
	where [f, s] = splitOn "," str

main = interact $ show . length . filter (includes . map read . getRange) . lines