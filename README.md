# Invest Wise

**Invest Wise** is a personal finance and investment management app tailored for users in Egypt. It allows individuals to manage budgets, track investments, and securely access their financial data through a single linked bank account.

## Features

- User registration and login system
- Secure bank account linking (one per user)
- Budget tracking and investment logging
- Real-time financial summaries
- Secure database storage and user data handling

## Tech Stack

- **Database**: MySQL
- **Authentication**: Token-based (JWT)
- **Deployment**: Local server or cloud (e.g., Heroku)

## Getting Started

### Prerequisites

- c++
- pip
- Git
- MySQL installed and running

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
   pip install -r requirements.txt
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

```

---

Let me know if you'd like me to generate the `.env` template or `requirements.txt` as well.
```
