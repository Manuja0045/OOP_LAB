import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

/**
 * Author: Manuja Nagvekar
 * Roll No: 25
 * Title: Scrambled Word Game
 * Description: A fun game to test word recognition and guessing skills 
 * using scrambled words and images.
 */


 /**
 * ScrambledWordGame is a graphical user interface game where users guess 
 * the correct word from a scrambled version. The game can also include images 
 * associated with certain words.
 */
public class ScrambledWordGame extends JFrame {

    final List<String> wordList = new ArrayList<>();
    final List<WordWithImage> wordWithImageList = new ArrayList<>();
    int currentWordIndex = 0;
    String scrambledWord = "";
    int score = 0;
    boolean hintUsed = false;
    boolean imageMode = false;

    final JLabel scrambledWordLabel = new JLabel("", SwingConstants.CENTER);
    final JTextField guessInput = new JTextField("", SwingConstants.CENTER);
    final JButton guessButton = new JButton("Guess");
    final JButton hintButton = new JButton("Hint");
    final JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
    final JLabel scoreLabel = new JLabel("", SwingConstants.CENTER);
    final JButton nextButton = new JButton("Next");
    final JButton restartButton = new JButton("Restart");
    final JLabel imageLabel = new JLabel("", SwingConstants.CENTER);

    private final JButton scrambledWordButton = new JButton("Scrambled Word");
    private final JButton imageWithScrambledWordButton = new JButton("Images with Scrambled Word");

    private static final Dimension BUTTON_SIZE = new Dimension(400, 100);
    private static final Dimension BUTTON_DIMENSION = new Dimension(150, 40);

    final Font labelFont = new Font("Arial", Font.BOLD, 54);
    final Font buttonFont = new Font("Arial", Font.BOLD, 24);
    final Font scoreFont = new Font("Arial", Font.BOLD, 24);
    final Font hintFont = new Font("Arial", Font.BOLD, 24);
    final Font messageFont = new Font("Arial", Font.BOLD, 24);
    final Font guessInputFont = new Font("Arial", Font.PLAIN, 20);

    /**
     * Constructor to initialize the Scrambled Word Game.
     * Sets up the word lists and frame properties.
     */
    public ScrambledWordGame() {
        // Initialize word lists with logo names
        wordList.add("pepsi");
        wordList.add("spotify");
        wordList.add("toyota");
        wordList.add("nike");       
        wordList.add("apple");      
        wordList.add("adidas");     
    
        wordWithImageList.add(new WordWithImage("jaguar", "images/jaguar.jpg"));
        wordWithImageList.add(new WordWithImage("starbucks", "images/starbucks.jpg"));
        wordWithImageList.add(new WordWithImage("nestle", "images/nestle.jpg"));
        wordWithImageList.add(new WordWithImage("nike", "images/nike.jpg")); 
        wordWithImageList.add(new WordWithImage("apple", "images/apple.jpg")); 
        wordWithImageList.add(new WordWithImage("adidas", "images/adidas.jpg")); 
        
    
        // Set up frame
        this.setTitle("Scrambled Word Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        this.getContentPane().setBackground(Color.DARK_GRAY);

        add(createMenuPanel(), BorderLayout.CENTER);

        // Action listeners
        scrambledWordButton.addActionListener(e -> startScrambledWordGame());
        imageWithScrambledWordButton.addActionListener(e -> startImageWithScrambledWordGame());
    }

    /**
     * Creates the menu panel with game mode buttons.
     *
     * @return JPanel containing game mode options.
     */
    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints g = new GridBagConstraints();

        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(10, 10, 10, 10);
        g.anchor = GridBagConstraints.CENTER;

        scrambledWordButton.setFont(buttonFont);
        scrambledWordButton.setBackground(Color.GREEN);
        scrambledWordButton.setForeground(Color.BLACK);
        scrambledWordButton.setPreferredSize(BUTTON_SIZE);

        imageWithScrambledWordButton.setFont(buttonFont);
        imageWithScrambledWordButton.setBackground(Color.GREEN);
        imageWithScrambledWordButton.setForeground(Color.BLACK);
        imageWithScrambledWordButton.setPreferredSize(BUTTON_SIZE);

        g.gridx = 0;
        g.gridy = 0;
        menuPanel.add(scrambledWordButton, g);
        g.gridy++;
        menuPanel.add(imageWithScrambledWordButton, g);

        return menuPanel;
    }

