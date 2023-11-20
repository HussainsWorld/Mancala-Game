## captureStones()
| Description of Test               | Test Case          | Expected Results     |
|-----------------------------------|--------------------|----------------------|
| Pass in value under valid pit num | stoppingPoint = 0  | PitNotFoundException |
|-----------------------------------|--------------------|----------------------|
| Pass in value over valid pit num | stoppingPoint = 14  | PitNotFoundException |
|-----------------------------------|--------------------|----------------------|
| Pass in value invalid Capture pit | stoppingPoint = 2  | captureStones = 0    |
|-----------------------------------|--------------------|----------------------|
| Mimic stone landing into empty pit | stoppingPoint = 5  | captureStones = 5    |
|-----------------------------------|--------------------|----------------------|

## distributeStones()
| Description of Test               | Test Case          | Expected Results     |
|-----------------------------------|--------------------|----------------------|
| Pass in value under valid pit num | startingPoint = 0  | PitNotFoundException |
|-----------------------------------|--------------------|----------------------|
| Pass in value over valid pit num | startingPoint = 14  | PitNotFoundException |
|-----------------------------------|--------------------|----------------------|
| Pass in value invalid Capture pit | startingPoint = 5  | store1 = 1 && pit7 = 5    |
|-----------------------------------|--------------------|----------------------|
| Test stone skipping store  | startingPoint = 6  | store1 = 1 && store2 = 0 && pit1 = 5    |
|-----------------------------------|--------------------|----------------------|

## getNumStones()
| Description of Test               | Test Case          | Expected Results     |
|-----------------------------------|--------------------|----------------------|
| Pass in value under valid pit num | pitNum = 0  | PitNotFoundException |
|-----------------------------------|--------------------|----------------------|
| Pass in value for non-empty side | pitNum = 1  | False |
|-----------------------------------|--------------------|----------------------|
| Pass in value for empty side | pitNum = 2  | True    |
|-----------------------------------|--------------------|----------------------|

## isSideEmpty()
| Description of Test               | Test Case          | Expected Results     |
|-----------------------------------|--------------------|----------------------|
| Pass in value over valid pit num | pitNum = 14  | PitNotFoundException |
|-----------------------------------|--------------------|----------------------|
| Pass in value for pit to return value | pitNum = 3  | getNumStones = 4 |
|-----------------------------------|--------------------|----------------------|
| Pass in value under valid pit num | pitNum = 0  | PitNotFoundException    |
|-----------------------------------|--------------------|----------------------|

## resetBoard()
| Description of Test               | Test Case          | Expected Results     |
|-----------------------------------|--------------------|----------------------|
| Edit values then reset board | Remove Pit3 then reset | Pit1-12 = 4 |
|-----------------------------------|--------------------|----------------------|

## registerPlayers()
| Description of Test               | Test Case          | Expected Results     |
|-----------------------------------|--------------------|----------------------|
| Test two way connection | store owner and player store | Store owner = player store |
|-----------------------------------|--------------------|----------------------|




