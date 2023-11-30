import Data.List

main = interact $ show
	. maximum 
	. map sum 
	. map (map (\x -> if x == "" then 0 else read x))
	. groupBy (\x y -> x /= "" && y /= "") 
	. lines