    /**
     * Starts the scrambled word game mode.
     */
    void startScrambledWordGame() {
        imageMode = false;
        currentWordIndex = 0;
        startGame(wordList);
    }

    /**
     * Starts the image with scrambled word game mode.
     */
    void startImageWithScrambledWordGame() {
        imageMode = true;
        currentWordIndex = 0;
        startGame(wordWithImageList);
    }

    /**
     * Initializes and starts the game with the specified list of words.
     *
     * @param list List of words or WordWithImage to be used in the game.
     */
    void startGame(List<?> list) {
        // Clear the panel
        clearPanel();

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout());
        gamePanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.CENTER;

        guessInput.setFont(guessInputFont);
        scrambledWordLabel.setFont(labelFont);
        scrambledWordLabel.setForeground(Color.YELLOW);

        messageLabel.setFont(messageFont);
        messageLabel.setForeground(Color.PINK);
        messageLabel.setText("Welcome to the game");

        scoreLabel.setFont(scoreFont);
        scoreLabel.setForeground(Color.CYAN);
        scoreLabel.setText("Score: 0");

        guessInput.setEnabled(true);
        guessButton.setEnabled(true);
        hintButton.setEnabled(true);
        nextButton.setEnabled(true);

        // Guess button
        guessButton.setFont(buttonFont);
        guessButton.setForeground(Color.BLACK);
        guessButton.setBackground(Color.LIGHT_GRAY);
        guessButton.setPreferredSize(BUTTON_DIMENSION);

        // Hint button
        hintButton.setFont(buttonFont);
        hintButton.setForeground(Color.BLACK);
        hintButton.setBackground(Color.LIGHT_GRAY);
        hintButton.setPreferredSize(BUTTON_DIMENSION);

        // Next button
        nextButton.setFont(buttonFont);
        nextButton.setForeground(Color.BLACK);
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.setPreferredSize(BUTTON_DIMENSION);

        // Restart button
        restartButton.setFont(buttonFont);
        restartButton.setForeground(Color.BLACK);
        restartButton.setBackground(Color.LIGHT_GRAY);
        restartButton.setPreferredSize(BUTTON_DIMENSION);

        // Scrambled word label
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = GridBagConstraints.REMAINDER;
        gamePanel.add(scrambledWordLabel, g);

        // Image display
        if (imageMode) {
            g.gridy++;
            gamePanel.add(imageLabel, g);
        }

        // Textbox
        g.gridy++;
        guessInput.setPreferredSize(BUTTON_DIMENSION);
        gamePanel.add(guessInput, g);

        // Guess button and Hint button
        g.gridy++;
        g.gridwidth = 1;
        gamePanel.add(guessButton, g);

        g.gridx++;
        g.gridwidth = 2;
        gamePanel.add(hintButton, g);

        // Hint label
        g.gridx = 0;
        g.gridy++;
        g.gridwidth = 3;
        gamePanel.add(messageLabel, g);

        // Score label
        g.gridy++;
        g.gridwidth = 3;
        gamePanel.add(scoreLabel, g);

        // Next button and Restart button
        g.gridy++;
        g.gridwidth = 1;
        gamePanel.add(nextButton, g);

        g.gridx++;
        g.gridwidth = 2;
        gamePanel.add(restartButton, g);

        add(gamePanel, BorderLayout.CENTER);

        // Add action listeners
        guessButton.addActionListener(e -> checkGuess());
        hintButton.addActionListener(e -> checkHint());
        nextButton.addActionListener(e -> nextWord());
        restartButton.addActionListener(e -> restartGame());

