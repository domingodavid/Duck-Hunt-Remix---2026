# Duck Hunt Remix — Student Guide

You are remixing Duck Hunt into your own Halloween or fall-themed game.
Your target could be a duck, pumpkin, leaf, bat, apple, ghost, or anything
else you can draw or find an image for.

If you are starting by yourself, follow the steps in order. Run the game
before you change anything, make one small change at a time, and use the
graphic organizer to record what you expected and what you actually saw.

## Before you begin

1. Open this project in Eclipse. If it is not already in your workspace, use
   `File > Import > Existing Projects into Workspace`, then select this
   project folder.
2. In Package Explorer, expand `src` and open `Frame.java`.
3. Run `Frame.java` as a Java Application. The Run button may also say
   `Run Frame`.
4. If you add a new image file while Eclipse is open, select the project and
   press `F5` to refresh it.

The game window is 900 pixels wide and 600 pixels tall. The ground begins at
`GameWorld.GROUND_TOP`, which is y = 370. You do not need to memorize these
numbers; they are provided so your if statements and images can line up with
the game world.

## Your files

You will mainly edit:

- `Duck.java` — movement, bouncing, falling, and resetting
- `Dog.java` — retrieving the fallen Duck
- `Frame.java` — declaring and adding more Duck objects

All image files belong in `src/imgs`. The spelling and capitalization of an
image filename must match the filename in your Java code exactly.

Use `Duck Hunt Remix Graphic Organizer.pdf` while you work. It shows how
`Frame`, `GameWorld`, `Duck`, and `Dog` are related and gives you a place to
record what you changed and what you saw when you tested it.

Do not edit these files for the core assignment:

- `Sprite.java` — image loading and drawing framework
- `GameWorld.java` — three named Duck fields, direct update and drawing calls, and game rules
- `Background.java` — draws the sky
- `Foreground.java` — draws the ground
- `Tree.java` and `Bush.java` — draw scenery

The visual classes are drawn in layers: background, tree and ground scenery,
moving Ducks and Dog, then the stars/lives text. You can read these classes
to see how each object has a job, but keep your coding attention on the
student files.

## What each class does

- `Frame` creates the window, starts the timer, and declares the Duck objects.
- `GameWorld` stores `duck1`, `duck2`, and `duck3`. It calls each Duck's
  `update()` and `paint()` methods, and manages stars and the Dog.
- `Duck` controls movement, bouncing, falling, and resetting.
- `Dog` moves toward the fallen Duck and reports when retrieval is complete.
- `Background`, `Foreground`, `Tree`, and `Bush` draw scenery. They are
  framework classes for the core assignment.

## The most important habit: run and check

Do not write the whole game before running it. Work in small steps:

1. Save your file.
2. Run `Frame.java` as a Java Application in Eclipse.
3. Test only the behavior you just changed.
4. If it works, write down what you observed.
5. If it does not work, fix it before adding another feature.

You should be running the game after every numbered step below.

## Step 0: Run the starter

Run the program before changing anything.

You should see:

- A game window
- The background and ground
- A tree and bushes
- One Duck in the untouched starter, or two if you already enabled `duck2`
- A Dog at the bottom
- A stars/lives display

The Duck is intentionally incomplete. It will not have all of its behavior
until you complete the steps below.

## Step 1: Make the Duck move

Open `Duck.java` and find `update()`.

Uncomment the two movement lines:

```java
x = x + dx;
y = y + dy;
```

Run the game. The Duck should move in a straight line.

If it moves too quickly or slowly, change `dx` and `dy`, then run again.

## Step 2: Make the Duck bounce

Add `if` statements in `Duck.update()` that reverse `dx` or `dy` when the
Duck reaches an edge.

Test each edge. The Duck should remain on the screen instead of disappearing.

## Step 3: Make the Duck fall when clicked

In `startFalling()`, uncomment the lines that set:

```java
falling = true;
fallSpeed = 2;
```

Then uncomment and complete the falling code in `update()`.

Run the game and check that:

- Clicking the Duck makes it fall.
- The Duck stops at the ground.
- The Duck does not continue moving through the ground.

## Step 4: Check resetting

Read `Duck.reset()`. `activate()` calls it when the game starts. Run the game
again and check that the first Duck appears at its starting position. Later,
when you add the second and third Ducks, check that each one starts at the
position you gave it in `Frame.java`.

## Step 5: Make the Dog retrieve the Duck

Open `Dog.java` and complete `update()`.

Use `if` statements to:

- Move the Dog right when it is left of `targetX`.
- Move the Dog left when it is right of `targetX`.
- Decide when the Dog is close enough.
- Set `retrievedDuck` to `true` when the Dog arrives.
- Set `retrieving` to `false` when the retrieval is complete.

Run the game after each change. The Duck you click should disappear only
after the Dog reaches it. Once you add more Ducks, the others stay visible
while the Dog retrieves one.

## Step 6: Add more Duck objects

In `Frame.java`, uncomment or create more Duck declarations:

```java
private Duck duck2 = new Duck(380, 180);
private Duck duck3 = new Duck(620, 100);
```

