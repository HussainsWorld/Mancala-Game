Overall, the chatGPT code provides a good starting point for approaching the code. However,
the code cannot be used as a definite way to do things as we learned better object 
oriented programming methods within this course. The code gave me a half implemented code
and told me where to place my implementations. This is good as chatGPT did its best given
the very little context it had. 

Variable and Method Names:
As I gave chatGPT the method and variable names themselves, chatGPT did a good job of creating
meaningful and descriptive variable and method names. It follows PascalCase when need be and 
camelCase when need be as well. The names are clear with what the respective functions do.
For example, setPlayers within the MancalaGame class adds players to the arrayList of players.

With respect to creating an object oriented program, chatGPT failed at keeping track of the 
method names from other functions and I had to tweak it a little bit in order to ensure it
really compiles. For example, it would call store.getStoneCount() when it should be 
store.getTotalStones(). Also, setPlayer() is supposed to be setOwner(). I gave chatGPT the
information for each method, and it still messed up. Also in MancalaGame, 
board.getStonesInStore(players.indexOf(player)) had to be changed to player.getStoreCount().
Thus, with respect to functionality and correctness, it is not complete. It provides a good
starting point, but it definitely needs to be edited as the code is not perfect.

There are also a couple of things within the AI code that don't meet checkstyle requirements.
Checkstyle is a follow of good practice for formatting and such. One thing I noted was the
hidden field from variables present in the Player class. Having these can lead to confusion and
errors within the code as well.

Encapsulation:
Member variables within the classes are private, which is good pracitce for encapsulation. 
However, all of the methods are listed as public. Some of these should be set to package
private when they are only going to be called in the package. The majority of MancalaGame
classes should be public as they are going to be called outside the class.

There does not seem to be much duplication within the code seen as it followed the instructions
I gave it with the methods and what they do. The overall structure of the code seems to adhere 
to the principle of having classes and methods with single, obvious responsibilities. 





