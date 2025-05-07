# South African ID Validator

A Java library for validating South African ID numbers according to government specifications.

## Overview

This project implements a validator for South African ID numbers following the Test-Driven Development (TDD) approach. The validation checks ensure that ID numbers conform to the official format: `YYMMDDSSSSCAZ`, where:

- `YYMMDD`: Date of birth
- `SSSS`: Gender identifier (0000-4999 for females, 5000-9999 for males)
- `C`: Citizenship status (0 for South African citizens, 1 for permanent residents)
- `Z`: Checksum digit (calculated using the Luhn algorithm)

## Setup

This project uses Gradle as a build tool. To set up and run the project:

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Gradle 7.0+ (or use the included Gradle wrapper)

### Building the Project

```bash
# Clone the repository
git clone https://github.com/Sharleen10/validate_sa_id.git
cd validate_sa_id

# Build the project
./gradlew build
```

### Running Tests

```bash
./gradlew test
```

## Usage

To validate a South African ID number in your Java code:

```java
import com.yourdomain.validate_sa_id.ValidateSaId;

// Validate an ID number
boolean isValid = ValidateSaId.isIdNumberValid("2001014800086");
```

## Validation Rules

The validator checks:

1. **Format validation**:
   - Must be exactly 13 digits long
   - Must contain only numeric characters

2. **Date validation**:
   - Year (first 2 digits): Must form a valid year
   - Month (3rd and 4th digits): Must be between 01 and 12
   - Day (5th and 6th digits): Must be valid for the given month and year

3. **Gender validation**:
   - Digits 7-10 (SSSS): 0000-4999 for females, 5000-9999 for males

4. **Citizenship validation**:
   - 11th digit (C): Must be 0 (SA citizen) or 1 (permanent resident)

5. **Checksum validation**:
   - 13th digit (Z): Must satisfy the Luhn algorithm check

## Development Process

This project follows the Test-Driven Development (TDD) approach, which involves:

1. **RED**: Write a failing test
2. **GREEN**: Implement just enough code to make the test pass
3. **REFACTOR**: Clean up the code while ensuring all tests still pass

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- South African Department of Home Affairs for ID number specifications
- The TDD community for inspiration and best practices