Then add each one to the GameWorld:

```java
world.addDuck(duck2);
world.addDuck(duck3);
```

Run the game immediately after adding `duck2`. You should see two Ducks on
screen at the same time. Add `duck3`, run again, and check for three. They
should each appear at the starting position you chose in `Frame.java`.

If you still see one Duck, confirm that you uncommented **both** the
`private Duck duck2 = ...` line and the `world.addDuck(duck2);` line. Also
confirm that the two Ducks are not starting at the same position. The Dog
does not need to be finished for the second Duck to appear.

`GameWorld` has a separate field for each of the three Ducks. Read its
`update()` and `paint()` methods to see the direct calls for `duck1`, `duck2`,
and `duck3`. There is no collection to learn for this assignment.

## Step 7: Remix the theme

First make the game work with the original images. Then replace the images
with your own Halloween or fall theme.

### Replacing the Duck image

Change the image filename in the Duck constructor:

```java
super("your-image.png", startX, startY, 90, 90);
```

Put the new file inside `src/imgs`, then save, refresh Eclipse if needed, and
run the game. The last two numbers are the display width and height in
pixels. The original file's dimensions do not automatically determine its
size on the screen.

### Choosing a good size

- Start with `90, 90` for a Duck or other target.
- If the target is too small, increase both numbers. If it is too large,
  decrease both numbers.
- Try to keep the same width-to-height ratio as the original image. For
  example, a very wide image might use `120, 60` instead of `90, 90`.
- The display rectangle is also the click rectangle. If the rectangle is
  much larger than the visible picture, clicking may feel surprising.
- If the picture still looks tiny inside its rectangle, the file may have a
  large transparent border. Crop the image before using it.

### Replacing the Dog images

The Dog uses two filenames: one while waiting and one while retrieving.
Change both names in `Dog.java`:

```java
super("myDogStanding.png", 40, GameWorld.GROUND_TOP - DOG_HEIGHT,
        DOG_WIDTH, DOG_HEIGHT);
```

and inside `startRetrieving()`:

```java
changePicture("myDogRunning.png");
```

Both files must be inside `src/imgs`. Keep the two Dog images close to the
same size and shape so the Dog does not jump when its picture changes.

### PNG, GIF, and transparency hints

- PNG is usually the best choice for a still character because it can have a
  transparent background.
- GIF can also have transparency and can be animated. An animated GIF can
  make a target or Dog feel more alive without adding an animation loop to
  your Java code. Make sure the GIF really contains multiple frames.
- JPG is fine for a solid rectangular picture, but it usually does not have
  transparency, so a white or colored box may appear around the character.
- Use simple filenames such as `pumpkin.png` or `fall_target.gif`. Avoid
  spaces and make sure uppercase and lowercase letters match your code.

### Optional scenery remix

For the core assignment, do not edit the scenery classes. If your teacher
approves an extension, you can change the image and size in `Tree.java` or
`Foreground.java`, change the sky color in `Background.java`, or change the
Java shapes in `Bush.java`. The same rule applies: make one change, run the
game, and check what changed.

### Other easy settings

You may also change:

- Duck speed
- Dog speed
- Starting positions
- Window title

## Core requirements

Your finished game should have:

- A moving target object
- At least two bouncing directions or edge rules
- A target that falls when clicked
- A Dog object that retrieves it
- At least three Duck/target objects declared and instantiated
- The objects added to the GameWorld
- Stars/lives that decrease when the player misses
- A reset or next-object behavior
- A Halloween or fall theme

## Image sizing cheat sheet

| Object | Main code location | Starting display size |
| --- | --- | --- |
| Duck / target | `Duck.java` constructor | `90 x 90` |
| Dog | `Dog.java` constants | `69 x 94` |
| Tree | `Tree.java` | `173 x 260` |
| Ground | `Foreground.java` | `900 x 230` |

These are display sizes, not required file sizes. Your source image can be
larger or smaller; the `Sprite` class scales it to the numbers in the code.

## If something goes wrong

- **The console says it cannot find an image:** check that the file is in
  `src/imgs`, that the spelling and capitalization match, then press `F5`
  and run again.
- **The image has a box around it:** use a transparent PNG or GIF instead of
  a JPG.
- **The image looks stretched:** change the width and height so they match
  the image's shape more closely.
- **The image is too tiny even after changing the size:** crop away extra
  transparent space around the character.
- **The Dog changes to a blank picture:** check both Dog filenames. The first
  name is used at the start; the second name is used during retrieval.
- **The new Duck never appears:** check that you declared it and also called
  `world.addDuck(...)` in `Frame.java`, above `world.start()`. Give each Duck
  a different starting position. Added Ducks appear when the game opens,
  even if the Dog code is unfinished. This starter supports three Ducks.

## Extension ideas

- Give each of the three targets a different start position or movement rule.
- Activate two targets at the same time.
- Add a special target worth extra stars.
- Add a game-over restart button.
- Add sound.
- Make the Dog use different images while moving.
- Make each target move differently.
