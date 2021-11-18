[33mcommit 538efcf958b720854553151fc558b379fa0d2a49[m[33m ([m[1;36mHEAD -> [m[1;32mmain[m[33m, [m[1;31morigin/main[m[33m, [m[1;31morigin/HEAD[m[33m)[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Tue Nov 16 20:08:33 2021 -0500

    Game over screen implemented with a new clase named GameOver that consists of game score and replay button if user wants to play the game again, a new line added users to limit their shooting area, a few bugs about bitmap collapsions were fixed. new styles added to the themes.xml folder for making the gameover screen functional like making it FullScreen etc. New task will be changing the gif, background, and button images for making game visually better that will take some time

[33mcommit a73e292b771f48a76caafdf387b73c77a0dab581[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Tue Nov 16 18:12:25 2021 -0500

    Health was implemented into game, Game over was implemented with a boolean variable that controlls the handler to finish the game, visualisation of the game over screen will be implemented also

[33mcommit 08d0af997902fc8514f44c5a72224e3385ea9b73[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Tue Nov 16 17:55:59 2021 -0500

    Collision detection implemented with the x,y coordinates and edges of the bitmaps with 4 conditions

[33mcommit 85462490cfc9811251cfa0691b1f5698b4fea90e[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Tue Nov 16 16:36:10 2021 -0500

    Math conditions added into the onDraw method. Now, if user started to drag the aimer, aimer can be drawn, also if user drags from left side to the right, or the opposite, by taking abs of the coordinates, simply if they are greater than 0, aimer also can be drawn. In addition, the item coming from the aimer was implemented in a one direction. When touch event stops, each variable values set to 0 for producing bitmaps again. There are still some bugs that I am trying to fix, I belive that they happened because of the usage of temporary png pictures like book and aimer images because of their sizes with x and y coordinates. They will be fixed eventually with the picture adjustments .

[33mcommit a420a313b60d2a468950c1d877a91c9e09394c13[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Tue Nov 16 15:38:00 2021 -0500

    Coordinates of the items to be shooted from aimer to be determined and the determined values were entered into the onTouchEvent

[33mcommit 3b2277bfa372287b9d4bcaa285d90420e7ff7895[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Mon Nov 15 17:06:54 2021 -0500

    Book and Aimer was implemented into the drawable and GameScreen functionally with the onTouchEvent, Some visual problems about the mentions of the png pictures occured. They will be fixed.

[33mcommit 73890847a3290c0067b0ddcfae07bbe29bf76d60[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Mon Nov 15 15:39:31 2021 -0500

    now, bitmaps can go the the most left side of the screen according to the their speeds and if they reach the left side according to their width which I take this value from tWidth() method that I created previously, their positions reset and starts from the right side of the screen again.

[33mcommit d819830642e8e2d407106e5418f45db8d83c07d4[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Mon Nov 15 11:07:39 2021 -0500

    New arraylist implemented for using more than 1 different bitmap-gifs. A for loop implemented in GameScreen to pass the context by adding objects in a list. Also in onDraw in GameScreen, instead of using old drawBitmap implementation, new one was implemented with for loop because my plan is to implement more than one bits now, and I put an if condition to control gif animation. After reaching the desired frame variable, it will reset itself.

[33mcommit e069e46f0e3eae02672de1ac0626e6e074fe1e1b[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Mon Nov 15 10:42:08 2021 -0500

    In Images.java 3 methods were implemented. tBitmap, tWidth, and tHeight. first one is for getting the bitmap according the frame variable, second and third one is for simply taking the bitmap's width and height.

[33mcommit f375e4a194e7ca7938c567cdaa29038368cddeca[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Mon Nov 15 10:33:55 2021 -0500

    Attributes of Gifs in the GameScreen class started to be implemented into the Images class

[33mcommit 6e6b99f10461a8768b599bf8dcab93b1331032a4[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Mon Nov 15 10:26:11 2021 -0500

    In order to create my bitmaps more organized, I created a new class that named Images, It will used to create objects with object oriented way

[33mcommit 26cf932dc884af61ac7893a5f96df3991c0179ed[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Sat Nov 6 21:25:47 2021 -0400

    Animated Bitmap created from 12 frame bit emoji GIF(For testing). Also random library implemented for spawning these objects from random positions from right side of the canvas to the left side with random speeds

[33mcommit 148453ac4f2cb4123d5d884407ce00337f5fb9d8[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Sat Nov 6 19:39:57 2021 -0400

    Canvas size fixed, x and y variable were created for finding the dimensions of the screen to fit canvas into screen by Display and Point classes that I imported

[33mcommit 217aa606a6955cc2a089860a2978252061ddebc3[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Fri Nov 5 18:28:21 2021 -0400

    new class GameScreen added,canvas created, new image background implemented, android manifest was changed based on new activity GameStart

[33mcommit 8bf0d7fc036fbc7313c0b4feb80718373ddcd84e[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Fri Nov 5 16:42:19 2021 -0400

    onClick event added to the play button, if user clicks the imagebutton, Play Button Clicked message appears in logcat, new class GameStart created

[33mcommit 8fc55c01208167aba9ffc2566a80bc09041fa6dc[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Fri Nov 5 15:50:56 2021 -0400

    Basic Main Menu screen implemented, some jpg pictures were uploaded, I will change them later for making it visually better, but it is basic now

[33mcommit 1d90d4b06cc4ed5baeabbce85b3594e2ab5a47f1[m
Author: Mertt Doğanay <MERTLOL3@outlook.com>
Date:   Thu Nov 4 18:08:43 2021 -0400

    Initial commit with empty activity

[33mcommit 00aa42a7cd8510a4372a8c7e4664cea5a5d7ccfb[m
Author: mertdgnyy <54585515+mertdgnyy@users.noreply.github.com>
Date:   Tue Nov 2 18:01:45 2021 -0400

    Initial commit
