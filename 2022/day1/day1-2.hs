import Data.List

main = interact $ show
	. sum 
	. take 3
	. reverse
	. sort
	. map sum 
	. map (map (\x -> if x == "" then 0 else read x))
	. groupBy (\x y -> x /= "" && y /= "") 
	. lines