        displayWord();
        revalidate();
        repaint();
    }

    /**
     * Shuffles the characters of a given word.
     *
     * @param word The word to shuffle.
     * @return A shuffled version of the word.
     */
    private String shuffleWord(String word) {
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder sw = new StringBuilder();
        for (char c : characters) {
            sw.append(c);
        }
        return sw.toString();
    }

    /**
     * Displays the current word in scrambled format.
     */
    private void displayWord() {
        if (imageMode) {
            WordWithImage wordWithImage = wordWithImageList.get(currentWordIndex);
            scrambledWord = shuffleWord(wordWithImage.getWord());
            scrambledWordLabel.setText(scrambledWord);
            imageLabel.setIcon(new ImageIcon(wordWithImage.getImagePath()));
        } else {
            String word = wordList.get(currentWordIndex);
            scrambledWord = shuffleWord(word);
            scrambledWordLabel.setText(scrambledWord);
        }
        guessInput.setText("");
        hintUsed = false;
        messageLabel.setText("Welcome to the game");
        revalidate();
        repaint();
    }

    /**
     * Checks the user's guess against the current word.
     */
    private void checkGuess() {
        String userGuess = guessInput.getText().toLowerCase().trim();
        if (imageMode) {
            String correctAnswer = wordWithImageList.get(currentWordIndex).getWord();
            if (userGuess.equals(correctAnswer)) {
                score++;
                scoreLabel.setText("Score: " + score);
                messageLabel.setText("Correct! The answer is: " + correctAnswer);
            } else {
                messageLabel.setText("Incorrect. Try again!");
            }
        } else {
            String correctAnswer = wordList.get(currentWordIndex);
            if (userGuess.equals(correctAnswer)) {
                score++;
                scoreLabel.setText("Score: " + score);
                messageLabel.setText("Correct! The answer is: " + correctAnswer);
            } else {
                messageLabel.setText("Incorrect. Try again!");
            }
        }
        guessInput.setText("");
        nextButton.setEnabled(true);
    }

    /**
     * Provides a hint to the user.
     */
    private void checkHint() {
        if (!hintUsed) {
            if (imageMode) {
                String correctAnswer = wordWithImageList.get(currentWordIndex).getWord();
                messageLabel.setText("Hint: The word starts with '" + correctAnswer.charAt(0) + "'");
            } else {
                String correctAnswer = wordList.get(currentWordIndex);
                messageLabel.setText("Hint: The word starts with '" + correctAnswer.charAt(0) + "'");
            }
            hintUsed = true;
        } else {
            messageLabel.setText("Hint already used!");
        }
    }

    /**
     * Moves to the next word in the game.
     */
    private void nextWord() {
        currentWordIndex++;
        if (imageMode && currentWordIndex >= wordWithImageList.size()) {
            currentWordIndex = 0; // Reset to the first image if out of bounds
        } else if (!imageMode && currentWordIndex >= wordList.size()) {
            currentWordIndex = 0; // Reset to the first word if out of bounds
        }
        displayWord();
        nextButton.setEnabled(false);
    }

    /**
     * Restarts the game and resets the score.
     */
    private void restartGame() {
        currentWordIndex = 0;
        score = 0;
        scoreLabel.setText("Score: 0");
        messageLabel.setText("Welcome to the game");
        displayWord();
    }

    /**
     * Clears the current panel.
     */
    private void clearPanel() {
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
    }

    /**
     * Main method to run the game.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScrambledWordGame game = new ScrambledWordGame();
            game.setVisible(true);
        });
    }
}

/**
 * WordWithImage is a class that represents a word along with its associated image.
 */
class WordWithImage {
    private String word;
    private String imagePath;

    /**
     * Constructor for WordWithImage.
     *
     * @param word     The word.
     * @param imagePath The image path associated with the word.
     */
    public WordWithImage(String word, String imagePath) {
        this.word = word;
        this.imagePath = imagePath;
    }

    public String getWord() {
        return word;
    }

    public String getImagePath() {
        return imagePath;
    }
}
