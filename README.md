# Invest Wise

**Invest Wise** is a personal finance and investment management app tailored for users in Egypt. It allows individuals to manage budgets, track investments, and securely access their financial data through a single linked bank account.

## Features

- User registration and login system
- Secure bank account linking (one per user)
- Budget tracking and investment logging
- Real-time financial summaries
- Secure database storage and user data handling

## Tech Stack

- **Database**: PostgreSQL / MongoDB
- **Authentication**: Token-based (JWT)
- **Deployment**: Local server or cloud (e.g., Heroku)

## Getting Started

### Prerequisites

- pip
- Git
- mySQL installed and running

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/invest-wise.git
   cd invest-wise
Create and activate a virtual environment:

bash
Copy
Edit
python -m venv env
source env/bin/activate  # On Windows: env\Scripts\activate
Install dependencies:

bash
Copy
Edit
pip install -r requirements.txt
Set up environment variables (DB URI, secret key, etc.) in a .env file.

Run the server:

bash
Copy
Edit
python app.py
API Endpoints
POST /signup – Register a new user

POST /login – Authenticate user and return token

GET /dashboard – Get user financial summary (auth required)

POST /investment – Add investment entry (auth required)

POST /budget – Set or update monthly budget (auth required)

License
MIT License
