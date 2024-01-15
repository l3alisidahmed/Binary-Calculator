Feature: Binary Converter

  Scenario: Convert binary to octal
    Given binary input "110110"
    When converted to octal
    Then the result should be "66"
