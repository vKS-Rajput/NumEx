#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
#include <vector>
#include <functional>
#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>

class Main {
public:
    static void main() {
        // Create the main window
        sf::RenderWindow window(sf::VideoMode(300, 150), "NumEx");
        window.setFramerateLimit(60);

        // Create buttons
        std::vector<sf::Text> buttons(4);
        std::vector<int> btnCounters(3, 0);
        std::vector<int> randomNums(3);
        
        // Load font
        sf::Font font;
        font.loadFromFile("arial.ttf"); // Ensure you have the font file

        // Initialize buttons
        for (int i = 0; i < 3; ++i) {
            buttons[i].setFont(font);
            buttons[i].setString("0");
            buttons[i].setCharacterSize(30);
            buttons[i].setFillColor(sf::Color::White);
            buttons[i].setPosition(50 + i * 80, 50);
        }
        buttons[3].setFont(font);
        buttons[3].setString("Check");
        buttons[3].setCharacterSize(20);
        buttons[3].setFillColor(sf::Color::White);
        buttons[3].setPosition(110, 100);

        // Initialize random number generator
        std::srand(static_cast<unsigned int>(std::time(0)));
        for (int i = 0; i < 3; ++i) {
            randomNums[i] = std::rand() % 10;
        }

        // For debugging purposes: Print initial random numbers
        std::cout << randomNums[0] << " " << randomNums[1] << " " << randomNums[2] << std::endl;

        // Main loop
        while (window.isOpen()) {
            sf::Event event;
            while (window.pollEvent(event)) {
                if (event.type == sf::Event::Closed)
                    window.close();

                if (event.type == sf::Event::MouseButtonPressed) {
                    if (event.mouseButton.button == sf::Mouse::Left) {
                        for (int i = 0; i < 3; ++i) {
                            if (buttons[i].getGlobalBounds().contains(event.mouseButton.x, event.mouseButton.y)) {
                                btnCounters[i]++;
                                if (btnCounters[i] > 9) {
                                    btnCounters[i] = 0;
                                }
                                buttons[i].setString(std::to_string(btnCounters[i]));
                            }
                        }
                        if (buttons[3].getGlobalBounds().contains(event.mouseButton.x, event.mouseButton.y)) {
                            // Check button logic
                            // (Add your checking logic here)
                        }
                    }
                }
            }

            // Clear the window
            window.clear(sf::Color::Black);

            // Draw buttons
            for (const auto& button : buttons) {
                window.draw(button);
            }

            // Display the contents of the window
            window.display();
        }
    }
};

int main() {
    Main::main();
    return 0;
}

