# Architech

**Architech** is a personal finance and investment management app tailored for users in Egypt. It allows individuals to manage budgets, track investments, and securely access their financial data through a single linked bank account.

## Features

- User registration and login system
- Secure bank account linking (one per user)
- Budget tracking and investment logging
- Real-time financial summaries
- Secure database storage and user data handling

## Files Included
1. Core Components 
   - DatabaseConnector.java: Manages MySQL database connections 
   - UserData.java: Handles user profile information

2. Banking Module (Add_card/)
   - BankAccount.java: Base bank account class 
   - CardDBConnector.java: Links cards to database 
   - BankAccManager.java: Processes transactions

3. Authentication 

   Login:
     - LoginOperation.java: Main login logic 
        
     - LoginVerifier.java: Validates credentials
          
     - Verifiers (UsernameVerifier, PasswordVerifier)

   SignUp:
   
     - SignUpOperation.java: Registration handler 
      
     - Validators (EmailValidator.java, PasswordValidator.java,NameValidator.Java,UsernameValidator)


4. Zakat Calculation (zakat_calculation/)
   - ZakatCalculator.java: Main calculator 
   - Type-specific calculators (GoldZakatCalc.java, CryptoZakatCalc.java)
   - ZakatReport.java: Generates compliance reports


5. Asset Tracking (Assets/)
   - Portfolio.java: Manages investment portfolio 
   - AssetTypes.java: Defines asset categories


6. Data Files 
   - accountsDB.txt: Sample bank accounts 
   - users.txt: Store users credentials

## Tools Used
1. Development:
   - Java 11 
   - IntelliJ IDEA (Project file: Architech.iml)


2. Database:
   - Text files


3. Version Control: Git


## Getting Started

### Prerequisites
- java
- pip
- Git

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/invest-wise.git
   cd invest-wise
   ````

2. Create and activate a virtual environment:

   ```bash
   python -m venv env
   source env/bin/activate  # On Windows: env\Scripts\activate
   ```

3. Install dependencies:

   ```bash
   pip install -r CS251-2025-S16-Aya-Investment-20230560-20230440-20231088-SDS.pdf
   ```

4. Set up environment variables (DB URI, secret key, etc.) in a `.env` file.

5. Run the server:

   ```bash
   python app.py
   ```

## API Endpoints

* `POST /signup` – Register a new user
* `POST /login` – Authenticate user and return token
* `GET /dashboard` – Get user financial summary *(auth required)*
* `POST /investment` – Add investment entry *(auth required)*
* `POST /budget` – Set or update monthly budget *(auth required)*

## License

MIT License

---

*Invest smart. Live wise.* 💼
