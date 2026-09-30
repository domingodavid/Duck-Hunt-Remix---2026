import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * STUDENT FILE: object declarations.
 *
 * The Swing setup is provided. Students will add more Duck declarations and
 * add those objects to the GameWorld as the game progresses.
 */
public class Frame extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;

    // ===============================
    // STUDENT OBJECTS
    // ===============================
    private Duck duck1 = new Duck(150, 120);

    // STEP 6: Uncomment these one at a time, or create your own Ducks.
     private Duck duck2 = new Duck(380, 180);
    // private Duck duck3 = new Duck(620, 100);

    private Dog dogObject = new Dog();
    private GameWorld world = new GameWorld(dogObject);

    public Frame() {
        // STEP 6: Add each Duck to the world after declaring it above.
        world.addDuck(duck1);
         world.addDuck(duck2);
        // world.addDuck(duck3);

        world.start();

        setPreferredSize(new Dimension(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                world.handleClick(event.getX(), event.getY());
            }
        });

        JFrame window = new JFrame("Duck Hunt Remix");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setContentPane(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Timer timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        world.update();
        repaint();
    }

    public static void main(String[] args) {
        new Frame();
    }
}
