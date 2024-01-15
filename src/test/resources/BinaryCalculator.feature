Feature: Binary Converter

  Scenario: Convert binary to octal
    Given binary input "110110"
    When converted to octal
    Then the converted result should be "66"

  Scenario: Convert octal to binary
    Given octal input "7"
    When converted to binary
    Then the result should be "111"