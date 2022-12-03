import Data.Char

split :: String -> (String, String)
split a = splitAt (length a `div` 2) a

commonLetter :: (String, String) -> Char
commonLetter ([x], s2) = x
commonLetter ((x:xs), s2) 
	| elem x s2 = x
	| otherwise = commonLetter (xs, s2)

priority :: Char -> Int
priority x 
	| isLower x = ord x - ord 'a' + 1
	| otherwise = ord x - ord 'A' + 27

main = interact $ show . sum . map (priority . commonLetter . split) . lines