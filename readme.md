# Amul Protein Stock Checker

A Selenium-based stock monitoring tool that checks the availability of Amul High Protein Lassi products and sends Telegram notifications when stock becomes available.

## Features

- Checks stock availability automatically
- Monitors multiple Amul product pages
- Automatically enters delivery ZIP code
- Sends Telegram alerts when products are back in stock
- Runs locally with Maven
- Scheduled execution using GitHub Actions
- Headless Chrome support for CI/CD

## Products Monitored

- Amul High Protein Plain Lassi
- Amul High Protein Rose Lassi

## Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- GitHub Actions
- Telegram Bot API

## Project Structure

```
src/test/java
│
├── base
│   └── BaseTest.java
│
├── pages
│   └── WebPage.java
│
├── tests
│   └── StatusCheckTest.java
│
└── utils
    └── TelegramNotifier.java
```

## Setup

### Clone Repository

```bash
git clone https://github.com/xraghuveer/amul-protein-stock-checker.git
cd amul-protein-stock-checker
```

### Install Dependencies

```bash
mvn clean install
```

## Telegram Configuration

### Create Bot

1. Open Telegram
2. Search for @BotFather
3. Run:

```text
/newbot
```

4. Follow the instructions
5. Save the generated bot token

### Get Chat ID

1. Search for @userinfobot
2. Press Start
3. Copy your Chat ID

## Local Execution

Set environment variables:

### Mac/Linux

```bash
export BOT_TOKEN="YOUR_BOT_TOKEN"
export CHAT_ID="YOUR_CHAT_ID"
```

### Windows

```cmd
set BOT_TOKEN=YOUR_BOT_TOKEN
set CHAT_ID=YOUR_CHAT_ID
```

Run:

```bash
mvn clean test
```

## GitHub Actions Configuration

Create repository secrets:

Repository → Settings → Secrets and Variables → Actions

Add:

```text
BOT_TOKEN
CHAT_ID
```

The workflow runs automatically every 4 hours.

Workflow file:

```text
.github/workflows/stock-check.yml
```

## Notification Logic

When a product status is:

```text
Sold Out
```

No notification is sent.

When a product becomes available:

```text
Add to Cart
Available
In Stock
```

A Telegram notification is sent automatically.

Example:

```text
🚨 AMUL STOCK ALERT 🚨

Plain Lassi is available!

https://shop.amul.com/...
```

## Run Workflow Manually

GitHub Repository

Actions → Amul Stock Check → Run Workflow

## Future Improvements

- Prevent duplicate notifications
- Monitor additional products
- Store stock history
- Discord notifications
- Email notifications
- Database persistence

## Author

Raghuveer Singh