/**
 * Author: Manuja Nagvekar
 * Roll No: 25
 * Title: Kick the Ball Game
 * Description: The KickTheBall class is a simple game where the player controls a platform
 * to Kick falling footballs using the arrow keys. The objective is to kick as 
 * many footballs as possible before running out of chances.
 */

 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The KickTheBall class is a simple game where the player controls a platform
 * to kick falling footballs using the arrow keys. The objective is to kick as 
 * many footballs as possible before running out of chances.
 */
public class KickheBall extends JPanel implements KeyListener, ActionListener {
    
    /** X position of the player's platform. */
    private int playerX = 250;

    /** X and Y positions of the falling football. */
    private int footballX, footballY = 0;

    /** Velocity of the football in X and Y directions. */
    private int footballVelocityX = 2;
    private int footballVelocityY = 5;

    /** Player's score, incremented when the player kicks a football. */
    private int score = 0;

    /** Number of chances the player has left to kick footballs. */
    private int chances = 5;

    /** Timer to control the game's updates (ball movement, score updates). */
    private Timer timer;

    /** Background image of the game */
    private Image backgroundImage;

    /** Image representing the football. */
    private Image ballImage;

    /** Image representing the player's platform. */
    private Image playerImage;

    /**
     * Constructor that sets up the game window, loads images, initializes the 
     * ball position, and starts the timer for ball movement.
     */
    public KickheBall() {
        setPreferredSize(new Dimension(600, 600));
        backgroundImage = new ImageIcon("images1/grass.jpg").getImage();
        ballImage = new ImageIcon("images1/ball.png").getImage();
        playerImage = new ImageIcon("images1/player.png").getImage();

        footballX = (int) (Math.random() * 550);
        timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    /**
     * Draws the game's background, player platform, football, score, and chances left.
     * If chances reach zero, the game is over and a "Game Over" message is displayed.
     *
     * @param g the Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.BLUE);
        g.drawImage(ballImage, footballX, footballY, 30, 30, this);
        g.drawImage(playerImage, playerX, 430, 100, 150, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 20, 30);
        g.drawString("Chances left: " + chances, 20, 60);
        if (chances == 0) {
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(Color.YELLOW);
            g.drawString("Game Over", 200, 300);
            timer.stop();
        }
    }

    /**
     * Handles the movement of the football and checks for collisions with the player's
     * platform or window boundaries. If the football is kicked, the score increases. 
     * If missed, the player loses a chance.
     *
     * @param e the ActionEvent triggered by the timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (chances > 0) {
            footballY += footballVelocityY;
            footballX += footballVelocityX;

            if (footballY + 30 >= 550 && footballX + 30 >= playerX && footballX <= playerX + 100) {
                footballVelocityY = -5;
                if (Math.random() < 0.5) {
                    footballVelocityX -= 2;
                } else {
                    footballVelocityX += 2;
                }
                score++;
            }

            if (footballY <= 0) {
                footballVelocityY = 5;
            }

            if (footballX <= 0 || footballX + 30 >= getWidth()) {
                footballVelocityX = -footballVelocityX;
            }

            if (footballY > 600) {
                chances--;
                resetFootball();
            }

            repaint();
        }
    }

    /**
     * Resets the football's position to the top and randomizes its horizontal position 
     * after it is missed by the player.
     */
    private void resetFootball() {
        footballY = 0;
        footballX = (int) (Math.random() * 550);
        footballVelocityY = 5;
        footballVelocityX = 2;
    }

    /**
     * Handles the movement of the player's platform based on the arrow keys.
     * The platform can be moved left or right within the boundaries of the window.
     *
     * @param e the KeyEvent representing a key press.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (chances > 0) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && playerX > 0) {
                playerX -= 20;
            }
            if (key == KeyEvent.VK_RIGHT && playerX < 500) {
                playerX += 20;
            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * The main method sets up the JFrame and adds the game to it. 
     * It initializes the window size and ensures proper exit behavior.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Catch the Ball Game");
        KickheBall game = new KickheBall();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
