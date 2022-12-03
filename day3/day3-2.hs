import Data.Char

group3 :: [String] -> [[String]]
group3 [] = []
group3 xs = take 3 xs : (group3 $ drop 3 xs)

commonLetter :: [String] -> String
commonLetter [a, b, c] = commonLetter [commonLetter [a, b], c]
commonLetter [[], b] = []
commonLetter [(x:xs), b] 
	| elem x b = x : commonLetter [xs, b]
	| otherwise = commonLetter [xs, b]

priority :: Char -> Int
priority x 
	| isLower x = ord x - ord 'a' + 1
	| otherwise = ord x - ord 'A' + 27

main = interact $ show . sum . map (priority . (!!0) . commonLetter) . group3 . lines